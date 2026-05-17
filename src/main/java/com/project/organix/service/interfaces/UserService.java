package com.project.organix.service.interfaces;

import com.project.organix.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User registerUser(User user);
}