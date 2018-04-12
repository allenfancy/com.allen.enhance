package org.com.allen.enhance.springboot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Info {

    private String name;
    private int age;
    private String version;
}
