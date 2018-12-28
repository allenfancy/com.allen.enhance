package org.com.allen.enhance.basic.desginpattern.adapter.basic;

/**
 * @author allen.wu
 * @since 2018-09-14 10:37
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("名字是XXX");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("员工家的地址");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("员工的手机号");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("员工的工作电话");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("BOSS");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("员工的家里的电话");
        return null;
    }
}
