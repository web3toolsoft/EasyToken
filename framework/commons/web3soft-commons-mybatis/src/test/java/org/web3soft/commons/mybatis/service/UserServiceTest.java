package org.web3soft.commons.mybatis.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3soft.commons.mybatis.BaseTest;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.example.UserExample;
import org.web3soft.commons.mybatis.sample.service.UserService;
import org.web3soft.commons.mybatis.sharding.ShardTable;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 非分表实现测试用例
 *
 * @author Tom Deng
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    private User user;
    private ShardTable shardTable;

    @BeforeEach
    public void before() {
        this.user = User.builder()
                .id(1)
                .account("web3ts.com")
                .name("web3ts.com")
                .password("web3soft_test")
                .email("test@web3soft.com")
                .roles("1")
                .salt("test")
                .status((byte) 0)
                .telephone("13800000000")
                .comment("")
                .gmtCreated(new Date())
                .gmtModified(new Date())
                .build();
        this.shardTable = ShardTable.builder()
                .name("test_user")
                .build();
        this.userService.removeByExample(null);
    }

    private List<User> getRecords(final int count, final boolean isWithId) {
        return IntStream.range(1, count + 1)
                .mapToObj(i -> User.builder()
                        .id(isWithId ? i : null)
                        .account("web3ts.com" + i)
                        .name("web3ts.com" + i)
                        .password("web3soft_test" + i)
                        .email("test@web3soft.com" + i)
                        .roles("1")
                        .salt("test")
                        .status((byte) 0)
                        .telephone("13800000000")
                        .comment("")
                        .gmtCreated(new Date())
                        .gmtModified(new Date())
                        .build())
                .collect(Collectors.toList());
    }

    @Test
    void add() {
        this.userService.add(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(1);
    }

    @Test
    void addWithId() {
        this.userService.addWithId(this.user);
        Assertions.assertThat(this.user.getId()).isEqualTo(1);
    }

    @Test
    void batchAdd() {
        final int effectRows = this.userService.batchAddWithId(this.getRecords(100, false));
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void batchAddWithId() {
        final int effectRows = this.userService.batchAddWithId(this.getRecords(100, true));
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void batchAddOnDuplicateKey() {
        this.userService.add(this.user);
        this.user.setName("web3ts.com_duplicate_key");
        final int effectRows = this.userService.batchAddOnDuplicateKey(List.of(this.user));
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void batchAddWithIdOnDuplicateKey() {
        this.userService.addWithId(this.user);
        this.user.setName("web3ts.com_duplicate_key");
        final int effectRows = this.userService.batchAddWithIdOnDuplicateKey(List.of(this.user));
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void editById() {
        this.userService.addWithId(this.user);
        this.user.setName("web3ts.com_edit_by_id");
        this.user.setEmail("test@web3soft.com_edit_by_id");
        final int effectRows = this.userService.editById(this.user);
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void editByExample() {
        this.userService.addWithId(this.user);
        this.user.setName("web3ts.com_edit_by_example");
        this.user.setEmail("test@web3soft.com_edit_by_example");

        final UserExample example = new UserExample();
        example.createCriteria()
                .andAccountEqualTo(this.user.getAccount());

        final int effectRows = this.userService.editByExample(this.user, example);
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void batchEditById() {
        //set jdbc-url:allowMultiQueries=true
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records);
        records.forEach(x -> x.setName("web3ts.com_batch_edit_by_id"));
        final int effectRows = this.userService.batchEditById(records);
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void removeById() {
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records);
        final int effectRows = this.userService.removeById(1);
        final User user1 = this.userService.getById(1);
        Assertions.assertThat(effectRows).isEqualTo(1);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void removeByExample() {
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records);

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(5);
        final int effectRows = this.userService.removeByExample(example);
        final User user1 = this.userService.getById(6);
        Assertions.assertThat(effectRows).isEqualTo(5);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void removeIn() {
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records);

        final int effectRows = this.userService.removeIn(List.of(1, 2, 3, 4, 5));
        final User user1 = this.userService.getById(1);
        Assertions.assertThat(effectRows).isEqualTo(5);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void shardAdd() {
        this.userService.add(this.user, this.shardTable);
        Assertions.assertThat(this.user.getId()).isEqualTo(3);
    }

    @Test
    void shardAddWithId() {
        this.user.setId(9);
        this.userService.addWithId(this.user, this.shardTable);
        Assertions.assertThat(this.user.getId()).isEqualTo(9);
    }

    @Test
    void shardBatchAdd() {
        final int effectRows = this.userService.batchAdd(this.getRecords(100, false), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void shardBatchAddWithId() {
        final int effectRows = this.userService.batchAddWithId(this.getRecords(100, true), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void shardBatchAddOnDuplicateKey() {
        final int effectRows = this.userService.batchAddOnDuplicateKey(this.getRecords(100, true), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void shardBatchAddWithIdOnDuplicateKey() {
        final int effectRows = this.userService.batchAddWithIdOnDuplicateKey(this.getRecords(100, true), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(100);
    }

    @Test
    void shardEditById() {
        this.userService.addWithId(this.user, this.shardTable);
        this.user.setName("web3ts.com_edit_by_id");
        this.user.setEmail("test@web3soft.com_edit_by_id");
        final int effectRows = this.userService.editById(this.user, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void shardEditByExample() {
        this.userService.addWithId(this.user, this.shardTable);
        this.user.setName("web3ts.com_edit_by_example");
        this.user.setEmail("test@web3soft.com_edit_by_example");

        final UserExample example = new UserExample();
        example.createCriteria()
                .andAccountEqualTo(this.user.getAccount());

        final int effectRows = this.userService.editByExample(this.user, example, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(1);

    }

    @Test
    void shardBatchEditById() {
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