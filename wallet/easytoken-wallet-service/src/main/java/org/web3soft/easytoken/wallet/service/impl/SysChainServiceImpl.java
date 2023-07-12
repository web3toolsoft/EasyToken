package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainExample;
import org.web3soft.easytoken.wallet.data.repository.SysChainRepository;
import org.web3soft.easytoken.wallet.domain.SysChain;
import org.web3soft.easytoken.wallet.service.SysChainService;

/**
 * 针对表【sys_chain(区块链网络表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:32
 */
@Service
public class SysChainServiceImpl
        extends AbstractCrudService<SysChainRepository, SysChain, SysChainExample, Integer>
        implements SysChainService {

    public SysChainServiceImpl(final SysChainRepository sysChainRepository) {
        super(sysChainRepository);
    }

    @Override
    protected SysChainExample getPageExample(final String fieldName, final String keyword) {
        final SysChainExample example = new SysChainExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
