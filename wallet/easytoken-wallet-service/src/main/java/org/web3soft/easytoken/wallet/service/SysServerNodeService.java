package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysServerNodeExample;
import org.web3soft.easytoken.wallet.domain.SysServerNode;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:46
 */
public interface SysServerNodeService
        extends CrudService<SysServerNode, SysServerNodeExample, Integer> {
}
