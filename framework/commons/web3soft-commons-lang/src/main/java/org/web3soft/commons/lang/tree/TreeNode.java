package org.web3soft.commons.lang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的树型节点类
 *
 * @author web3soft-team
 */
public class TreeNode<T> {
    private final List<TreeNode<T>> children = new ArrayList<>();
    private String id;
    private String pid;
    private String text;
    private String state;
    private String iconCls;
    private boolean checked;
    private T attributes;

    public TreeNode(final String id, final String pid, final String text) {
        this(id, pid, text, "closed", "", false, null);
    }

    public TreeNode(final String id, final String text, final String state, final T attributes) {
        this(id, "0", text, state, "", false, attributes);
    }

    public TreeNode(final String id, final String pid, final String text, final String state,
                    final T attributes) {
        this(id, pid, text, state, "", false, attributes);
    }

    public TreeNode(final String id, final String pid, final String text, final String state,
                    final String iconCls,
                    final boolean checked, final T attributes) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.state = state;
        this.iconCls = iconCls;
        this.checked = checked;
        this.attributes = attributes;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPId() {
        return this.pid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getIconCls() {
        return this.iconCls == null ? "" : this.iconCls;
    }

    public void setIconCls(final String iconCls) {
        this.iconCls = iconCls;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public void setChecked(final boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return this.state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public T getAttributes() {
        return this.attributes;
    }

    public void setAttributes(final T attributes) {
        this.attributes = attributes;
    }

    public void setPid(final String pid) {
        this.pid = pid;
    }

    public List<TreeNode<T>> getChildren() {
        return this.children;
    }
}
