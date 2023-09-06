package com.example.springapi.user;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Get All User")
    public ResponseEntity<List<User>> get() {
        log.info("Getting all user...");
        return ResponseEntity.ok(userRepository.findAll());
    }

    @Transactional
    @PostMapping
    @Operation(summary = "Create New User")
    public ResponseEntity<Void> create(@RequestBody User user) {
        log.info("Creating new user...");
        user.setId(null);
        userRepository.save(user);
        log.info("User created...");
        return ResponseEntity.noContent().build();
    }
}
