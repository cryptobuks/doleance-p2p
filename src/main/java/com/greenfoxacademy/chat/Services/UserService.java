package com.greenfoxacademy.chat.Services;

import com.greenfoxacademy.chat.Models.User;
import com.greenfoxacademy.chat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Long countUser() {
        return userRepository.count();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
