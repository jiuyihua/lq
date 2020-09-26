/*
package com.trade.lq.config;

import org.springframework.security.crypto.password.PasswordEncoder;

*/
/**
 * describle :
 * author : huh
 * 2020/9/16 0016
 * 下午 5:48
 *//*

@Deprecated
public final class NoOpPasswordEncoder implements PasswordEncoder {

    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    */
/**
     * Get the singleton {@link NoOpPasswordEncoder}.
     *//*

    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private static final PasswordEncoder INSTANCE = new NoOpPasswordEncoder();

    private NoOpPasswordEncoder() {
    }

}*/
