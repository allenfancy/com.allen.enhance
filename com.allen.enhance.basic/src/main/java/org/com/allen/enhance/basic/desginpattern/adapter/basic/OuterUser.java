package org.com.allen.enhance.basic.desginpattern.adapter.basic;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author allen.wu
 * @since 2018-09-14 10:40
 */
public class OuterUser implements IOuterUser {

    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = Maps.newHashMap();
        baseInfoMap.put("userName", "员工叫做allen");
        baseInfoMap.put("mobileNumber", "电话是....");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap userOfficeInfoMap = Maps.newHashMap();
        userOfficeInfoMap.put("jobPosition", "这个人的职位是经理....");
        userOfficeInfoMap.put("officeTelNumber", "办公室电话为....");
        return userOfficeInfoMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap userHomeInfoMap = Maps.newHashMap();
        userHomeInfoMap.put("homeTelNumber", "该员工的家的电话是....");
        userHomeInfoMap.put("homeAddress", "该员工的家庭地址是。。。。");
        return userHomeInfoMap;
    }
}
