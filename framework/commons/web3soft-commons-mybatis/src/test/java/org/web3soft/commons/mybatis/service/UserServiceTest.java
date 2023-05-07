package org.web3soft.commons.mybatis.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3soft.commons.mybatis.BaseTest;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.service.UserService;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.Date;

/**
 * 非分表实现测试用例
 *
 * @author Tom Deng
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    private User user;

    @BeforeEach
    public void before() {
        this.user = User.builder()
                .id(3)
                .account("web3ts.com")
                .name("web3ts.com")
                .password("web3soft_test")
                .email("test@web3soft.com")
                .roles("1")
                .salt("test")
                .status((byte) 0)
                .telephone("13800000000")
                .gmtCreated(new Date())
                .comment("")
                .build();
    }

    @Test
    public void addTest() {
        this.userService.add(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    public void addShardingTest() {
        this.userService.add(this.user, ShardTable.builder().name("test_user").build());
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    public void addWithIdTest() {
        this.user.setId(8);
        this.userService.addWithId(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(8);
    }

    @Test
    public void addWithIdShardingTest() {
        this.user.setId(9);
        this.userService.addWithId(this.user, ShardTable.builder().name("test_user").build());
        Assertions.assertThat(this.user.getId()).isEqualTo(9);
    }
}