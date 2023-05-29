package com.skytech.e_store.service;

import com.skytech.e_store.config.MessageStrings;
import com.skytech.e_store.dto.user.SignInDto;
import com.skytech.e_store.dto.user.SignInResponseDto;
import com.skytech.e_store.dto.user.SignUpResponseDto;
import com.skytech.e_store.dto.user.SignupDto;
import com.skytech.e_store.exceptions.AuthenticationFailException;
import com.skytech.e_store.exceptions.CustomException;
import com.skytech.e_store.model.AuthenticationToken;
import com.skytech.e_store.model.User;
import com.skytech.e_store.repository.UserRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public SignUpResponseDto signUp(SignupDto signupDto) throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("user already exists");
        }

//        first encrypt the password
        String encryptedPassword = signupDto.getPassword();

        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }
        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), encryptedPassword);

        try {
//            Save the user
            userRepository.save(user);
//            success in creating
            return new SignUpResponseDto("success", "user created successfully");
        } catch (Exception e) {
//            handle signup error

            throw new CustomException(e.getMessage());
        }
    }

    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public SignInResponseDto signIn(SignInDto signInDto) throws AuthenticationFailException, CustomException {
        // first find User by email
        User user = userRepository.findByEmail(signInDto.getEmail());
        if (!Objects.nonNull(user)) {
            throw new AuthenticationFailException("user not present");
        }
        try {
            // check if password is right
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                // passwords do not match
                throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(user);
        if (!Objects.nonNull(token)) {
            // token not present
            throw new CustomException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        return new SignInResponseDto("success", token.getToken());
    }
    }
