package org.web3soft.commons.support.util;

import org.web3soft.commons.support.enums.ErrorCode;
import org.web3soft.commons.support.model.ResultEntity;

/**
 * SpringMVC Response Result 工具类
 *
 * @author web3soft-team
 */
public class ResultUtils {
    /**
     * @return ResultEntity<Object>
     */
    public static ResultEntity<?> success() {
        return ResultUtils.success(null);
    }

    /**
     * @param data
     * @param <T>
     * @return ResultEntity<T>
     */
    public static <T> ResultEntity<T> success(final T data) {
        return ResultUtils.build(0, "", data);
    }

    /**
     * 该方法用于手动指定错误提示信息
     * 而不是从错误码的枚举中读取本地化的提示信息
     * 如果需要提示信息本地化请不要使用该方法,请使用{@link ResultUtils#failure(ErrorCode)}
     *
     * @param msg
     * @return ResultEntity<Object>
     */
    public static ResultEntity<?> failure(final String msg) {
        return ResultUtils.failure(-1, msg);
    }

    /**
     * @param errorCode
     * @return ResultEntity<Object>
     */
    public static ResultEntity<?> failure(final ErrorCode errorCode) {
        return ResultUtils.failure(errorCode, null);
    }

    /**
     * @param errorCode
     * @param data
     * @param <T>
     * @return ResultEntity<T>
     */
    public static <T> ResultEntity<T> failure(final ErrorCode errorCode, final T data) {
        return ResultUtils.build(errorCode.getCode(), errorCode.getMessage(), data);
    }

    /**
     * @param code
     * @param msg
     * @return ResultEntity<Object>
     */
    public static ResultEntity<?> failure(final int code, final String msg) {
        return ResultUtils.build(code, msg, null);
    }

    /**
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return ResultEntity<T>
     */
    private static <T> ResultEntity<T> build(final int code, final String msg, final T data) {
        return new ResultEntity<>(code, msg, data);
    }
}
