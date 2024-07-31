package com.example.demo.service;

import com.example.demo.model.User;

public interface ServiceUser {
    User createUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    boolean validatePassword(User user, String password);


}
