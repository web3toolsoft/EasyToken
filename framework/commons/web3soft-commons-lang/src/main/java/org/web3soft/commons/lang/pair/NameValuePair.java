package org.web3soft.commons.lang.pair;

/**
 * @author web3soft-team
 **/
public class NameValuePair {
    private String name;
    private String value;
    private boolean selected;

    public NameValuePair() {
    }

    public NameValuePair(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public NameValuePair(final String name, final String value, final boolean selected) {
        this(name, value);
        this.selected = selected;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
