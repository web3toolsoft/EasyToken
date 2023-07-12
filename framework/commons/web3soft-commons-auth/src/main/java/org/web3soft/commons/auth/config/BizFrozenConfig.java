package org.web3soft.commons.auth.config;

import org.web3soft.commons.dictionary.enums.BizTypeEnum;

/**
 * @author web3soft-team
 */
public class BizFrozenConfig {
    private BizTypeEnum bizType;

    public BizTypeEnum getBizType() {
        return this.bizType;
    }

    public void setBizType(final BizTypeEnum bizType) {
        this.bizType = bizType;
    }
}
