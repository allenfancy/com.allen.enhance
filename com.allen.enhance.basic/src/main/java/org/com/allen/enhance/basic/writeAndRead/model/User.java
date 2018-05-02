package org.com.allen.enhance.basic.writeAndRead.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Integer id;
    private String name;
}
