package org.web3soft.commons.lang.pair;

/**
 * @author web3soft-team
 **/
public class IdNamePair {
    private String id;
    private String name;
    private boolean selected;

    public IdNamePair() {
    }

    public IdNamePair(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public IdNamePair(final String id, final String name, final boolean selected) {
        this(id, name);
        this.selected = selected;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
