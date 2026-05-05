package com.project.organix.service.impl;

import com.project.organix.model.User;
import com.project.organix.repository.UserRepository;
import com.project.organix.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Wajib ada agar Spring Boot tahu ini adalah Koki utamanya
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // INI ISINYA: Method overriding dari interface
    @Override
    public List<User> getAllUsers() {
        // Menggunakan repository untuk mengambil data dari database organix_db
        return userRepository.findAll(); 
    }
}