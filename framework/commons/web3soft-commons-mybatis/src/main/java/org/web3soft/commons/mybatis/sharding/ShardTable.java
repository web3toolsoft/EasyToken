package org.web3soft.commons.mybatis.sharding;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tom Deng
 *
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShardTable {
    /**
     * sharding 前缀
     */
    private String prefix;

    /**
     * sharding 表名称
     */
    private String name;

    /**
     * sharding 后缀
     */
    private String suffix;
}
