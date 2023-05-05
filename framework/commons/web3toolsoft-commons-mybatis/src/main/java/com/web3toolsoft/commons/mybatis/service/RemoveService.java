package com.web3toolsoft.commons.mybatis.service;

import java.util.List;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> key字段数据类型(Integer,Long,String等)
 * @author Tom Deng
 *
 */
public interface RemoveService<T, U, K> {
    /**
     * @param id
     * @return
     */
    int removeById(K id);

    /**
     * @param example
     * @return
     */
    int removeByExample(U example);

    /**
     * @param records
     * @return
     */
    int removeIn(List<T> records);
}
