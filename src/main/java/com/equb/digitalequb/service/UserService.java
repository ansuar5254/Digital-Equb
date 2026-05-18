package com.equb.digitalequb.service;

import com.equb.digitalequb.model.User;
import com.equb.digitalequb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // Password encoder - encrypts passwords so they're not stored as plain text
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public User registerUser(User user) {
        // Step 1: Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        
        // Step 2: Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        
        // Step 3: Encrypt the password (never store plain text passwords!)
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Step 4: Set default role if not provided
        if (user.getRole() == null) {
            user.setRole("MEMBER");
        }
        
        // Step 5: Set account as active
        user.setIsActive(true);
        
        // Step 6: Save to database
        return userRepository.save(user);
    }
}