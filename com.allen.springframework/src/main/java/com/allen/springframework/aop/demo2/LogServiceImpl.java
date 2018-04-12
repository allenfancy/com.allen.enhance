package com.allen.springframework.aop.demo2;

import com.allen.springframework.aop.basic.AdminOnly;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {


    @Override
    @AdminOnly
    public void saveLog(String context) {
        System.out.println(context);
    }

    @Override
    @AdminOnly(value = "user")
    public void saveLog2(Long id) {
        System.out.println(id);
    }

    @Override
    public void noArg() {
        System.out.println("no arg");
    }
}
