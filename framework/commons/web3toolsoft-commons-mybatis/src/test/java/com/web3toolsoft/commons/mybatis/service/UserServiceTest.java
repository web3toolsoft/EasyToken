package com.web3toolsoft.commons.mybatis.service;

import com.web3toolsoft.commons.mybatis.BaseTest;
import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.service.UserService;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * 非分表实现测试用例
 *
 * @author Tom Deng
 */
public class UserServiceTest extends BaseTest {

    @Resource(name = "UserService")
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
        this.userService.add(user);
        Assertions.assertThat(user.getId()).isEqualTo(0);
    }
}