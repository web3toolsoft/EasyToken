package org.web3soft.commons.security.xss;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * XSS过滤器
 *
 * @author web3soft-team
 * @see <a href="https://en.wikipedia.org/wiki/Cross-site_scripting">XSS</a>
 */
public class XssFilter extends OncePerRequestFilter {
    /**
     * Constant <code>FILTER_POLICY="filterPolicy"</code>
     */
    public final static String FILTER_POLICY = "filterPolicy";
    /**
     * Constant <code>EXCLUDE_URL_PATTERNS="excludeUrlPatterns"</code>
     */
    public final static String EXCLUDE_URL_PATTERNS = "excludeUrlPatterns";
    private FilterPolicy filterPolicy = null;
    private String excludeUrlPatterns = null;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initFilterBean() throws ServletException {
        final String policyName = Objects.requireNonNull(this.getFilterConfig()).getInitParameter(XssFilter.FILTER_POLICY);
        this.excludeUrlPatterns = this.getFilterConfig().getInitParameter(XssFilter.EXCLUDE_URL_PATTERNS);
        this.filterPolicy = this.createFilterPolicy(policyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(final HttpServletRequest httpServletRequest,
                                    final HttpServletResponse httpServletResponse,
                                    final FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(
                new XssHttpServletRequestWrapper(httpServletRequest, this.filterPolicy, this.excludeUrlPatterns),
                httpServletResponse
        );
    }

    private FilterPolicy createFilterPolicy(final String policyName) {
        if (StringUtils.equalsIgnoreCase(policyName, XssFilterPolicyEnum.JSOUP.getName())) {
            return new JsoupFilterPolicy();
        }
        return new OwaspFilterPolicy();
    }
}
