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

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 非分表实现测试用例
 *
 * @author web3soft-team
 */
public class UserServiceTest extends BaseTest {

    @Resource(name = "userService")
    private UserService userService;
    private User user;

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
        this.userService.removeByExample(null);
    }

    private void initRecords() {
        final List<User> records = this.getRecords(10, true);
        this.userService.batchAddWithId(records);
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
        Assertions.assertThat(effectRows).isEqualTo(2);
    }

    @Test
    void batchAddWithIdOnDuplicateKey() {
        this.userService.addWithId(this.user);
        this.user.setName("web3ts.com_duplicate_key");
        final int effectRows = this.userService.batchAddWithIdOnDuplicateKey(List.of(this.user));
        Assertions.assertThat(effectRows).isEqualTo(2);
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
        this.initRecords();
        final int effectRows = this.userService.removeById(1);
        final User user1 = this.userService.getById(1);
        Assertions.assertThat(effectRows).isEqualTo(1);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void removeByExample() {
        this.initRecords();

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
        this.initRecords();

        final int effectRows = this.userService.removeIn(List.of(1, 2, 3, 4, 5));
        final User user1 = this.userService.getById(1);
        Assertions.assertThat(effectRows).isEqualTo(5);
        Assertions.assertThat(user1).isNull();
    }

    @Test
    void exists() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(6);
        final boolean exists = this.userService.exists(example);
        Assertions.assertThat(exists).isTrue();
    }

    @Test
    void getById() {
        this.initRecords();
        final User user1 = this.userService.getById(6, List.of("id", "account"));
        Assertions.assertThat(user1.getId()).isEqualTo(6);
        Assertions.assertThat(user1.getName()).isNull();
    }

    @Test
    void getByExample() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(6);
        final List<User> users = this.userService.getByExample(example);
        Assertions.assertThat(users.size()).isEqualTo(4);
    }

    @Test
    void getByLikeExample() {
        this.initRecords();

        final UserExample example = new UserExample();
        example.createCriteria()
                .andAccountLike("%web3%");
        final List<User> users = this.userService.getByExample(example);
        Assertions.assertThat(users.size()).isEqualTo(4);
    }

    @Test
    void getAll() {
        this.initRecords();
        final List<User> users = this.userService.getAll();
        Assertions.assertThat(users.size()).isEqualTo(10);
    }

    @Test
    void getOneByExample() {
        this.initRecords();
        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(6);
        final User user1 = this.userService.getOneByExample(example);
        Assertions.assertThat(user1.getId()).isEqualTo(6);
    }

    @Test
    void getIn() {
        this.initRecords();
        final List<User> users = this.userService.getIn(List.of(1, 2, 3, 4, 5));
        Assertions.assertThat(users.size()).isEqualTo(5);
    }

    @Test
    void getByPage() {
        final List<User> records = this.getRecords(100, true);
        this.userService.batchAddWithId(records);
        final PageInfo pageInfo = new PageInfo();
        final List<User> users = this.userService.getByPage(pageInfo);
        Assertions.assertThat(pageInfo.getTotals()).isEqualTo(100);
        Assertions.assertThat(users.size()).isEqualTo(50);
    }

    @Test
    void getByPage2() {
        final List<User> records = this.getRecords(100, true);
        this.userService.batchAddWithId(records);
        final UserExample example = new UserExample();
        example.createCriteria()
                .andIdGreaterThan(10);

        final PageInfo pageInfo = new PageInfo();
        final List<User> users = this.userService.getByPage(pageInfo, example);
        Assertions.assertThat(pageInfo.getTotals()).isEqualTo(90);
        Assertions.assertThat(users.size()).isEqualTo(50);
    }
}