package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysChainRpcConfExample;
import org.web3soft.easytoken.wallet.domain.SysChainRpcConf;

/**
 * 针对表【sys_chain_rpc_conf(链节点RPC配置表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:39
 */
@Repository
public interface SysChainRpcConfRepository
        extends CrudRepository<SysChainRpcConf, SysChainRpcConfExample, Integer> {
}