package com.example.kuafor.service;

import com.example.kuafor.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    void save(User user);
    Optional<User> findByUsername(String username);
}

