package org.web3soft.commons.lang.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.io.OutputStream;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供基于Jackson ObjectMapper的Utils类
 *
 * @author  web3soft-team
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public JsonUtil() {
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public static <T> T parseObject(final String text, final Class<T> type) {
        return parseObject(text, OBJECT_MAPPER.getTypeFactory().constructType(type));
    }

    public static ObjectNode parseJsonObject(final String json) {
        try {
            return OBJECT_MAPPER.readValue(json, ObjectNode.class);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    private static <T> T parseObject(final String text, final JavaType type) {
        try {
            return OBJECT_MAPPER.readValue(text, type);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static ArrayNode parseJsonArray(final String json) {
        try {
            return OBJECT_MAPPER.readValue(json, ArrayNode.class);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static <T> List<T> parseList(final String text, final Class<T> type) {
        if (StringUtils.isBlank(text)) {
            return Collections.emptyList();
        }
        try {
            final JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, type);
            return OBJECT_MAPPER.readValue(text, javaType);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static Map<String, Object> parseMap(final String text) {
        return parseMap(text, String.class, Object.class);
    }

    public static <K, V> Map<K, V> parseMap(final String text, final Class<K> k, final Class<V> v) {
        if (StringUtils.isBlank(text)) {
            return Collections.emptyMap();
        }
        try {
            final JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructMapType(HashMap.class, k, v);
            return OBJECT_MAPPER.readValue(text, javaType);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static String toJSONString(final Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static void writeJSONString(final OutputStream out, final Object object) {
        try {
            OBJECT_MAPPER.writeValue(out, object);
        } catch (final Throwable e) {
            throw new JacksonJsonUtilsException(e.getMessage(), e);
        }
    }

    public static ObjectNode createNode() {
        return OBJECT_MAPPER.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return OBJECT_MAPPER.createArrayNode();
    }

    public static JavaType createType(final Class<?> clazz) {
        return OBJECT_MAPPER.getTypeFactory().constructType(clazz);
    }

    public static JavaType createJavaType(final Class<?> collectionClass, final Class<?>... elementClasses) {
        return OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static class JacksonJsonUtilsException extends RuntimeException {
        @Serial
        private static final long serialVersionUID = -3086250821650407352L;

        public JacksonJsonUtilsException() {
        }

        public JacksonJsonUtilsException(final String message) {
            super(message);
        }

        public JacksonJsonUtilsException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}