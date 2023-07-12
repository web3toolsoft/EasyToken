package org.web3soft.commons.web.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.web3soft.commons.support.model.ResultEntity;
import org.web3soft.commons.support.util.ResultUtils;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * ResultEntity<T> 序列化输出转换类
 *
 * @author web3soft-team
 */
@Slf4j
public class ResultEntityHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public ResultEntityHttpMessageConverter() {
        log.debug("load {}", this.getClass().getName());
    }

    @Override
    protected void writeInternal(final Object object, final Type type, final HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        if (object instanceof ResultEntity) {
            super.writeInternal(object, type, outputMessage);
        } else {
            final ResultEntity<?> result = ResultUtils.success(object);
            super.writeInternal(result, type, outputMessage);
        }
    }

    @Override
    protected void writeInternal(final Object object, final HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        this.writeInternal(object, null, outputMessage);
    }
}
