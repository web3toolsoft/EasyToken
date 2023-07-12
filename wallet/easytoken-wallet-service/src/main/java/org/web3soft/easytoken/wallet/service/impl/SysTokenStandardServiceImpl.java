package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenStandardExample;
import org.web3soft.easytoken.wallet.data.repository.SysTokenStandardRepository;
import org.web3soft.easytoken.wallet.domain.SysTokenStandard;
import org.web3soft.easytoken.wallet.service.SysTokenStandardService;

/**
 * 针对表【sys_token_standard(链上币种协议表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:54
 */
@Service
public class SysTokenStandardServiceImpl
        extends AbstractCrudService<SysTokenStandardRepository, SysTokenStandard, SysTokenStandardExample, Integer>
        implements SysTokenStandardService {

    public SysTokenStandardServiceImpl(final SysTokenStandardRepository sysTokenStandardRepository) {
        super(sysTokenStandardRepository);
    }

    @Override
    protected SysTokenStandardExample getPageExample(final String fieldName, final String keyword) {
        final SysTokenStandardExample example = new SysTokenStandardExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
