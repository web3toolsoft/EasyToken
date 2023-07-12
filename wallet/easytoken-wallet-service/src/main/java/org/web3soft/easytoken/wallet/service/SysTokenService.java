package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenExample;
import org.web3soft.easytoken.wallet.domain.SysToken;

/**
 * 针对表【sys_token(链上代币表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:49
 */
public interface SysTokenService
        extends CrudService<SysToken, SysTokenExample, Integer> {
}
