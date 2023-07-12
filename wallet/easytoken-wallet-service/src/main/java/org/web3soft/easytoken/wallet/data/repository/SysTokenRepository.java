package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysTokenExample;
import org.web3soft.easytoken.wallet.domain.SysToken;

/**
 * 针对表【sys_token(链上代币表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:49
 */
@Repository
public interface SysTokenRepository
        extends CrudRepository<SysToken, SysTokenExample, Integer> {
}