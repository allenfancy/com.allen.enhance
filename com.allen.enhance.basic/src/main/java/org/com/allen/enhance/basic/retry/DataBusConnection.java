package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:12
 */
public interface DataBusConnection<K,V> {

    void set(K k, V v) throws Exception;
}
