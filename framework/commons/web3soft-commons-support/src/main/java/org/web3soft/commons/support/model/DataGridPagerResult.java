package org.web3soft.commons.support.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询结果对象类
 *
 * @author web3soft-team
 */
@Data
@NoArgsConstructor
public class DataGridPagerResult<T> {
    private List<T> rows;
    private Long total = 0L;
    private Long prevId = 0L;
    private Long nextId = 0L;

    public DataGridPagerResult(final Long total, final List<T> rows) {
        this(total, rows, 0L, 0L);
    }

    public DataGridPagerResult(final Long total, final List<T> rows, final Long prevId, final Long nextId) {
        this.total = total;
        this.rows = rows;
        this.prevId = prevId;
        this.nextId = nextId;
    }
}