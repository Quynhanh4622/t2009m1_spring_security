package com.example.demo;

import com.example.demo.entity.dto.AccountRegisterDto;
import com.example.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = T2009m1SpringSecurityApplication.class)
public class Testapi {
    @Autowired
    AccountService accountService;

    @Test
    public void register(){
        AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
        accountRegisterDto.setUsername("quynhanh");
        accountRegisterDto.setPassword("123456");
        accountRegisterDto.setRole(1);
        AccountRegisterDto afterCreate = accountService.register(accountRegisterDto);
        System.out.println(afterCreate);
    }
}
