package org.web3soft.commons.mybatis.sample.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.example.UserExample;
import org.web3soft.commons.mybatis.sample.repository.ShardUserRepository;
import org.web3soft.commons.mybatis.sample.service.UserService;
import org.web3soft.commons.mybatis.service.AbstractCrudService;

/**
 * @author Tom Deng
 */
@Service("shardUserService")
public class ShardUserServiceImpl
        extends AbstractCrudService<ShardUserRepository, User, UserExample, Integer>
        implements UserService {

    public ShardUserServiceImpl(final ShardUserRepository userRepository) {
        super(userRepository);
    }

    @Override
    protected UserExample getPageExample(final String fieldName, final String keyword) {
        final UserExample example = new UserExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }
}