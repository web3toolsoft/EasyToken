package org.web3soft.commons.lang.pair;

/**
 * @author web3soft-team
 **/
public class NameTextPair {
    private String name;
    private String text;
    private boolean selected;

    public NameTextPair() {
    }

    public NameTextPair(final String name, final String text) {
        this.name = name;
        this.text = text;
    }

    public NameTextPair(final String name, final String text, final boolean selected) {
        this(name, text);
        this.selected = selected;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
