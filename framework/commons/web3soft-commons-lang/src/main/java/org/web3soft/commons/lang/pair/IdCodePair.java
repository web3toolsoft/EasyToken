package org.web3soft.commons.lang.pair;

/**
 * @author web3soft-team
 **/
public class IdCodePair {
    private Integer id;
    private String code;
    private boolean selected;

    public IdCodePair() {
    }

    public IdCodePair(final Integer id, final String name) {
        this.id = id;
        this.code = name;
    }

    public IdCodePair(final Integer id, final String name, final boolean selected) {
        this(id, name);
        this.selected = selected;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
