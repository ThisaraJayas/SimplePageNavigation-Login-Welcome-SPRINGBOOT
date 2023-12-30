package com.newapp.MyApplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("Thisara");
        boolean isValidPassword = password.equalsIgnoreCase("123thisara");
        return isValidUsername && isValidPassword;

    }
}
