package org.com.allen.enhance.basic.writeAndRead.plan3;

import java.sql.Connection;

public interface ConnectionProxy extends Connection {

    Connection getTargetConnection(String key);
}
