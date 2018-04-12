package com.allen.springframework.jdbc.dao;

import java.util.List;

import com.allen.springframework.jdbc.model.User;


public interface UserDao {

    void save(User user);

    void deleteUser(Integer id);

    User queryByID(Integer id);

    List<User> queryByIDs(Integer start, Integer end);
}
