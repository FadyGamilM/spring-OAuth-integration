package com.springoauth.springoauth.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterUserDto {
    private String username;
    private String password;
}