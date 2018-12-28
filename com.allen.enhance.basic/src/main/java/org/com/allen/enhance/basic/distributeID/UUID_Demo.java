package org.com.allen.enhance.basic.distributeID;

import java.util.UUID;

/**
 * @author allen.wu
 * @since 2018-09-15 12:52
 * UUID 16个字节 16*8 = 128bit(位)
 */
public class UUID_Demo {

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }
}
