package com.rizalfadiaalfikri.library.controller;

import com.rizalfadiaalfikri.library.dto.UserDTO;
import com.rizalfadiaalfikri.library.entity.User;
import com.rizalfadiaalfikri.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

}
