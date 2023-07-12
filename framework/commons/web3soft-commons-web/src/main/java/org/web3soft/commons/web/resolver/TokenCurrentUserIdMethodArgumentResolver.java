package org.web3soft.commons.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.web3soft.commons.support.annotation.TokenCurrentUserId;

import java.util.Objects;

/**
 * @author web3soft-team
 */
public class TokenCurrentUserIdMethodArgumentResolver implements HandlerMethodArgumentResolver {
    public TokenCurrentUserIdMethodArgumentResolver() {
    }

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TokenCurrentUserId.class);
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer,
                                  @NonNull final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
        final TokenCurrentUserId annotation = parameter.getParameterAnnotation(TokenCurrentUserId.class);
        if (Objects.isNull(annotation)) {
            return null;
        }
        return webRequest.getAttribute(annotation.value(), NativeWebRequest.SCOPE_REQUEST);
    }
}
