package org.com.allen.enhance.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author allen.wu
 * @since 2018-09-03 21:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private String className;
}
