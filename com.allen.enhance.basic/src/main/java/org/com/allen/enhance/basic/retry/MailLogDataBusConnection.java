package org.com.allen.enhance.basic.retry;

/**
 * @author allen.wu
 * @since 2018-06-15 01:38
 */
public class MailLogDataBusConnection extends AbstractDataBusConnection<String, String> {

    @Override
    public void setJedisPool(String jedisPool) {
        super.setJedisPool(jedisPool);
    }
}
