package org.web3soft.commons.security.config;/*
package org.web3soft.commons.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

*/
/**
 * @author web3soft-team
 **//*

public class BasicWebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected SecurityProperties security;

    public BasicWebSecurityConfig(final SecurityProperties security) {
        super();
        this.security = security;
    }

    @Override
    public void configure(final WebSecurity web) {
        //web.httpFirewall(new DefaultHttpFirewall());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .headers()
                .httpStrictTransportSecurity()
                .requestMatcher(AnyRequestMatcher.INSTANCE);

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .anyRequest()
                .permitAll();
    }
}
*/
