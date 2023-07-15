package org.web3soft.spring.boot.autoconfigure.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.web3soft.commons.support.codec.DigestCryptService;
import org.web3soft.commons.support.codec.FeignHeaderEnum;

import java.time.Instant;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author web3soft-team
 */
@Slf4j
public class HeaderRequestInterceptor implements RequestInterceptor {

    private final static String[] LOCALE_HEADERS = {"x-locale", "accept-language"};

    private final DigestCryptService digestCryptService;

    public HeaderRequestInterceptor(final DigestCryptService digestCryptService) {
        this.digestCryptService = digestCryptService;
    }

    @Override
    public void apply(final RequestTemplate template) {
        //加入调用签名
        final long timestamp = Instant.now().getEpochSecond();
        template.header(FeignHeaderEnum.ACCESS_TIMESTAMP.getName(), String.valueOf(timestamp));
        template.header(FeignHeaderEnum.ACCESS_SIGN.getName(), this.digestCryptService.generateSignature(timestamp));

        final ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        final HttpServletRequest request = attributes.getRequest();
        final Enumeration<String> headerNames = request.getHeaderNames();
        if (Objects.isNull(headerNames)) {
            return;
        }
        while (headerNames.hasMoreElements()) {
            final String name = headerNames.nextElement();
            if (StringUtils.containsAnyIgnoreCase(name, LOCALE_HEADERS)) {
                final String values = request.getHeader(name);
                template.header(name, values);
                log.debug("transfer feign header name:[{}],value:[{}}", name, values);
            }
        }
    }
}
