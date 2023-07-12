package org.web3soft.commons.auth.crypto;

/**
 * @author web3soft-team
 */
public interface TokenCryptoProvider {
    /**
     * @param content
     * @param key
     * @return encode
     */
    String encrypt(final String content, final String key);

    /**
     * @param content
     * @param key
     * @return decode
     */
    String decrypt(final String content, final String key);

}
