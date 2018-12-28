package org.com.allen.enhance.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author allen.wu
 * @since 2018-09-03 21:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Class {

    private int classId;
    private String className;
}
