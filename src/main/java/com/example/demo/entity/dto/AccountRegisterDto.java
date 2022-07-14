package com.example.demo.entity.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AccountRegisterDto {
    private long id;
    private String Username;
    private String password;
    private String confirmPassword;
    private int role;
}
