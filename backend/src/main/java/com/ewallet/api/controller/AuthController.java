package com.ewallet.api.controller;

import com.ewallet.api.dto.request.RegisterRequest;
import com.ewallet.api.model.User;
import com.ewallet.api.repository.UserRepository;
import com.ewallet.api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//Handles user sign-in and sign-up requests.
//Generates JWT tokens upon successful authentication.
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // generate token for validation
        return jwtUtils.generateToken(userDetails.getUsername());
    }
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        // Create new user's account
        String encodedPassword = encoder.encode(user.getPassword());
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setEnabled(true); // Assuming the user is enabled by default
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setCreatedBy("user"); // Assuming the user is created by the system

        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }
}