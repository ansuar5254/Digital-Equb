package com.equb.digitalequb.repository;

import com.equb.digitalequb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (for login)
    Optional<User> findByEmail(String email);

    // Find user by username
    Optional<User> findByUsername(String username);

    // Check if email already exists (for registration)
    boolean existsByEmail(String email);

    // Check if username already exists (for registration)
    boolean existsByUsername(String username);
}