package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysChainExample;
import org.web3soft.easytoken.wallet.domain.SysChain;

/**
 * 针对表【sys_chain(区块链网络表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:32
 */
public interface SysChainService
        extends CrudService<SysChain, SysChainExample, Integer> {
}
