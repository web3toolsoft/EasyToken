package org.web3soft.commons.support.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.web3soft.commons.mybatis.pager.IdPageInfo;
import org.web3soft.commons.mybatis.pager.PageInfo;

/**
 * 分页查询对象类
 *
 * @author web3soft-team
 */
@Data
@NoArgsConstructor
public class DataGridPager<T> {
    private final Integer page = 1;
    private final String sort = "id";
    private final String order = PageInfo.SORT_TYPE_DES;
    private final Long startId = 0L;
    private Integer rows = 50;
    private Integer maxRows = 100;

    /**
     * 查询参数对象
     */
    private T queryParameter;

    public PageInfo toPageInfo() {
        return this.toPageInfo("");
    }

    public PageInfo toPageInfo(final Integer maxRows) {
        this.maxRows = maxRows;
        return this.toPageInfo("");
    }

    public PageInfo toPageInfo(final String tablePrefix) {
        this.rows = Math.min(this.rows, this.maxRows);
        return new PageInfo((this.page - 1) * this.rows, this.rows, this.getSortField(tablePrefix), this.order);
    }

    public IdPageInfo toIdPageInfo() {
        return this.toIdPageInfo("");
    }

    public IdPageInfo toIdPageInfo(final Integer maxRows) {
        this.maxRows = maxRows;
        return this.toIdPageInfo("");
    }

    public IdPageInfo toIdPageInfo(final String tablePrefix) {
        this.rows = Math.min(this.rows, this.maxRows);
        return new IdPageInfo(this.rows, this.getSortField(tablePrefix), this.order);
    }

    private String getSortField(final String tablePrefix) {
        final String prefix = StringUtils.defaultString(tablePrefix, "").trim();
        final String name = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(this.sort), '_');
        return prefix + StringUtils.defaultString(name, "").toLowerCase();
    }
}
