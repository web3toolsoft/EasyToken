package org.web3soft.commons.security.xss;

/**
 * XssFilter过滤策略枚举
 *
 * @author web3soft-team
 */
public enum XssFilterPolicyEnum {
    /**
     * jsoup Xss Filter
     * {@link org.jsoup.Jsoup}
     */
    JSOUP("jsoup"),

    /**
     * Owasp Xss Filter
     * {@link org.owasp.encoder.Encode}
     */
    OWASP("owasp"),
    ;

    private final String name;

    XssFilterPolicyEnum(final String name) {
        this.name = name;
    }

    /**
     * 枚举名称
     *
     * @return 枚举名称
     */
    public String getName() {
        return this.name;
    }
}
