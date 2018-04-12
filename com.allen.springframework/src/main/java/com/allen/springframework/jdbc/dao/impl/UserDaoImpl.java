package com.allen.springframework.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.allen.springframework.jdbc.dao.UserDao;
import com.allen.springframework.jdbc.model.User;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "insert into user(id,name) value(?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName());
    }

    @Override
    public void deleteUser(Integer id) {
        jdbcTemplate.update("delete user where id = ?" + id);
    }

    @Override
    public User queryByID(Integer id) {
        User user = jdbcTemplate.queryForObject("select * from user where id = ? ", User.class, id);
        return user;
    }

    @Override
    public List<User> queryByIDs(Integer start, Integer end) {
        return new ArrayList<User>();
    }

}
