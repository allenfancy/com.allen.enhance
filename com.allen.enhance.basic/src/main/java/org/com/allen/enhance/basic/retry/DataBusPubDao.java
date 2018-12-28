package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:09
 */
public interface DataBusPubDao<K, V> {

    void save(K k, V v) throws Exception;
}
