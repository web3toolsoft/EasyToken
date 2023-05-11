package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysTokenBalanceExample;
import org.web3soft.easytoken.wallet.domain.SysTokenBalance;

/**
 * 针对表【sys_token_balance(链上代币余额统计表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:51
 */
@Repository
public interface SysTokenBalanceRepository
        extends CrudRepository<SysTokenBalance, SysTokenBalanceExample, Integer> {
}