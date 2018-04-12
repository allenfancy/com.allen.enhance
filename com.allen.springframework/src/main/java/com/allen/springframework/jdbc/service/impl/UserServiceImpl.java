package com.allen.springframework.jdbc.service.impl;

import com.allen.springframework.jdbc.dao.UserDao;
import com.allen.springframework.jdbc.model.User;
import com.allen.springframework.jdbc.service.UserCombService;
import com.allen.springframework.jdbc.service.UserService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 1.Propagation.REQUIRED UserService.save() -> UserCombService.save()
 * UserCombService.save()事务的传播行为是REQUIRED 
     * 1.UserCombService.save()不会开启新的事务，使用上层事务
     * 2.UserCombService.save()抛出异常,UserService.save()没有捕获，则俩个事务都会回滚
     * 3.UserCombService.save()抛出异常,UserService.save()捕获，则Rollback Only
     * 4.UserService.save()运行期间异常,则来个事务都会回滚
 * 
 * 2.Propagation.SUPPORTS UserService.savePROPAGATION_SUPPORTS() ->
 * UserCombService.savePROPAGATION_SUPPORTS() 事务的传播行为是SUPPORTS 
     * 1.A中包含事务，则B运行在此事务环境中，如果A的方法不包含事务，则B运行非事务环境中
     * 2.如果A有事务,A的method方法执行抛出异常，B.methodB和A.methodA都会回滚
     * 3.如果A有事务，B.method抛出异常，B.methodB和A.methodA都会回滚，如果A捕获了B.method()抛出异常，则会出现Transcationrolled back because it maked as rollback-only.
     * 
 * 3.Propagation.MANDATORY UserService.saveMANDATORY()(A) -> UserCombService.MANDATORY() (B) 
 * 1.userService方法必须在事务中，否则 userCombService抛出异常
 * 2.如果A的方法由事务，并且执行过程中抛出异常，那么A和B都会回滚
 * 3.如果A的方法中有事务，并且B抛出异常，没有捕获，回滚，捕获，抛出异常.
 * 
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCombService userCombService;

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            noRollbackFor = Exception.class)
    public void saveREQUIRED() throws SQLException {
        int id = 4;
        String name = "allen";
        User user = new User();
        user.setId(id);
        user.setName(name);
        userDao.save(user);
        try {
            userCombService.saveREQUIRED();
        } catch (Exception e) {
            System.out.println("异常=>" + e.getMessage());
        }
    }



    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public void savePROPAGATION_SUPPORTS() throws SQLException {
        int id = 3;
        String name = "allen";
        User user = new User();
        user.setId(id);
        user.setName(name);
        userDao.save(user);
        try {
            userCombService.savePROPAGATION_SUPPORTS();
        } catch (Exception e) {
            System.out.println("异常=>" + e.getMessage());
        }
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,noRollbackFor= {Exception.class,MySQLIntegrityConstraintViolationException.class})
    public void savePROPAGATION_MANDATORY() {
        int id = 8;
        String name = "allen";
        User user = new User();
        user.setId(id);
        user.setName(name);
        userDao.save(user);
        try {
            userCombService.savePROPAGATION_MANDATORY();
        } catch (Exception e) {
            System.out.println("异常=>" + e.getMessage());
        }
    }
}
