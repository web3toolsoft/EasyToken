package com.web3toolsoft.commons.mybatis.sample.service;

import com.web3toolsoft.commons.mybatis.sample.domain.User;
import com.web3toolsoft.commons.mybatis.sample.domain.UserExample;
import com.web3toolsoft.commons.mybatis.sample.repository.UserRepository;
import com.web3toolsoft.commons.mybatis.service.AbstractCrudService;
import org.springframework.stereotype.Service;

/**
 * @author Tom Deng
 */
@Service("UserService")
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