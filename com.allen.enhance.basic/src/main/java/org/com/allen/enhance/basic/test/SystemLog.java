package org.com.allen.enhance.basic.test;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SystemLog {


    private Integer total;

    @SerializedName("pageData")
    private List<LoginInfo> logInfo;


    @Data
    static class LoginInfo {
        private Integer id;
        private Integer mid;
        private String ip;
        private String operator;
        private String message;
        private String timestamp;
    }
}
