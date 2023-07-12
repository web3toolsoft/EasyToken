package org.web3soft.commons.i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.web3soft.commons.i18n.repository.MessageSourceRepository;
import org.web3soft.commons.i18n.repository.RedisMessageSourceRepository;

/**
 * @author web3soft-team
 * @since 1.0.0
 */
public class CustomMessageSourceTest {

    private MessageSource messageSource;
    private MessageSourceRepository repository;

    @BeforeEach
    public void setup() {
        this.repository = Mockito.mock(RedisMessageSourceRepository.class);
        this.messageSource = new CustomMessageSource(this.repository);
    }

    @Test
    void getMessageTest() {
    }
}