package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysServerNodeExample;
import org.web3soft.easytoken.wallet.data.repository.SysServerNodeRepository;
import org.web3soft.easytoken.wallet.domain.SysServerNode;
import org.web3soft.easytoken.wallet.service.SysServerNodeService;

/**
 * 针对表【sys_server_node(钱包部署服务节点表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:46
 */
@Service
public class SysServerNodeServiceImpl
        extends AbstractCrudService<SysServerNodeRepository, SysServerNode, SysServerNodeExample, Integer>
        implements SysServerNodeService {

    public SysServerNodeServiceImpl(final SysServerNodeRepository sysServerNodeRepository) {
        super(sysServerNodeRepository);
    }

    @Override
    protected SysServerNodeExample getPageExample(final String fieldName, final String keyword) {
        final SysServerNodeExample example = new SysServerNodeExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
