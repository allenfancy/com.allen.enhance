package org.com.allen.enhance.undertow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest() {
        return "vim test";
    }
}
