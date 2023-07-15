package org.web3soft.spring.boot.autoconfigure.i18n;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.web3soft.commons.i18n.CustomMessageSource;
import org.web3soft.commons.i18n.MessageSourceStorage;
import org.web3soft.commons.i18n.repository.JdbcMessageSourceRepository;
import org.web3soft.commons.i18n.repository.MessageSourceRepository;
import org.web3soft.commons.i18n.repository.MongoDbMessageSourceRepository;
import org.web3soft.commons.i18n.repository.RedisMessageSourceRepository;

/**
 * @author web3soft-team
 */
@AutoConfiguration
@ConditionalOnClass({MessageSourceRepository.class})
@ConditionalOnProperty(prefix = "web3soft.i18n", name = "custom-message-source", matchIfMissing = true)
@EnableConfigurationProperties({I18nProperties.class})
public class MyMessageSourceAutoConfiguration {

    private final I18nProperties i18nProperties;
    private final StringRedisTemplate stringRedisTemplate;
    private final MessageSourceRepository repository;

    public MyMessageSourceAutoConfiguration(final I18nProperties i18nProperties,
                                            final StringRedisTemplate stringRedisTemplate,
                                            final MessageSourceRepository repository) {
        this.i18nProperties = i18nProperties;
        this.stringRedisTemplate = stringRedisTemplate;
        this.repository = repository;
    }

    @Bean
    public MessageSource messageSource() {
        return new CustomMessageSource(this.repository);
    }

    @Bean("messageSourceRepository")
    public MessageSourceRepository messageSourceRepository() {
        final String name = this.i18nProperties.getRepository();
        final MessageSourceStorage storage = MessageSourceStorage.forName(name);
        return switch (storage) {
            case MONGODB -> new MongoDbMessageSourceRepository();
            case JDBC -> new JdbcMessageSourceRepository();
            default -> new RedisMessageSourceRepository(this.stringRedisTemplate);
        };
    }

}
