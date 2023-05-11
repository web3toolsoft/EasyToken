package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysChainLatestBlockExample;
import org.web3soft.easytoken.wallet.domain.SysChainLatestBlock;

/**
 * 针对表【sys_chain_latest_block(链当前扫描的最新区块高度记录表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:36
 */
@Repository
public interface SysChainLatestBlockRepository
        extends CrudRepository<SysChainLatestBlock, SysChainLatestBlockExample, Integer> {
}