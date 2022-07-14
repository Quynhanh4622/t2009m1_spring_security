package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.dto.AccountRegisterDto;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    final AccountRepository accountRepository;
    final PasswordEncoder passwordEncoder;

    public AccountRegisterDto register(AccountRegisterDto accountRegisterDto){
       Optional<Account> optionalAccount =  accountRepository.findAccountByUsername(accountRegisterDto.getUsername());
       if (optionalAccount.isPresent()){
           return null;
       }
       Account account = Account.builder()
               .username(accountRegisterDto.getUsername())
               .passwordHash(passwordEncoder.encode(accountRegisterDto.getPassword()))
               .role(accountRegisterDto.getRole())
               .build();
        accountRepository.save(account);
        accountRegisterDto.setId(account.getId());
        return accountRegisterDto;
    }

    public void login(){

    }

    public void getInformation(){

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findAccountByUsername(username);
        return null;
    }
}
