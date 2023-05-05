package com.web3toolsoft.commons.mybatis.sample.service;

import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.domain.UserExample;
import com.web3toolsoft.commons.mybatis.service.CrudService;

/**
 * 系统用户服务类
 *
 * @author Tom Deng
 *
 */
public interface UserService extends CrudService<User, UserExample, Integer> {
}