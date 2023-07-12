package org.web3soft.commons.web.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.owasp.encoder.Encode;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;


/**
 * [@RequestBody] Xss过滤器类
 *
 * @author web3soft-team
 */
public class XssJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public XssJackson2HttpMessageConverter() {
        super();
    }

    public XssJackson2HttpMessageConverter(final ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public Object read(final Type type, final Class<?> contextClass,
                       final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        final JavaType javaType = this.getJavaType(type, contextClass);
        final Object obj = this.readJavaType(javaType, inputMessage);
        final String json = super.getObjectMapper().writeValueAsString(obj);
        final String result = this.cleanXSS(json);
        return super.getObjectMapper().readValue(result, javaType);
    }

    private Object readJavaType(final JavaType javaType, final HttpInputMessage inputMessage) {
        try {
            return super.getObjectMapper().readValue(inputMessage.getBody(), javaType);
        } catch (final IOException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex,inputMessage);
        }
    }

    @Override
    protected void writeInternal(final Object object, final HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        final String json = super.getObjectMapper().writeValueAsString(object);
        final String result = this.cleanXSS(json);
        outputMessage.getBody().write(result.getBytes());
    }

    private String cleanXSS(final String value) {
        return Encode.forHtmlContent(value);
    }
}
