package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysTokenStandardExample;
import org.web3soft.easytoken.wallet.domain.SysTokenStandard;

/**
 * 针对表【sys_token_standard(链上币种协议表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:54
 */
@Repository
public interface SysTokenStandardRepository
        extends CrudRepository<SysTokenStandard, SysTokenStandardExample, Integer> {
}