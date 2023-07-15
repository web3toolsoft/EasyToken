package org.web3soft.spring.boot.autoconfigure.auth.session;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.web3soft.commons.auth.annotation.EnableTokenSession;
import org.web3soft.commons.auth.config.SessionConfig;
import org.web3soft.commons.auth.data.SessionRepository;
import org.web3soft.commons.auth.model.TokenUserInfo;
import org.web3soft.commons.auth.service.SessionService;
import org.web3soft.commons.auth.service.impl.SessionServiceImpl;
import org.web3soft.spring.boot.autoconfigure.auth.SessionProperties;

import java.time.Duration;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass(SessionRepository.class)
@EnableConfigurationProperties(SessionProperties.class)
@Import({RedisSessionConfiguration.class})
public class SessionAutoConfiguration implements BeanPostProcessor {
    private final SessionProperties sessionProperties;

    public SessionAutoConfiguration(final SessionProperties sessionProperties) {
        this.sessionProperties = sessionProperties;
    }

    @Bean
    public SessionConfig sessionConfig() {
        return SessionConfig.builder()
                .maxInactiveInterval(Duration.ofSeconds(this.sessionProperties.getMaxInactiveInterval()))
                .build();
    }

    @Bean
    public SessionService<TokenUserInfo> sessionService() {
        return new SessionServiceImpl();
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(EnableTokenSession.class)) {
            final EnableTokenSession enableTokenSession = bean.getClass().getAnnotation(EnableTokenSession.class);
            final long maxInterval = Math.max(
                    enableTokenSession.maxInactiveIntervalInSeconds(),
                    this.sessionProperties.getMaxInactiveInterval()
            );
            this.sessionService().setMaxInactiveInterval(maxInterval);
        }
        return bean;
    }
}


