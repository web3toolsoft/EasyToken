package org.web3soft.commons.mybatis.pager;

import lombok.Data;

/**
 * 按limit分页类 <br>
 *
 * @author Tom Deng
 *
 */
@Data
public class PageInfo {
    public static final String SORT_TYPE_ASC = "asc";
    public static final String SORT_TYPE_DES = "desc";
    private long totals;
    private int startIndex;
    private int pageSize = 50;
    private String sortItem;
    private String sortType = SORT_TYPE_ASC;

    public PageInfo() {
    }

    /**
     * @param startIndex
     * @param pageSize
     */
    public PageInfo(final int startIndex, final int pageSize) {
        this(startIndex, pageSize, "", PageInfo.SORT_TYPE_ASC);
    }

    /**
     * @param startIndex
     * @param pageSize
     * @param sortItem
     */
    public PageInfo(final int startIndex, final int pageSize, final String sortItem) {
        this(startIndex, pageSize, sortItem, PageInfo.SORT_TYPE_ASC);
    }

    /**
     * @param startIndex
     * @param pageSize
     * @param sortItem
     * @param sortType   (asc|desc)
     */
    public PageInfo(final int startIndex, final int pageSize, final String sortItem, final String sortType) {
        this.startIndex = startIndex;
        this.pageSize = pageSize;
        this.sortItem = sortItem;
        this.sortType = sortType;
    }
}
