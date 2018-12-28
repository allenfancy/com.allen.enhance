package org.com.allen.enhance.basic.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author allen.wu
 * @since 2018-07-25 14:01
 */
public class LongEventMain {

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();

        int bufferSize = 1024;

        Disruptor disruptor = new Disruptor( factory, bufferSize, executor);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++)
        {
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(1000);
        }
    }
}
