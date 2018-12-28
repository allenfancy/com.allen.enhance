package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:49
 */
public abstract class AbstractDataBusPubRetry<K, V> implements IRetry<K, V> {

    private DataBusConnection dataBusConnection;

    @Override
    public void retry(K k, V v) {
        this.doRetry(k, v);
    }

    protected abstract void doRetry(K k, V v);

    public DataBusConnection getDataBusConnection() {
        return dataBusConnection;
    }

    public void setDataBusConnection(DataBusConnection dataBusConnection) {
        this.dataBusConnection = dataBusConnection;
    }
}
