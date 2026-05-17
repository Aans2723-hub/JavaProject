package com.project.organix.service.impl;

import com.project.organix.exception.ResourceNotFoundException;
import com.project.organix.model.User;
import com.project.organix.repository.UserRepository;
import com.project.organix.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User dengan ID " + id + " tidak ditemukan"));
    }

    @Override
    public User registerUser(User user) {
        // Poin awal warga baru selalu 0
        user.setTotalPoint(0);
        return userRepository.save(user);
    }
}