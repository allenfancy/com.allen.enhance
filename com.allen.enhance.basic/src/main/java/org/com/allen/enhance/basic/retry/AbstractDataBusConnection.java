package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:12
 */
public abstract class AbstractDataBusConnection<K, V> implements DataBusConnection<K, V> {


    private String jedisPool;

    @Override
    public void set(K k, V v) throws Exception {
        System.out.println(jedisPool + " " + k + " " + v);
        throw new RuntimeException();
    }

    public void setJedisPool(String jedisPool) {
        this.jedisPool = jedisPool;
    }

    public String getJedisPool() {
        return jedisPool;
    }
}
