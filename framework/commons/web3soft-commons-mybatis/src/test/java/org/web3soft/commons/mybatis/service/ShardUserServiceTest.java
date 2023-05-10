package org.web3soft.commons.mybatis.service;

import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3soft.commons.mybatis.BaseTest;
import org.web3soft.commons.mybatis.pager.PageInfo;
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
public class ShardUserServiceTest extends BaseTest {

    @Resource(name = "shardUserService")
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
                .name("test_user_01")
                .build();
        this.userService.removeByExample(null, this.shardTable);
    }

    private void initRecords() {
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records, this.shardTable);
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
    void shardAdd() {
        this.userService.add(this.user, this.shardTable);
        Assertions.assertThat(this.user.getId()).isEqualTo(1);
    }

    @Test
    void shardAddWithId() {
        this.userService.addWithId(this.user, this.shardTable);
        Assertions.assertThat(this.user.getId()).isEqualTo(1);
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
        this.userService.add(this.user, this.shardTable);
        this.user.setName("web3ts.com_duplicate_key");
        final int effectRows = this.userService.batchAddOnDuplicateKey(List.of(this.user), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(2);
    }

    @Test
    void shardBatchAddWithIdOnDuplicateKey() {
        this.userService.addWithId(this.user, this.shardTable);
        this.user.setName("web3ts.com_duplicate_key");
        final int effectRows = this.userService.batchAddWithIdOnDuplicateKey(List.of(this.user), this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(2);
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
        //set jdbc-url:allowMultiQueries=true
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records, this.shardTable);
        records.forEach(x -> x.setName("web3ts.com_batch_edit_by_id"));
        final int effectRows = this.userService.batchEditById(records, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(1);
    }

    @Test
    void shardRemoveById() {
        this.initRecords();
        final int effectRows = this.userService.removeById(1, this.shardTable);
        final User user1 = this.userService.getById(1, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(1);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void shardRemoveByExample() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(5);
        final int effectRows = this.userService.removeByExample(example, this.shardTable);
        final User user1 = this.userService.getById(6, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(5);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void shardRemoveIn() {
        this.initRecords();

        final int effectRows = this.userService.removeIn(List.of(1, 2, 3, 4, 5), this.shardTable);
        final User user1 = this.userService.getById(1, this.shardTable);
        Assertions.assertThat(effectRows).isEqualTo(5);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void shardExists() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(6);
        final boolean exists = this.userService.exists(example, this.shardTable);
        Assertions.assertThat(exists).isTrue();
    }

    @Test
    void shardGetById() {
        this.initRecords();
        final User user1 = this.userService.getById(6, this.shardTable);
        Assertions.assertThat(user1.getId()).isEqualTo(6);
    }

    @Test
    void shardGetByExample() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(6);
        final List<User> users = this.userService.getByExample(example, this.shardTable);
        Assertions.assertThat(users.size()).isEqualTo(4);
    }

    @Test
    void shardGetAll() {
        this.initRecords();
        final List<User> users = this.userService.getAll(this.shardTable);
        Assertions.assertThat(users.size()).isEqualTo(10);
    }

    @Test
    void shardGetOneByExample() {
        this.initRecords();
        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(6);
        final User user1 = this.userService.getOneByExample(example, this.shardTable);
        Assertions.assertThat(user1.getId()).isEqualTo(6);
    }

    @Test
    void shardGetIn() {
        this.initRecords();
        final List<User> users = this.userService.getIn(List.of(1, 2, 3, 4, 5), this.shardTable);
        Assertions.assertThat(users.size()).isEqualTo(5);
    }

    @Test
    void shardGetByPage() {
        final List<User> records = this.getRecords(100, true);
        this.userService.batchAddWithId(records, this.shardTable);
        final PageInfo pageInfo = new PageInfo();
        final List<User> users = this.userService.getByPage(pageInfo, this.shardTable);
        Assertions.assertThat(pageInfo.getTotals()).isEqualTo(100);
        Assertions.assertThat(users.size()).isEqualTo(50);
    }

    @Test
    void shardGetByPage2() {
        final List<User> records = this.getRecords(100, true);
        this.userService.batchAddWithId(records, this.shardTable);
        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(10);

        final PageInfo pageInfo = new PageInfo();
        final List<User> users = this.userService.getByPage(pageInfo, example, this.shardTable);
        Assertions.assertThat(pageInfo.getTotals()).isEqualTo(90);
        Assertions.assertThat(users.size()).isEqualTo(50);
    }
}