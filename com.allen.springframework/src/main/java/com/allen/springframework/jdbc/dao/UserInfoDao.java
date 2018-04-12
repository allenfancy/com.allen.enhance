package com.allen.springframework.jdbc.dao;

import com.allen.springframework.jdbc.model.UserInfo;

public interface UserInfoDao {

    void saveUserInfo(UserInfo userInfo);

    UserInfo queryByID(Integer id);

    void deleteByID(Integer id);
}
