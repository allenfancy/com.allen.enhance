package com.allen.enhance.swagger.controller.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allen.enhance.swagger.model.InfoRes;
import com.allen.enhance.swagger.model.UserInfo;
import com.allen.enhance.swagger.model.UserInfoRes;
import com.google.common.collect.Maps;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/api/user")
public class ApiController {

    private static final Map<String, UserInfo> infos = Maps.newConcurrentMap();

    @RequestMapping(value = "/save/info", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ApiOperation(value = "APP用户信息", httpMethod = "POST", response = UserInfoRes.class,
            notes = "APP第三方用户信息保存")
    public @ResponseBody Object postInfo(@RequestBody UserInfo userInfo) {
        if (!infos.containsKey(userInfo.getName())) {
            infos.put(userInfo.getName(), userInfo);
        }
        UserInfoRes res = new UserInfoRes();
        res.setCode(0);
        res.setUserInfo(userInfo);
        res.setMessage("保存成功");
        return res;
    }


    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "APP获取用户信息", httpMethod = "GET", response = InfoRes.class,
            notes = "APP根据用户名获取用户信息")
    public @ResponseBody Object getInfo(@ApiParam(required = true, name = "name",
            value = "用户名") @RequestParam(value = "name", required = true) String name) {
        UserInfo userInfo = null;
        if (infos.containsKey(name)) {
            userInfo = infos.get(name);
        }
        UserInfoRes res = new UserInfoRes();
        res.setCode(0);
        res.setUserInfo(userInfo);
        res.setMessage("查询成功");
        return res;
    }

    @RequestMapping(value = "/del/info", method = RequestMethod.DELETE)
    @ApiOperation(value = "APP获取用户信息", httpMethod = "DELETE", response = InfoRes.class,
            notes = "APP根据用户名获取用户信息")
    public @ResponseBody Object delUserInfo(@ApiParam(required = true, name = "name",
            value = "用户名") @RequestParam(value = "name", required = true) String name) {
        UserInfo userInfo = null;
        if (infos.containsKey(name)) {
            userInfo = infos.remove(name);
        }
        UserInfoRes res = new UserInfoRes();
        res.setCode(0);
        res.setUserInfo(userInfo);
        res.setMessage("移除成功");
        return res;
    }
}
