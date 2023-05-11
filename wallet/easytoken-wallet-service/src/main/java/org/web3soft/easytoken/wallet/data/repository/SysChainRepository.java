package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysChainExample;
import org.web3soft.easytoken.wallet.domain.SysChain;

/**
 * 针对表【sys_chain(区块链网络表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:32
 */
@Repository
public interface SysChainRepository
        extends CrudRepository<SysChain, SysChainExample, Integer> {
}