package com.example.demo.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Account;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class testGenerate {
    @Test
    public void testGenerateToken(){
        Account account = Account.builder()
                .id(System.currentTimeMillis())
                .role(1)
                .username("quynhanh123")
                .passwordHash("xyz")
                .build();
        String accessToken = JwtUtil.generateTokenByAccount(account, 15 * 24 * 60 * 60 * 1000);
        System.out.println(accessToken);
    }
}