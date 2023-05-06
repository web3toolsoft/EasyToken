package com.web3toolsoft.commons.mybatis.sample.repository;

import com.web3toolsoft.commons.mybatis.data.CrudRepository;
import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.domain.UserExample;
import org.springframework.stereotype.Repository;

/**
 * 分表(sharding)数据访问接口
 *
 * @author Tom Deng
 *
 */
@Repository("ShardingUserRepository")
public interface ShardingUserRepository extends CrudRepository<User, UserExample, Integer> {
}
