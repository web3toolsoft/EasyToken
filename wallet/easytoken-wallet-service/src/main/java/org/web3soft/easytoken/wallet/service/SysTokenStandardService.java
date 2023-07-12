package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenStandardExample;
import org.web3soft.easytoken.wallet.domain.SysTokenStandard;

/**
 * 针对表【sys_token_standard(链上币种协议表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:54
 */
public interface SysTokenStandardService
        extends CrudService<SysTokenStandard, SysTokenStandardExample, Integer> {
}
