package org.web3soft.commons.support.properties;

/**
 * @author web3soft-team
 */
public class InterceptorProperty {
    private String includeUrlPatterns = "";
    private String excludeUrlPatterns = "";

    public InterceptorProperty() {
    }

    public InterceptorProperty(final String includeUrlPatterns, final String excludeUrlPatterns) {
        this.includeUrlPatterns = includeUrlPatterns;
        this.excludeUrlPatterns = excludeUrlPatterns;
    }

    /**
     * 获取拦截器需要包含的url pattern(ant pattern 表达式)
     * 多个pattern用英文逗号(,)分隔
     *
     * @return include url pattern(ant pattern 表达式)
     * @see org.springframework.util.AntPathMatcher
     */
    public String getIncludeUrlPatterns() {
        return this.includeUrlPatterns;
    }

    /**
     * 设置拦截器需要包含的url pattern(ant pattern 表达式)
     * 多个pattern用英文逗号(,)分隔
     *
     * @param includeUrlPatterns include url pattern(ant pattern 表达式)
     * @see org.springframework.util.AntPathMatcher
     */
    public void setIncludeUrlPatterns(final String includeUrlPatterns) {
        this.includeUrlPatterns = includeUrlPatterns;
    }

    /**
     * 获取拦截器排除的url pattern(ant pattern 表达式)
     * 多个pattern用英文逗号(,)分隔
     *
     * @return Exclude url pattern(ant pattern 表达式)
     * @see org.springframework.util.AntPathMatcher
     */
    public String getExcludeUrlPatterns() {
        return this.excludeUrlPatterns;
    }

    /**
     * 设置拦截器排除的url pattern(ant pattern 表达式)
     * 多个pattern用英文逗号(,)分隔
     *
     * @param excludeUrlPatterns Exclude url pattern(ant pattern 表达式)
     * @see org.springframework.util.AntPathMatcher
     */
    public void setExcludeUrlPatterns(final String excludeUrlPatterns) {
        this.excludeUrlPatterns = excludeUrlPatterns;
    }
}
