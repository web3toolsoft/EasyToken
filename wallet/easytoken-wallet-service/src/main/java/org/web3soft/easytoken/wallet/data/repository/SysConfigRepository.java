package org.web3soft.easytoken.wallet.data.repository;

import org.springframework.stereotype.Repository;
import org.web3soft.commons.mybatis.data.CrudRepository;
import org.web3soft.easytoken.wallet.data.example.SysConfigExample;
import org.web3soft.easytoken.wallet.domain.SysConfig;

/**
 * 针对表【sys_config(配置表:name/value结构)】的数据库访问操作
 *
 * @author Tom Deng
 * @date 2023-05-10 21:52:41
 */
@Repository
public interface SysConfigRepository
        extends CrudRepository<SysConfig, SysConfigExample, Integer> {
}