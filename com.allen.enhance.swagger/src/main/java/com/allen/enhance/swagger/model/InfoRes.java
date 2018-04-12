package com.allen.enhance.swagger.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class InfoRes {
    
    private String name;
    private Integer age;
    private Double salary;
    private Boolean admin;
    private Float increase;
    private Long currentTime = new Timestamp(System.currentTimeMillis()).getTime();  
  
}
