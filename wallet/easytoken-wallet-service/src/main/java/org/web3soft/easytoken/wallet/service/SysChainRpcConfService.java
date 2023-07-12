package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainRpcConfExample;
import org.web3soft.easytoken.wallet.domain.SysChainRpcConf;

/**
 * 针对表【sys_chain_rpc_conf(链节点RPC配置表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:39
 */
public interface SysChainRpcConfService
        extends CrudService<SysChainRpcConf, SysChainRpcConfExample, Integer> {
}
