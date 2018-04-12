package com.allen.springframework.aop.demo2;

public interface LogService {

    public void saveLog(String context);
    
    public void saveLog2(Long id);

    public void noArg();
}
