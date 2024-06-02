package org.web3soft.commons.mybatis.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.web3soft.commons.mybatis.BaseTest;

/**
 * @author web3soft-team
 */
public class SqlInjectionUtilsTest extends BaseTest {

    @Test
    public void checkTest() {
        final String[] sqls = {
                "select adf from abc",
                "insert into abcd",
                "update abcd",
                "delete from abcd",
                "upsert abcd",
                "call abcd",
                "rollback ",
                "create table abc",
                "drop table",
                "drop view",
                "alter table abc",
                "truncate table abc",
                "desc abc",
                "select id",
                "select 'abc'",
        };

        for (final String sql : sqls) {
            Assertions.assertTrue(SqlInjectionUtils.check(sql));
        }

        final String[] sqls2 = {
                "--",
                "/*",
                "*/",
                ";",
                "someone -- abcd",
                "abcd /* adf */ adf",
        };

        for (final String sql2 : sqls2) {
            Assertions.assertTrue(SqlInjectionUtils.check(sql2));
        }
    }
}
