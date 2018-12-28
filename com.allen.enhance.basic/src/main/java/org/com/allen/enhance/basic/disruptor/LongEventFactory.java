package org.com.allen.enhance.basic.disruptor;


import com.lmax.disruptor.EventFactory;

/**
 * @author allen.wu
 * @since 2018-07-25 13:57
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
