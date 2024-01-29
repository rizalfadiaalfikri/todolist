package com.rizalfadiaalfikri.library.service.impl;

import com.rizalfadiaalfikri.library.dto.LoginResponseDTO;
import com.rizalfadiaalfikri.library.dto.UserDTO;
import com.rizalfadiaalfikri.library.entity.Role;
import com.rizalfadiaalfikri.library.entity.User;
import com.rizalfadiaalfikri.library.repository.RoleRepository;
import com.rizalfadiaalfikri.library.repository.UserRepository;
import com.rizalfadiaalfikri.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServiceImpl tokenService;

    @Override
    public User registerUser(UserDTO userDTO) {
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new User(0L, userDTO.getName(), userDTO.getUsername(), userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()), authorities));
    }

    @Override
    public LoginResponseDTO login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            String token = tokenService.generateJWT(authentication);
            return new LoginResponseDTO(username, token, "Bearer");
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("bad credentoals");
        }
    }
}
