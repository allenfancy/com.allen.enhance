package com.allen.springframework.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author allen.wu
 * @since 2018-12-15 23:36
 */
@Controller
@RequestMapping(value = "/web/cookie")
public class CookieController {

    @ResponseBody
    @RequestMapping(value = "/set-cookie")
    public Object setCookie(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String value = URLEncoder.encode("allen.wu", "UTF-8");
        Cookie cookie = new Cookie("test", value);
        cookie.setPath("/");
        cookie.setDomain("");
        cookie.setMaxAge(10000);
        response.setHeader("P3P:CP", "IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT");
        response.addCookie(cookie);
        return "setCookie";
    }

    @ResponseBody
    @RequestMapping(value = "/get-cookie")
    public Object getCookie(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String cookie = request.getHeader("Cookie");
        System.out.println(cookie);
        System.out.println(request.getHeader("Origin"));
        System.out.println(request.getHeader("Referer"));
        return cookie;
    }

    @ResponseBody
    @RequestMapping(value = "/crossDomain")
    public Object crossDomain(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String value = URLEncoder.encode("allen.wu", "UTF-8");
        Cookie cookie = new Cookie("test", value);
        cookie.setPath("/");
        cookie.setDomain("komoejoy.com");
        cookie.setMaxAge(10000);
        response.setHeader("P3P:CP", "IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT");
        response.addCookie(cookie);
        String cookies = request.getHeader("Cookie");
        return cookies;
    }

}
