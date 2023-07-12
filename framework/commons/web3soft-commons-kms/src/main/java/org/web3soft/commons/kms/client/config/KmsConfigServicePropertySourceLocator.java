package org.web3soft.commons.kms.client.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.web3soft.commons.kms.client.KmsClient;

import java.util.Base64;
import java.util.Map;
import java.util.Objects;

/**
 * @author web3soft-team
 */
@Slf4j
public class KmsConfigServicePropertySourceLocator extends ConfigServicePropertySourceLocator {
    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();
    private static final String KMS_ENCRYPTION_PREFIX = "{encrypted}";
    private final String applicationName;
    private final KmsClient kmsClient;

    public KmsConfigServicePropertySourceLocator(
            final ConfigClientProperties defaultProperties,
            final String applicationName,
            final KmsClient kmsClient) {
        super(defaultProperties);
        this.applicationName = applicationName;
        this.kmsClient = kmsClient;
    }

    @Override
    public PropertySource<?> locate(final Environment environment) {
        final PropertySource<?> ps = super.locate(environment);
        this.decrypt(ps);
        return ps;
    }

    private Map<String, Object> findMapPropertySource(final CompositePropertySource cps) {
        log.debug("finding ps[application={}]", this.applicationName);
        for (final PropertySource<?> ips : cps.getPropertySources()) {
            if (ips.getName().contains(this.applicationName)) {
                final MapPropertySource mps = (MapPropertySource) ips;
                return mps.getSource();
            }
        }
        return null;
    }

    private void decrypt(final PropertySource<?> ps) {
        final Map<String, Object> applicationProperties = this.findMapPropertySource((CompositePropertySource) ps);
        Objects.requireNonNull(applicationProperties).entrySet().forEach(e -> {
            String value = e.getValue().toString();
            if (value.startsWith(KMS_ENCRYPTION_PREFIX)) {
                value = StringUtils.substring(value, KMS_ENCRYPTION_PREFIX.length());
                log.debug("property to be decrypted key:{},value:{}", e.getKey(), value);
                final String deciphered = this.kmsClient.decryptAsBase64(value);
                e.setValue(deciphered);
            }
        });
    }
}
