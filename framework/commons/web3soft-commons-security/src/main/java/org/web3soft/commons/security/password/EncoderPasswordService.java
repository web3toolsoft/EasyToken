package org.web3soft.commons.security.password;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.web3soft.commons.security.PasswordService;

/**
 * 基于{@link PasswordEncoder}密码服务类
 *
 * @author web3soft-team
 * @date 2023/08/08
 **/
public class EncoderPasswordService implements PasswordService {
    private final PasswordEncoder passwordEncoder;

    public EncoderPasswordService(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String genreateSalt() {
        return StringUtils.EMPTY;
    }

    @Override
    public String encode(final CharSequence rawPassword, final String credentialsSalt) {
        return this.passwordEncoder.encode(rawPassword);
    }

    @Override
    public String encode(final CharSequence rawPassword) {
        return this.encode(rawPassword, "");
    }

    @Override
    public boolean matches(final CharSequence rawPassword, final String encodedPassword) {
        return this.matches(rawPassword, encodedPassword, "");
    }

    @Override
    public boolean matches(final CharSequence rawPassword, final String encodedPassword, final String credentialsSalt) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
