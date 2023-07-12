package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenExample;
import org.web3soft.easytoken.wallet.data.repository.SysTokenRepository;
import org.web3soft.easytoken.wallet.domain.SysToken;
import org.web3soft.easytoken.wallet.service.SysTokenService;

/**
 * 针对表【sys_token(链上代币表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:49
 */
@Service
public class SysTokenServiceImpl
        extends AbstractCrudService<SysTokenRepository, SysToken, SysTokenExample, Integer>
        implements SysTokenService {

    public SysTokenServiceImpl(final SysTokenRepository sysTokenRepository) {
        super(sysTokenRepository);
    }

    @Override
    protected SysTokenExample getPageExample(final String fieldName, final String keyword) {
        final SysTokenExample example = new SysTokenExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
