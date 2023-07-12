package org.web3soft.commons.mybatis.sample.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.sample.domain.User;
import org.web3soft.commons.mybatis.sample.example.UserExample;
import org.web3soft.commons.mybatis.sample.repository.UserRepository;
import org.web3soft.commons.mybatis.sample.service.UserService;
import org.web3soft.commons.mybatis.service.AbstractCrudService;

/**
 * @author Tom Deng
 */
@Service("userService")
public class UserServiceImpl
        extends AbstractCrudService<UserRepository, User, UserExample, Integer>
        implements UserService {

    public UserServiceImpl(final UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    protected UserExample getPageExample(final String fieldName, final String keyword) {
        final UserExample example = new UserExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }
}