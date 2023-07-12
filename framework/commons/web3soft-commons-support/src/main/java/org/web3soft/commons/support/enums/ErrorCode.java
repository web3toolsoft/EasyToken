package org.web3soft.commons.support.enums;

/**
 * @author web3soft-team
 **/
public interface ErrorCode {
    /**
     * 获取错误代号
     *
     * @return 错误代号
     */
    int getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();

    /**
     * 获取错误信息
     *
     * @param args 信息中的参数
     * @return 包括参数的错误信息
     */
    String getMessage(Object... args);

    /**
     * 设置提示信息中的参数
     *
     * @param args 信息中的参数
     * @return {@link  ErrorCode}
     */
    ErrorCode arguments(Object... args);
}
