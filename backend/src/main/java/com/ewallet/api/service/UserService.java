package com.ewallet.api.service;

import com.ewallet.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ewallet.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }
}
