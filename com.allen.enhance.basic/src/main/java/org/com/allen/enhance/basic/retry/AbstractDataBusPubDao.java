package org.com.allen.enhance.basic.retry;

import com.google.gson.Gson;

/**
 * @author allen.wu
 * @since 2018-06-15 01:10
 */
public abstract class AbstractDataBusPubDao<K, V> implements DataBusPubDao<K, V> {

    private Gson gson = new Gson();

    private DataBusConnection connection;
    
    private IRetry retry ;

    @Override
    public void save(K k, V v) throws Exception {
        String value = gson.toJson(v);
        try {
            connection.set(k, value);
        } catch (Exception e) {
            retry.retry(k, v);
        }
    }

    public void setRetry(IRetry retry) {
        this.retry = retry;
    }

    public IRetry getRetry() {
        return retry;
    }

    public DataBusConnection getConnection() {
        return connection;
    }

    public void setConnection(DataBusConnection connection) {
        this.connection = connection;
    }
}
