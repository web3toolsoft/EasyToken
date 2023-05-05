package com.web3toolsoft.commons.mybatis.sample.sharding.service;

import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.domain.UserExample;
import com.web3toolsoft.commons.mybatis.sample.repository.ShardingUserRepository;
import com.web3toolsoft.commons.mybatis.sharding.service.AbstractCrudService;
import org.springframework.stereotype.Service;

/**
 * 分表(sharding)用户服务接口实现
 *
 * @author Tom Deng
 *
 */
@Service("ShardingUserService")
public class UserServiceImpl
        extends AbstractCrudService<ShardingUserRepository, User, UserExample, Integer>
        implements UserService {

    @Override
    protected UserExample getPageExample(final String fieldName, final String keyword) {
        final UserExample example = new UserExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}