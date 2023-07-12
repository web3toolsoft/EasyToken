package org.web3soft.commons.mybatis.pager;

import lombok.Getter;

/**
 * 按主键id分页类
 *
 * @author Tom Deng
 */
@Getter
public class IdPageInfo {
    private String sortItem;
    private String sortType;
    private int pageSize;
    private long startIndex;
    private long maxId;
    private long minId;
    private long totals;

    /**
     * 默认为按表中的id字段,如果表中主键名称不"id"，则需要指定名称
     * 默认按id从降序查询
     */
    public IdPageInfo() {
        this(50);
    }

    /**
     * @param pageSize 每页记录数
     */
    public IdPageInfo(final int pageSize) {
        this(pageSize, "id");
    }

    /**
     * @param pageSize 每页记录数
     * @param sortItem 主键id字段名称
     */
    public IdPageInfo(final int pageSize, final String sortItem) {
        this(pageSize, sortItem, PageInfo.SORT_TYPE_ASC);
    }

    /**
     * @param pageSize 每页记录数
     * @param sortItem 主键id字段名称
     * @param sortType (asc|desc)
     */
    public IdPageInfo(final int pageSize, final String sortItem, final String sortType) {
        this.pageSize = pageSize;
        this.sortItem = sortItem;
        this.sortType = sortType;
        this.startIndex = 1;
    }

    /**
     * @param maxId
     * @param minId
     * @param totals
     */
    public void setPagerParams(final long maxId, final long minId, final long totals) {
        this.maxId = maxId;
        this.minId = minId;
        this.totals = totals;
    }

    /**
     * 初始化StartIndex
     */
    public void initStartIndex() {
        if (PageInfo.SORT_TYPE_ASC.equalsIgnoreCase(this.sortType)) {
            this.startIndex = this.minId - 1;
        } else {
            this.startIndex = this.maxId + 1;
        }
    }

    /**
     * 设置id字段名
     *
     * @param sortItem id字段名
     */
    public void setSortItem(final String sortItem) {
        this.sortItem = sortItem;
    }

    /**
     * 设置id字段名排序类型(asc|desc)
     *
     * @param sortType {@link PageInfo#SORT_TYPE_ASC}
     */
    public void setSortType(final String sortType) {
        this.sortType = sortType;
        this.setPagerParams(this.maxId, this.minId, this.totals);
    }

    /**
     * 设置开始记录号
     *
     * @param startIndex 开始记录号
     */
    public void setStartIndex(final long startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 设置分页大小
     *
     * @param pageSize 分页大小
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取分页总数
     *
     * @return 分页总数
     */
    public int getPageCount() {
        final int pageCount = (int) (this.totals / this.pageSize);
        return this.totals % this.pageSize == 0 ? pageCount : pageCount + 1;
    }

    /**
     * 设置下一分页起始记录序号
     *
     * @param nextStartIndex 下一分页起始记录序号
     */
    public void setNextStartIndex(final long nextStartIndex) {
        this.setStartIndex(nextStartIndex);
    }
}
