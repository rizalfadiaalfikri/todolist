package com.rizalfadiaalfikri.library;

import com.rizalfadiaalfikri.library.entity.Role;
import com.rizalfadiaalfikri.library.entity.User;
import com.rizalfadiaalfikri.library.repository.RoleRepository;
import com.rizalfadiaalfikri.library.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
