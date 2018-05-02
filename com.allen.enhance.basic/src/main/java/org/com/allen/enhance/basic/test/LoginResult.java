package org.com.allen.enhance.basic.test;

import lombok.Data;

@Data
public class LoginResult {
    private Long ts;
    private Integer mid;
    private String access_key;
    private Long expires;
    private Integer code;
}
