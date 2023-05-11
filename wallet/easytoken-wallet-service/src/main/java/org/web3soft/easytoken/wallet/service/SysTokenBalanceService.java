package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenBalanceExample;
import org.web3soft.easytoken.wallet.domain.SysTokenBalance;

/**
 * 针对表【sys_token_balance(链上代币余额统计表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:51
 */
public interface SysTokenBalanceService
        extends CrudService<SysTokenBalance, SysTokenBalanceExample, Integer> {
}
