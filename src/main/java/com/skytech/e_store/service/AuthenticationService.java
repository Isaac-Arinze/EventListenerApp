package com.skytech.e_store.service;

import com.skytech.e_store.config.MessageStrings;
import com.skytech.e_store.exceptions.AuthenticationFailException;
import com.skytech.e_store.model.AuthenticationToken;
import com.skytech.e_store.model.User;
import com.skytech.e_store.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository repository;

//    save the confirmation token
    public void saveConfirmationToken (AuthenticationToken authenticationToken) {
        repository.save(authenticationToken);
    }

//    get token of the user
        public AuthenticationToken getToken(User user) {
            return repository.findTokenByUser(user);
        }

//    get user from the token
    public User getUser(String token) {
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        if (Objects.nonNull(authenticationToken)) {
            if (Objects.nonNull(authenticationToken.getUser())) {
                return authenticationToken.getUser();
            }
        }
        return null;
    }

//    Check if the token is valid
    public void authenticate(String token) throws AuthenticationFailException {
        if (!Objects.nonNull(token)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if (!Objects.nonNull(getUser(token))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }

}
