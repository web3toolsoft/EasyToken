package org.web3soft.commons.security.xss;

/**
 * Xss过滤策略接口
 *
 * @author web3soft-team
 */
public interface FilterPolicy {
    /**
     * 执行Xss过滤方法
     *
     * @param input 原字符串
     * @return Xss过滤字符串
     */
    String filter(String input);
}

