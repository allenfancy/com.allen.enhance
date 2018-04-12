package com.allen.springframework.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.allen.springframework.jdbc.dao.UserInfoDao;
import com.allen.springframework.jdbc.model.UserInfo;


@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        String sql = "insert into user_info(id,address,tel,email) value(?,?,?,?)";
        jdbcTemplate.update(sql, userInfo.getId(), userInfo.getAddress(), userInfo.getTel(),
                userInfo.getEmail());
    }

    @Override
    public UserInfo queryByID(Integer id) {
        return jdbcTemplate.queryForObject("select * from user_info where id = ? ", UserInfo.class, id);
    }

    @Override
    public void deleteByID(Integer id) {
        jdbcTemplate.update("delete user_info where id = ?" + id);
    }

}
