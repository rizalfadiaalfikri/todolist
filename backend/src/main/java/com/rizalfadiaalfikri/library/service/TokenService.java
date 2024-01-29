package com.rizalfadiaalfikri.library.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    public String generateJWT(Authentication authentication);
}
