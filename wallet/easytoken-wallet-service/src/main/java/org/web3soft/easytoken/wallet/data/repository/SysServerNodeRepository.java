package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysServerNodeExample;
import org.web3soft.easytoken.wallet.domain.SysServerNode;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:46
 */
@Repository
public interface SysServerNodeRepository
        extends CrudRepository<SysServerNode, SysServerNodeExample, Integer> {
}