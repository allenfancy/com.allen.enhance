package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:21
 */
public interface IRetry<K,V> {

    void retry( K k,V v);
}
