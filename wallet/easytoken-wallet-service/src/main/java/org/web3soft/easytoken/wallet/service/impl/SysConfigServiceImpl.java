package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysConfigExample;
import org.web3soft.easytoken.wallet.data.repository.SysConfigRepository;
import org.web3soft.easytoken.wallet.domain.SysConfig;
import org.web3soft.easytoken.wallet.service.SysConfigService;

/**
 * 针对表【sys_config(配置表:name/value结构)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:41
 */
@Service
public class SysConfigServiceImpl
        extends AbstractCrudService<SysConfigRepository, SysConfig, SysConfigExample, Integer>
        implements SysConfigService {

    public SysConfigServiceImpl(final SysConfigRepository sysConfigRepository) {
        super(sysConfigRepository);
    }

    @Override
    protected SysConfigExample getPageExample(final String fieldName, final String keyword) {
        final SysConfigExample example = new SysConfigExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
