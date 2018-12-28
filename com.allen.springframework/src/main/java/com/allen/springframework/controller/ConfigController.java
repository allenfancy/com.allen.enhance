package com.allen.springframework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

/**
 * @author allen.wu
 * @since 2018-12-06 18:03
 */
@Controller
@RequestMapping(value = "config")
public class ConfigController {

    @Value("${useLocalCache:false}")
    @Setter
    private boolean useLocalCache;

    @Value("${userName:allen.wu}")
    @Setter
    private String userName;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return useLocalCache + " userName = " + userName;
    }
}

