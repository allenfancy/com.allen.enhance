package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:40
 */
public class LoginLogDataBusPubDao extends AbstractDataBusPubDao<String, String> {

    @Override
    public void setConnection(DataBusConnection connection) {
        super.setConnection(connection);
    }
}
