package com.allen.springframework.jdbc.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.allen.springframework.jdbc.dao.UserInfoDao;
import com.allen.springframework.jdbc.model.UserInfo;
import com.allen.springframework.jdbc.service.UserCombService;

/**
 *
 *
 *
 */
@Service
public class UserCombServiceImpl implements UserCombService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void saveREQUIRED() {
        int id = 2;
        String address = "上海";
        String email = "598717394@qq.com";
        String tel = "13122119298";
        UserInfo ui = new UserInfo();
        ui.setId(id);
        ui.setAddress(address);
        ui.setEmail(email);
        ui.setTel(tel);
        userInfoDao.saveUserInfo(ui);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public void savePROPAGATION_SUPPORTS() throws SQLException {
        int id = 2;
        String address = "上海";
        String email = "598717394@qq.com";
        String tel = "13122119298";
        UserInfo ui = new UserInfo();
        ui.setId(id);
        ui.setAddress(address);
        ui.setEmail(email);
        ui.setTel(tel);
        userInfoDao.saveUserInfo(ui);
    }

    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.MANDATORY)
    public void savePROPAGATION_MANDATORY() {
        int id = 4;
        String address = "上海";
        String email = "598717394@qq.com";
        String tel = "13122119298";
        UserInfo ui = new UserInfo();
        ui.setId(id);
        ui.setAddress(address);
        ui.setEmail(email);
        ui.setTel(tel);
        userInfoDao.saveUserInfo(ui);
    }
}
