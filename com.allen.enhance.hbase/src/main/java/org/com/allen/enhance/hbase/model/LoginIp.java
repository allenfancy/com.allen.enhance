package org.com.allen.enhance.hbase.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginIp {

    private Integer mid;
    private Long loginIp;
    private Long timestamp;
    private Integer type;
    private Integer server;
}
