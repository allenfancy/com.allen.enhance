package com.allen.springframework.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.allen.springframework.model.User;
import com.allen.springframework.service.UserService;

public class UserServiceImpl implements UserService,BeanNameAware,BeanFactoryAware,InitializingBean,BeanPostProcessor,DisposableBean {

    private BeanFactory beanFactory;
    
    private String beanName;
    
    @Override
    public void save(User user) {
        System.out.println("保存 => " + user);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(beanName);
        System.out.println(beanFactory.getBean(beanName));
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
        this.beanFactory= beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory .... ");
    }

}
