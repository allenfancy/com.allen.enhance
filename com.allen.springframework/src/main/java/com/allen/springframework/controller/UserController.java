package com.allen.springframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allen.springframework.model.User;
import com.allen.springframework.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * uri 后面的参数
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public void addUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute User user) {
        userService.save(user);
        System.out.println("url?xx=11&yyy=333"+user);
    }
    
    /**
     * Content-Type: application/json
     * @RequestBody 只接受json格式的数据流
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value="/v/add",method= {RequestMethod.GET,RequestMethod.POST})
    public void addUserRequestBody(HttpServletRequest request,HttpServletResponse response,@RequestBody User user) {
        userService.save(user);
        System.out.println("@RequestBody json => "+user);
    }
    
    /**
     * Content-Type:application/x-www-form-urlencoded
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value="/v1/add",method= {RequestMethod.GET,RequestMethod.POST})
    public void addUserNothing(HttpServletRequest request,HttpServletResponse response,User user) {
        userService.save(user);
        System.out.println("application/x-www-form-urlencoded => "+user);
    }
    
    /**
     * Form Data
     * @param request
     * @param response
     * @param user
     */
    @RequestMapping(value="/v2/add",method= {RequestMethod.POST})
    public void addUserFormData(HttpServletRequest request,HttpServletResponse response, User user) {
        userService.save(user);
        System.out.println("form data => "+user);
    }
    
    
    @RequestMapping(value="/user/info",method= {RequestMethod.GET})
    public @ResponseBody Object getUserInfo(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "allen") String name ) {
          return name;
    }
}
