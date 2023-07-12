package org.web3soft.commons.security.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基于http header referer方式的crsf实现
 *
 * @author web3soft-team
 * @see <a href="https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html">CSRF</a>
 */
@Slf4j
public class CsrfInterceptor implements AsyncHandlerInterceptor {
    private static final String HEADER_REFERER = "Referer";
    private static final String HEADER_X_CSRF = "x-csrf";
    private static final String ALL = "all";
    private static final String METHOD_OF_GET = "get";
    private static final String HTTP_PROTOCOL = "http://|https://";
    private final Pattern pattern;

    /**
     * <p>Constructor for </p>
     *
     * @param pattern a {@link String} object.
     */
    public CsrfInterceptor(final String pattern) {
        this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        if (METHOD_OF_GET.equalsIgnoreCase(request.getMethod()) || StringUtils.equalsIgnoreCase(ALL, this.pattern.pattern())) {
            return true;
        }

        String referer = StringUtils.defaultIfBlank(request.getHeader(HEADER_REFERER), StringUtils.EMPTY);
        referer = referer.replace("&#47;", "/");
        final String removeHttpRef = RegExUtils.replaceAll(StringUtils.lowerCase(referer), HTTP_PROTOCOL, "");
        final Matcher matcher = this.pattern.matcher(removeHttpRef);
        if (matcher.find()) {
            return true;
        }

        final String urlAndReferer = String.format("request-url:%s;referer:%s", request.getRequestURL().toString(), referer);
        log.info("x-csrf:{}", urlAndReferer);
        response.setHeader(HEADER_X_CSRF, urlAndReferer);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return false;
    }
}
