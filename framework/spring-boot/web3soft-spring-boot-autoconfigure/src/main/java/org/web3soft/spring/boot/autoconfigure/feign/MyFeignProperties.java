package org.web3soft.spring.boot.autoconfigure.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.feign")
public class MyFeignProperties {
    private Map<String,String> clients = new HashMap<>();

    public Map<String, String> getClients() {
        return this.clients;
    }

    public void setClients(final Map<String, String> clients) {
        this.clients = clients;
    }
}
