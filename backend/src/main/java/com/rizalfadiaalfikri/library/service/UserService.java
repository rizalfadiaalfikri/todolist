package com.rizalfadiaalfikri.library.service;

import com.rizalfadiaalfikri.library.dto.LoginResponseDTO;
import com.rizalfadiaalfikri.library.dto.UserDTO;
import com.rizalfadiaalfikri.library.entity.User;

public interface UserService {

    public User registerUser(UserDTO userDTO);
    public LoginResponseDTO login(String username, String password);
}
