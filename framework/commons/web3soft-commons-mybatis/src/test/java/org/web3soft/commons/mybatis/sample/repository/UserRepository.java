package org.web3soft.commons.mybatis.sample.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.example.UserExample;

/**
 * 数据访问接口
 *
 * @author Tom Deng
 */
@Repository
public interface UserRepository extends CrudRepository<User, UserExample, Integer> {
}
