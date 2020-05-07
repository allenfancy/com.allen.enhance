package org.com.allen.enhance.basic.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author allen
 * @date 2020/4/20 12:04 下午
 **/
public class JmxDemo1 {

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("org.com.allen.enhance.basic.jmx:type=Hello");
        Hello mbean = new Hello();
        platformMBeanServer.registerMBean(mbean, objectName);
        System.out.println("waiting forever");
        TimeUnit.HOURS.sleep(1);
    }
}
