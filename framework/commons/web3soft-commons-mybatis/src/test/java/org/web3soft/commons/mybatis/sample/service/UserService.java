package org.web3soft.commons.mybatis.sample.service;

import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.example.UserExample;
import org.web3soft.commons.mybatis.service.CrudService;

/**
 * 系统用户服务类
 *
 * @author web3soft-team
 *
 */
public interface UserService extends CrudService<User, UserExample, Integer> {
}