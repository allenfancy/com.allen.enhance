package org.com.allen.enhance.basic.desginpattern.flyweight.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author allen.wu
 * @since 2018-09-14 01:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInfo {

    private String id;
    private String location;
    private String subject;
    private String postAddress;
}
