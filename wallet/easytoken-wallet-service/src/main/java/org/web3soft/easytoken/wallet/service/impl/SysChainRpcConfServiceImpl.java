package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainRpcConfExample;
import org.web3soft.easytoken.wallet.data.repository.SysChainRpcConfRepository;
import org.web3soft.easytoken.wallet.domain.SysChainRpcConf;
import org.web3soft.easytoken.wallet.service.SysChainRpcConfService;

/**
 * 针对表【sys_chain_rpc_conf(链节点RPC配置表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:39
 */
@Service
public class SysChainRpcConfServiceImpl
        extends AbstractCrudService<SysChainRpcConfRepository, SysChainRpcConf, SysChainRpcConfExample, Integer>
        implements SysChainRpcConfService {

    public SysChainRpcConfServiceImpl(final SysChainRpcConfRepository sysChainRpcConfRepository) {
        super(sysChainRpcConfRepository);
    }

    @Override
    protected SysChainRpcConfExample getPageExample(final String fieldName, final String keyword) {
        final SysChainRpcConfExample example = new SysChainRpcConfExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
