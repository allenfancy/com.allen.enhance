package org.com.allen.enhance.basic.test;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class UserInfo {

    private Integer total;
   
    @SerializedName(value="pageData")
    private List<UserInfoDetail> userInfoDetails;
    
    @Data
    class UserInfoDetail {
        private String telphone;
        private Integer mid;
    }
}


