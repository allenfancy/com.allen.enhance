package com.allen.springframework.jdbc.service;

import java.sql.SQLException;

public interface UserService {

    void saveREQUIRED() throws SQLException;
    
    void savePROPAGATION_SUPPORTS() throws SQLException;
    
    void savePROPAGATION_MANDATORY(); 

}
