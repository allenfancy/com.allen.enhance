package com.allen.springframework.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.springframework.jdbc.service.UserService;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-jdbc.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testPROPAGATION_REQUIRED() throws SQLException {
        userService.saveREQUIRED();
    }

    @Test
    public void testPROPAGATION_SUPPORTS() throws SQLException {
        userService.savePROPAGATION_SUPPORTS();
    }

    @Test
    public void testPROPAGATION_MANDATORY() {
        userService.savePROPAGATION_MANDATORY();
    }

    @Test
    public void testPROPAGATION_REQUIRES_NEW() {

    }


    @Test
    public void testPROPAGATION_NOT_SUPPORTED() {

    }

    @Test
    public void testPROPAGATION_NEVER() {

    }

    @Test
    public void testPROPAGATION_NESTED() {

    }

    @Test
    public void testISOLATION_READ_UNCOMMITTED() {

    }

    @Test
    public void testISOLATION_READ_COMMITTED() {

    }

    @Test
    public void testISOLATION_REPEATABLE_READ() {

    }

    @Test
    public void testISOLATION_SERIALIZABLE() {

    }
}
