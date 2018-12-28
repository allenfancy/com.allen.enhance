package org.com.allen.enhance.basic.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @author allen.wu
 * @since 2018-07-25 13:58
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event: " + longEvent);
    }
}
