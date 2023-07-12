package org.web3soft.commons.security;

/**
 * <p>PasswordService interface.</p>
 *
 * @author web3soft-team
 */
public interface PasswordService {
    /**
     * <p>genreateSalt.</p>
     *
     * @return salt.toHex()
     */
    String genreateSalt();

    /**
     * <p>encode.</p>
     *
     * @param rawPassword     a {@link CharSequence} object.
     * @param credentialsSalt a {@link String} object.
     * @return a {@link String} object.
     */
    String encode(CharSequence rawPassword, String credentialsSalt);

    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword a {@link CharSequence} object.
     * @return a {@link String} object.
     */
    String encode(CharSequence rawPassword);

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @param credentialsSalt salt
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    boolean matches(CharSequence rawPassword, String encodedPassword, String credentialsSalt);
}
