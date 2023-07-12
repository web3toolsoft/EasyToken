package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysConfigExample;
import org.web3soft.easytoken.wallet.domain.SysConfig;

/**
 * 针对表【sys_config(配置表:name/value结构)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:41
 */
public interface SysConfigService
        extends CrudService<SysConfig, SysConfigExample, Integer> {
}
