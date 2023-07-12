package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainLatestBlockExample;
import org.web3soft.easytoken.wallet.domain.SysChainLatestBlock;

/**
 * 针对表【sys_chain_latest_block(链当前扫描的最新区块高度记录表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:36
 */
public interface SysChainLatestBlockService
        extends CrudService<SysChainLatestBlock, SysChainLatestBlockExample, Integer> {
}
