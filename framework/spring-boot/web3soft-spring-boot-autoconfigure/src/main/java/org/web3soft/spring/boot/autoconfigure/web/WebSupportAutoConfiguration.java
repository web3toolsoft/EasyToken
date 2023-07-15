package org.web3soft.spring.boot.autoconfigure.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Servlet;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;
import org.web3soft.commons.web.converter.XssJackson2HttpMessageConverter;
import org.web3soft.commons.web.filter.ContextInitDataFilter;
import org.web3soft.commons.web.i18n.CustomCookieLocaleResolver;
import org.web3soft.commons.web.i18n.CustomLocaleChangeInterceptor;
import org.web3soft.commons.web.i18n.LocaleUtils;
import org.web3soft.commons.web.interceptor.ApiEnabledForInterceptor;
import org.web3soft.commons.web.resolver.CurrentUserMethodArgumentResolver;
import org.web3soft.commons.web.resolver.TokenCurrentUserIdMethodArgumentResolver;
import org.web3soft.commons.web.resolver.TokenCurrentUserMethodArgumentResolver;
import org.web3soft.spring.boot.autoconfigure.env.AppEnvProperties;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author web3soft-team
 */
@Order(100)
@AutoConfiguration
@ConditionalOnClass({
        Servlet.class,
        DispatcherServlet.class,
        WebMvcConfigurer.class
})
@ConditionalOnProperty(value = "web3soft.web.enabled", matchIfMissing = true)
@EnableConfigurationProperties({
        AppEnvProperties.class,
        WebSupportProperties.class
})
public class WebSupportAutoConfiguration implements WebMvcConfigurer {

    private final AppEnvProperties appEnvProperties;
    private final WebSupportProperties webSupportProperties;

    public WebSupportAutoConfiguration(final AppEnvProperties appEnvProperties,
                                       final WebSupportProperties webSupportProperties) {
        this.appEnvProperties = appEnvProperties;
        this.webSupportProperties = webSupportProperties;
    }

    /**
     * 在系统启动时加一些初始化数据到request上下文中
     *
     * @return FilterRegistrationBean
     */
    @Bean
    @ConditionalOnProperty(prefix = "web3soft.web.init-data-filter", name = "enabled")
    public FilterRegistrationBean<?> contextInitDataFilterRegistrationBean() {
        final FilterRegistrationBean<ContextInitDataFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ContextInitDataFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter(AppEnvConsts.APP_NAME_ITEM, this.appEnvProperties.getName());
        registrationBean.addInitParameter(AppEnvConsts.VERSION_ITEM, this.appEnvProperties.getVersion());
        registrationBean.addInitParameter(AppEnvConsts.RANDOM_ITEM, String.valueOf(RandomUtils.nextFloat(0, 1)));
        registrationBean.setName("contextInitDataFilter");
        return registrationBean;
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.web.servlet-container", name = "enabled", matchIfMissing = true)
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/customError/401"));
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/customError/403"));
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/customError/404"));
            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/customError"));
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public ErrorProperties errorProperties() {
        final ErrorProperties properties = new ErrorProperties();
        properties.setIncludeStacktrace(
                AppEnvConsts.isProductionMode() ? ErrorProperties.IncludeAttribute.NEVER : ErrorProperties.IncludeAttribute.ALWAYS
        );
        return properties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "web3soft.web.message-converter", name = "enabled", matchIfMissing = true)
    public XssJackson2HttpMessageConverter messageConverter() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final XssJackson2HttpMessageConverter converter = new XssJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(
                MediaType.APPLICATION_JSON,
                MediaType.valueOf("feign/json")
        ));
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    @Bean("localeResolver")
    public LocaleResolver localeResolver() {
        final CookieLocaleResolver localeResolver = new CustomCookieLocaleResolver("locale");
        localeResolver.setLanguageTagCompliant(true);
        //保存7天有效
        localeResolver.setCookieMaxAge(Duration.ofSeconds(604800));
        localeResolver.setDefaultLocale(Locale.CHINA);
        localeResolver.setCookiePath("/");
        return localeResolver;
    }

    @Bean
    public LocaleUtils localeUtils(@Qualifier("localeResolver") final LocaleResolver localeResolver) {
        return new LocaleUtils(localeResolver);
    }

    @Bean
    @ConditionalOnMissingBean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        return new CustomLocaleChangeInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiEnabledForInterceptor apiEnabledForInterceptor() {
        return new ApiEnabledForInterceptor(this.appEnvProperties.getDomain());
    }

    @Bean
    @ConditionalOnMissingBean(name = "currentUserMethodArgumentResolver")
    public HandlerMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    @Bean
    @ConditionalOnMissingBean(name = "tokenCurrentUserMethodArgumentResolver")
    public HandlerMethodArgumentResolver tokenCurrentUserMethodArgumentResolver() {
        return new TokenCurrentUserMethodArgumentResolver();
    }

    @Bean
    @ConditionalOnMissingBean(name = "tokenCurrentUserIdMethodArgumentResolver")
    public HandlerMethodArgumentResolver tokenCurrentUserIdMethodArgumentResolver() {
        return new TokenCurrentUserIdMethodArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(this.currentUserMethodArgumentResolver());
        argumentResolvers.add(this.tokenCurrentUserMethodArgumentResolver());
        argumentResolvers.add(this.tokenCurrentUserIdMethodArgumentResolver());
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(this.localeChangeInterceptor());
        registry.addInterceptor(this.apiEnabledForInterceptor());
    }
}
