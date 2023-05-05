package com.web3toolsoft.commons.mybatis.sharding.service;

import com.web3toolsoft.commons.mybatis.BaseTest;
import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.sharding.service.UserService;
import com.web3toolsoft.commons.mybatis.sharding.ShardTable;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * 分表(sharding)实现测试用例
 *
 * @author Tom Deng
 */
public class UserServiceTest extends BaseTest {
    @Resource(name = "ShardingUserService")
    private UserService userService;

    @Test
    public void addTest() {
        final User user = User.builder()
                .account("web3toolsoft_test")
                .name("web3toolsoft.com")
                .password("web3toolsoft_test")
                .email("test@web3toolsoft.com")
                .roles("1")
                .salt("abcdefg")
                .status((byte) 0)
                .telephone("13800000000")
                .gmtCreated(new Date())
                .comment("")
                .build();
        this.userService.add(user, ShardTable.builder().name("user").build());
        Assertions.assertThat(user.getId()).isEqualTo(0);
    }
}