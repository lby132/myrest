package com.godcoder.myrest.repository;

import com.godcoder.myrest.model.User;

import java.util.List;

public interface CustomizedUserRepository {

    void findByUsernameCustom(User user);

    List<User> findByUsernameJdbc(String username);
}
