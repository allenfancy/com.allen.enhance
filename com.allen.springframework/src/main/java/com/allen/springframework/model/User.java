package com.allen.springframework.model;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

    @Size(min=2,max=16,message="昵称长度只能在2-16字符之间")
    private String name;
    private Integer age;
    private Double salary;
}
