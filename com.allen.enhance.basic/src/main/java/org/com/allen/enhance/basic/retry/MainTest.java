package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:37
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        AbstractDataBusConnection loginLogDataBusConnection = new LoginLogDataBusConnection();
        loginLogDataBusConnection.setJedisPool("login log ");
        AbstractDataBusPubRetry<String,String> defaultDataBusPubRetry = new DefaultDataBusPubRetry<>();
        defaultDataBusPubRetry.setDataBusConnection(loginLogDataBusConnection);
        AbstractDataBusPubDao<String,String> loginLogDataBusPubDao = new LoginLogDataBusPubDao();
        loginLogDataBusPubDao.setConnection(loginLogDataBusConnection);
        loginLogDataBusPubDao.setRetry(defaultDataBusPubRetry);
        loginLogDataBusPubDao.save("ll","allen");
    }
}
