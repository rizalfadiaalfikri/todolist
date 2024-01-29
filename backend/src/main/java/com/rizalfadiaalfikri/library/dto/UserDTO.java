package com.rizalfadiaalfikri.library.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String username;
    private String email;
    private String password;

}
