package org.web3soft.commons.security.password;

import org.web3soft.commons.security.PasswordService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Md5Hex(Md5Hex(pwd+salt))
 */
public class Md5PasswordService implements PasswordService {

    @Override
    public String genreateSalt() {
        final String[] codes = new String[]{
                "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; ++i) {
            sb.append(codes[RandomUtils.nextInt(0, codes.length)]);
        }
        return sb.toString();
    }

    @Override
    public String encode(final CharSequence rawPassword, final String credentialsSalt) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(rawPassword + credentialsSalt));
    }

    @Override
    public String encode(final CharSequence rawPassword) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(rawPassword.toString()));
    }

    @Override
    public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
        return StringUtils.equals(this.encode(rawPassword), encodedPassword);
    }

    @Override
    public boolean matches(final CharSequence rawPassword, final String encodedPassword, final String credentialsSalt) {
        return StringUtils.equals(this.encode(rawPassword, credentialsSalt), encodedPassword);
    }
}
