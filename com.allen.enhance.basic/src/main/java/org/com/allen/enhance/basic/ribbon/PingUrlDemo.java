package org.com.allen.enhance.basic.ribbon;

import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

/**
 * @author allen.wu
 * @since 2018-06-26 15:34
 */
public class PingUrlDemo {

    public static void main(String[] args) {

        PingUrl p = new PingUrl();
        p.setExpectedContent("true");
        Server s = new Server("www.baidu.com");
        boolean isAlive = p.isAlive(s);
        System.out.println("isAlive:" + isAlive);
    }
}
