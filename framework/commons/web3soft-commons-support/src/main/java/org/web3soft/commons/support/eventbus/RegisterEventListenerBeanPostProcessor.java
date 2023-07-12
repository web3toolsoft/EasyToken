package org.web3soft.commons.support.eventbus;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author web3soft-team
 */
public class RegisterEventListenerBeanPostProcessor implements BeanPostProcessor {

    private final EventBus eventBus;

    public RegisterEventListenerBeanPostProcessor(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(EventListener.class)) {
            this.eventBus.register(bean);
        }
        return bean;
    }
}
