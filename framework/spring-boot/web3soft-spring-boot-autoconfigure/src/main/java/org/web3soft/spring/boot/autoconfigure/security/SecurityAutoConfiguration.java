package org.web3soft.spring.boot.autoconfigure.security;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import jakarta.servlet.Filter;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.web3soft.commons.security.interceptor.CsrfInterceptor;
import org.web3soft.commons.security.xss.XssFilter;

/**
 * @author web3soft-team
 */
@Order(98)
@AutoConfiguration
@ConditionalOnClass({XssFilter.class, CsrfInterceptor.class})
@EnableConfigurationProperties({
        SecurityProperties.class
})
public class SecurityAutoConfiguration
        implements WebMvcConfigurer, ApplicationContextAware {
    private static final String CSRF_INTERCEPTOR_BEAN_NAME = "csrfInterceptor";
    private final SecurityProperties securityProperties;
    private ApplicationContext applicationContext;

    public SecurityAutoConfiguration(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.security.xss", name = "enabled", matchIfMissing = true)
    public FilterRegistrationBean<?> xssFilterRegistrationBean() {
        final String[] urlPatterns = Iterables.toArray(Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(this.securityProperties.getXss().getUrlPatterns()), String.class);

        final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssFilter());
        registrationBean.addInitParameter(XssFilter.FILTER_POLICY, this.securityProperties.getXss().getPolicy());
        registrationBean.addInitParameter(XssFilter.EXCLUDE_URL_PATTERNS, this.securityProperties.getXss().getExcludeUrlPatterns());
        registrationBean.addUrlPatterns(urlPatterns);
        registrationBean.setName("xssFilter");
        return registrationBean;
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.security.csrf", name = "enabled", matchIfMissing = true)
    public CsrfInterceptor csrfInterceptor() {
        return new CsrfInterceptor(this.securityProperties.getCsrf().getRefererPattern());
    }


    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        if (this.applicationContext.containsBean(SecurityAutoConfiguration.CSRF_INTERCEPTOR_BEAN_NAME)) {
            final String[] csrfPathPatterns = Iterables.toArray(Splitter.on(",")
                    .omitEmptyStrings()
                    .trimResults()
                    .split(this.securityProperties.getCsrf().getExcludePathPatterns()), String.class);
            registry.addInterceptor(this.csrfInterceptor()).excludePathPatterns(csrfPathPatterns);
        }
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
