package org.com.allen.enhance.basic.test;

/**
 * @author allen.wu
 * @since 2020-03-04 10:37
 */
public class TestMain4 {

    public static void main(String[] args) {
        System.out.println(HttpClientUtils.post("http://127.0.0.1:8000/x/internal/account-recovery/send/mail", "3333", "111", "wutao@bilibili.com"));
    }
}
