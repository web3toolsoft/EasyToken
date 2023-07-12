package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainLatestBlockExample;
import org.web3soft.easytoken.wallet.data.repository.SysChainLatestBlockRepository;
import org.web3soft.easytoken.wallet.domain.SysChainLatestBlock;
import org.web3soft.easytoken.wallet.service.SysChainLatestBlockService;

/**
 * 针对表【sys_chain_latest_block(链当前扫描的最新区块高度记录表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:36
 */
@Service
public class SysChainLatestBlockServiceImpl
        extends AbstractCrudService<SysChainLatestBlockRepository, SysChainLatestBlock, SysChainLatestBlockExample, Integer>
        implements SysChainLatestBlockService {

    public SysChainLatestBlockServiceImpl(final SysChainLatestBlockRepository sysChainLatestBlockRepository) {
        super(sysChainLatestBlockRepository);
    }

    @Override
    protected SysChainLatestBlockExample getPageExample(final String fieldName, final String keyword) {
        final SysChainLatestBlockExample example = new SysChainLatestBlockExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
