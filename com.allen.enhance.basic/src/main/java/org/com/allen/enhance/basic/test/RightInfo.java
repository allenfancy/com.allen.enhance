package org.com.allen.enhance.basic.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RightInfo {

    private Integer mid;
    private String tel;
    private String email;
    private String message;
}
