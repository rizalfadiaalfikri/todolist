package com.rizalfadiaalfikri.library.controller;

import com.rizalfadiaalfikri.library.dto.LoginResponseDTO;
import com.rizalfadiaalfikri.library.dto.UserDTO;
import com.rizalfadiaalfikri.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<LoginResponseDTO>(userService.login(userDTO.getUsername(), userDTO.getPassword()),
                HttpStatus.OK);
    }

}
