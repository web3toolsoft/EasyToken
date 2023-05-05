package com.web3toolsoft.commons.mybatis.sample.sharding.service;

import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.domain.UserExample;
import com.web3toolsoft.commons.mybatis.sharding.service.CrudService;

/**
 * 分表(sharding)用户服务接口
 *
 * @author Tom Deng
 *
 */
public interface UserService extends CrudService<User, UserExample, Integer> {
}