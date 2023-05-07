package org.web3soft.commons.mybatis.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3soft.commons.mybatis.BaseTest;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.service.UserService;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        this.userService.removeByExample(null);
    }

    @Test
    void add() {
        this.userService.add(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    void addWithId() {
        this.userService.addWithId(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    void batchAdd() {
        final List<User> records = new ArrayList<>(100);
        for (int i = 10; i < 110; i++) {
            records.add(User.builder()
                    .account("web3ts.com" + i)
                    .name("web3ts.com" + i)
                    .password("web3soft_test" + i)
                    .email("test@web3soft.com+i")
                    .roles("1")
                    .salt("test")
                    .status((byte) 0)
                    .telephone("13800000000")
                    .comment("")
                    .gmtCreated(new Date())
                    .gmtModified(new Date())
                    .build());
        }
        final int effectRows = this.userService.batchAdd(records);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void batchAddWithId() {
        final List<User> records = new ArrayList<>(100);
        for (int i = 10; i < 110; i++) {
            records.add(User.builder()
                    .id(i)
                    .account("web3ts.com" + i)
                    .name("web3ts.com" + i)
                    .password("web3soft_test" + i)
                    .email("test@web3soft.com+i")
                    .roles("1")
                    .salt("test")
                    .status((byte) 0)
                    .telephone("13800000000")
                    .comment("")
                    .gmtCreated(new Date())
                    .gmtModified(new Date())
                    .build());
        }
        final int effectRows = this.userService.batchAddWithId(records);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void batchAddOnDuplicateKey() {
    }

    @Test
    void editById() {
    }

    @Test
    void editByExample() {
    }

    @Test
    void batchEdit() {
    }

    @Test
    void removeById() {
    }

    @Test
    void removeByExample() {
    }

    @Test
    void removeIn() {
    }

    @Test
    void shardAdd() {
        this.userService.add(this.user, ShardTable.builder().name("test_user").build());
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    void shardAddWithId() {
        this.user.setId(9);
        this.userService.addWithId(this.user, ShardTable.builder().name("test_user").build());
        Assertions.assertThat(this.user.getId()).isEqualTo(9);
    }

    @Test
    void shardBatchAdd() {
    }

    @Test
    void shardBatchAddWithId() {
    }

    @Test
    void shardBatchAddOnDuplicateKey() {
    }

    @Test
    void shardEditById() {
    }

    @Test
    void shardEditByExample() {
    }

    @Test
    void shardBatchEdit() {
    }

    @Test
    void shardRemoveById() {
    }

    @Test
    void shardRemoveByExample() {
    }

    @Test
    void shardRemoveIn() {
    }

    @Test
    void exists() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByExample() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getOneByExample() {
    }

    @Test
    void getIn() {
    }

    @Test
    void getByPage() {
    }

    @Test
    void shardGetByPage() {
    }

    @Test
    void shardGetByPage1() {
    }

    @Test
    void shardExists() {
    }

    @Test
    void shardGetById() {
    }

    @Test
    void shardGetByExample() {
    }

    @Test
    void shardGetAll() {
    }

    @Test
    void shardGetOneByExample() {
    }

    @Test
    void shardGetIn() {
    }

    @Test
    void shardGetByPage2() {
    }

    @Test
    void shardGetByPage3() {
    }

    @Test
    void shardGetByPage4() {
    }

    @Test
    void getPageExample() {
    }
}