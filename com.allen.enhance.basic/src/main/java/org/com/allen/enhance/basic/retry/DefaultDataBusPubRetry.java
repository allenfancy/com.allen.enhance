package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:25
 */
public class DefaultDataBusPubRetry<K, V> extends AbstractDataBusPubRetry<K, V> {

    private int cur = 1;
    private int retry = 3;

    @Override
    public void doRetry(K k, V v) {
        for (; cur <= retry; ++cur) {
            try {
                System.out.println("重试次数 : " + cur);
                getDataBusConnection().set(k, v);
                if (cur != retry) {
                    break;
                }
            } catch (Exception e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    @Override
    public void setDataBusConnection(DataBusConnection dataBusConnection) {
        super.setDataBusConnection(dataBusConnection);
    }
}
