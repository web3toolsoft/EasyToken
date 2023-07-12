package org.web3soft.easytoken.wallet.service;

import org.web3soft.commons.mybatis.service.CrudService;
import org.web3soft.easytoken.wallet.data.example.SysCurrencyExample;
import org.web3soft.easytoken.wallet.domain.SysCurrency;

/**
 * 针对表【sys_currency(币种表)】的业务逻辑接口
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:43
 */
public interface SysCurrencyService
        extends CrudService<SysCurrency, SysCurrencyExample, Integer> {
}
