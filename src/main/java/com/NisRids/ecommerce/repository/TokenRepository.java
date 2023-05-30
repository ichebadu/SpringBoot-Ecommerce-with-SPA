package com.NisRids.ecommerce.repository;

import com.NisRids.ecommerce.model.AuthenticationToken;
import com.NisRids.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
}
