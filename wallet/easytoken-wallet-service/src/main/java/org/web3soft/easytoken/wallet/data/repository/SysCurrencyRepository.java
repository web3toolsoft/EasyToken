package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysCurrencyExample;
import org.web3soft.easytoken.wallet.domain.SysCurrency;

/**
 * 针对表【sys_currency(币种表)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:43
 */
@Repository
public interface SysCurrencyRepository
        extends CrudRepository<SysCurrency, SysCurrencyExample, Integer> {
}