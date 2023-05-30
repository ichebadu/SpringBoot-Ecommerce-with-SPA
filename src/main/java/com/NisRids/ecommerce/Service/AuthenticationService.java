package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.config.MessageStrings;
import com.NisRids.ecommerce.exceptions.AuthenticationFailException;
import com.NisRids.ecommerce.model.AuthenticationToken;
import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.repository.TokenRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    TokenRepository repository;

    public void  saveConfirmationToken(AuthenticationToken authenticationToken){
        repository.save(authenticationToken);
    }
    public AuthenticationToken getToken(User user){
        return repository.findTokenByUser(user);
    }

    public User getUser(String token){
        AuthenticationToken authenticationToken = repository.findTokenByToken(token);
        System.out.println(authenticationToken);
        if(Objects.nonNull(authenticationToken)){
            if(Objects.nonNull(authenticationToken.getUser())){
                return authenticationToken.getUser();
            }
        }
            return null;
    }

    public void authenticate(String token) throws AuthenticationFailException {
        if(!Objects.nonNull(token)){
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }
        if(!Objects.nonNull(getUser(token))){
            throw new AuthenticationFailException(MessageStrings.AUTH_TOKEN_NOT_VALID);
        }
    }
}
