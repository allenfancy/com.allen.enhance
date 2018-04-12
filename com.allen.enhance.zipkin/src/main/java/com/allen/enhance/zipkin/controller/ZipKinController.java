package com.allen.enhance.zipkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/zipkin")
public class ZipKinController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public Object zipKinDemo1() {
        return restTemplate.getForObject("http://www.baidu.com", String.class);
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.GET)
    public Object zipKinDemo2() {
        return restTemplate.getForObject("http://www.baidu.com", String.class);
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.GET)
    public Object zipKinDemo3() {
        return restTemplate.getForObject("http://www.baidu.com", String.class);
    }

    @RequestMapping(value = "/demo4", method = RequestMethod.GET)
    public Object zipKinDemo4() {
        return restTemplate.getForObject("http://www.baidu.com", String.class);
    }
}
