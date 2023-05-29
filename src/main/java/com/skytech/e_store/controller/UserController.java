package com.skytech.e_store.controller;

import com.skytech.e_store.dto.user.SignInDto;
import com.skytech.e_store.dto.user.SignInResponseDto;
import com.skytech.e_store.dto.user.SignUpResponseDto;
import com.skytech.e_store.dto.user.SignupDto;
import com.skytech.e_store.exceptions.AuthenticationFailException;
import com.skytech.e_store.exceptions.CustomException;
//import com.skytech.e_store.service.UserService;
import com.skytech.e_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto Signin (@RequestBody SignInDto signInDto) throws CustomException, AuthenticationFailException {
        return userService.signIn(signInDto);
    }
}
