package org.web3soft.spring.boot.autoconfigure.env;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.web3soft.commons.dictionary.consts.AppEnvConsts;

import java.util.Locale;

/**
 * @author linus
 */
@AutoConfiguration
@ConditionalOnClass({AppEnvConsts.class})
@EnableConfigurationProperties({AppEnvProperties.class})
public class AppEnvAutoConfiguration implements InitializingBean {
    private final AppEnvProperties appEnvProperties;

    public AppEnvAutoConfiguration(final AppEnvProperties appEnvProperties) {
        this.appEnvProperties = appEnvProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        AppEnvConsts.setEnvName(this.appEnvProperties.getEnv().getName());
        AppEnvConsts.setAppName(this.appEnvProperties.getName());
        AppEnvConsts.setDomain(this.appEnvProperties.getDomain());
        AppEnvConsts.setDefaultLocale(Locale.forLanguageTag(this.appEnvProperties.getEnv().getDefaultLocale()));
        AppEnvConsts.setRandom(RandomUtils.nextFloat(0, 2));
    }
}
