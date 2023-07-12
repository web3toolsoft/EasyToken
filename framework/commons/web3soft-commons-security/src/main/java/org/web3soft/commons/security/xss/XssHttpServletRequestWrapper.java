package org.web3soft.commons.security.xss;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

/**
 * XSS过滤器http请求包装类
 *
 * @author web3soft-team
 */
@Slf4j
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final FilterPolicy filterPolicy;
    private final String excludeUrlPatterns;

    /**
     * <p>Constructor for XssHttpServletRequestWrapper.</p>
     *
     * @param servletRequest     a {@link jakarta.servlet.http.HttpServletRequest} object.
     * @param filterPolicy       a {@link FilterPolicy} object.
     * @param excludeUrlPatterns a {@link String} object.
     */
    public XssHttpServletRequestWrapper(final HttpServletRequest servletRequest,
                                        final FilterPolicy filterPolicy,
                                        final String excludeUrlPatterns) {
        super(servletRequest);
        this.filterPolicy = filterPolicy;
        this.excludeUrlPatterns = excludeUrlPatterns;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getParameterValues(final String parameter) {
        final String[] values = super.getParameterValues(parameter);
        if (values == null || this.isExcludedUrl(this.getRequestURL().toString())) {
            return values;
        }

        final int count = values.length;
        final String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = this.cleanXSS(values[i]);
        }
        return encodedValues;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParameter(final String parameter) {
        final String value = super.getParameter(parameter);
        if (value == null || this.isExcludedUrl(this.getRequestURL().toString())) {
            return value;
        }
        return this.cleanXSS(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHeader(final String name) {
        final String value = super.getHeader(name);
        if (value == null || this.isExcludedUrl(this.getRequestURL().toString())) {
            return value;
        }
        return this.cleanXSS(value);
    }

    private String cleanXSS(final String value) {
        final String filteredValue = this.filterPolicy.filter(value);
        log.debug("Xss Filter raw:{},filtered:{}", value, filteredValue);
        return filteredValue;
    }

    private boolean isExcludedUrl(final String url) {
        final String[] patterns = StringUtils.split(this.excludeUrlPatterns, ',');
        if (patterns == null) {
            return false;
        }

        for (final String pattern : patterns) {
            if (this.pathMatcher.match(StringUtils.trim(pattern), url)) {
                log.debug("Xss Filter Excluded Url:{},pattern:{}", url, pattern);
                return true;
            }
        }
        return false;
    }
}
