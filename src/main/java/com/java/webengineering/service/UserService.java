package com.java.webengineering.service;

import com.java.webengineering.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll() ;
    public User getOne(String email);
    public void add(User user);
}

