package org.web3soft.commons.lang.pair;

/**
 * @author web3soft-team
 **/
public class KeyValuePair {
    private String key;
    private String name;

    public KeyValuePair() {
    }

    public KeyValuePair(final String key, final String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(final String name) {
        this.name = name;
    }
}
