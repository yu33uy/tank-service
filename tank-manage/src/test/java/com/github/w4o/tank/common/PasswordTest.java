package com.github.w4o.tank.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author frank
 * @date 2021/10/10
 */
@Slf4j
public class PasswordTest {
    @Test
    void passwordEncode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        log.info("{}", encoder.encode("123456"));
    }
}
