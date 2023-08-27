package com.java.webengineering.dao;

import com.java.webengineering.model.User;

import java.util.List;


public interface UserDAO {

    List<User> getAll() ;
    public User getOne(String email);
    public void add(User user);
}
