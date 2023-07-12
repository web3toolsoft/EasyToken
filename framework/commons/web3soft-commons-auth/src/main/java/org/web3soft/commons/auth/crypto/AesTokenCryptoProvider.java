package org.web3soft.commons.auth.crypto;

import org.web3soft.commons.lang.crypto.AESUtil;

/**
 * AES 加/解密提供者类
 *
 * @author web3soft-team
 */
public class AesTokenCryptoProvider implements TokenCryptoProvider {
    @Override
    public String encrypt(final String content, final String key) {
        return AESUtil.encrypt(content, key);
    }

    @Override
    public String decrypt(final String content, final String key) {
        return AESUtil.decrypt(content, key);
    }
}
