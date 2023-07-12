package org.web3soft.easytoken.wallet.service.impl;

import org.springframework.stereotype.Service;
import org.web3soft.commons.mybatis.service.AbstractCrudService;
import org.web3soft.easytoken.wallet.data.example.SysTokenBalanceExample;
import org.web3soft.easytoken.wallet.data.repository.SysTokenBalanceRepository;
import org.web3soft.easytoken.wallet.domain.SysTokenBalance;
import org.web3soft.easytoken.wallet.service.SysTokenBalanceService;

/**
 * 针对表【sys_token_balance(链上代币余额统计表)】的业务逻辑类
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:51
 */
@Service
public class SysTokenBalanceServiceImpl
        extends AbstractCrudService<SysTokenBalanceRepository, SysTokenBalance, SysTokenBalanceExample, Integer>
        implements SysTokenBalanceService {

    public SysTokenBalanceServiceImpl(final SysTokenBalanceRepository sysTokenBalanceRepository) {
        super(sysTokenBalanceRepository);
    }

    @Override
    protected SysTokenBalanceExample getPageExample(final String fieldName, final String keyword) {
        final SysTokenBalanceExample example = new SysTokenBalanceExample();
        example.createCriteria().andFieldLike(fieldName, keyword);
        return example;
    }

}
