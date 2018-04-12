package org.com.allen.enhance.hbase.model;

import java.util.Comparator;

public class LoginIpComparator implements Comparator<LoginIp> {

    @Override
    public int compare(LoginIp o1, LoginIp o2) {
        if (o1.getTimestamp().compareTo(o2.getTimestamp()) > 0) {
            return -1;
        } else if (o1.getTimestamp().compareTo(o2.getTimestamp()) < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
