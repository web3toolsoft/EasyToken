package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysCurrencyExample;
import org.web3soft.easytoken.wallet.data.repository.SysCurrencyRepository;
import org.web3soft.easytoken.wallet.domain.SysCurrency;
import org.web3soft.easytoken.wallet.service.SysCurrencyService;

/**
 * 针对表【sys_currency(币种表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:43
 */
@Service
public class SysCurrencyServiceImpl
        extends AbstractCrudService<SysCurrencyRepository, SysCurrency, SysCurrencyExample, Integer>
        implements SysCurrencyService {

    public SysCurrencyServiceImpl(final SysCurrencyRepository sysCurrencyRepository) {
        super(sysCurrencyRepository);
    }

    @Override
    protected SysCurrencyExample getPageExample(final String fieldName, final String keyword) {
        final SysCurrencyExample example = new SysCurrencyExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
