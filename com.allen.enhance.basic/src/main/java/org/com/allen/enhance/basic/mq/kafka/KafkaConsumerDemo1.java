package org.com.allen.enhance.basic.mq.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

/**
 * @author allen
 * @date 2020/4/17 2:25 上午
 **/
public class KafkaConsumerDemo1 {


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(init("127.0.0.1:9093,127.0.0.1:9094,127.0.0.1:9095", "test-1", false));
            ConsumerThread consumerThread = new ConsumerThread(consumer);
            Thread thread = new Thread(consumerThread);
            thread.start();
        }
    }

    private static Properties init(String cluster, String groupID, Boolean autoCommit) {
        Properties props = new Properties();
        props.put("bootstrap.servers", cluster);
        props.put("group.id", groupID);
        props.put("enable.auto.commit", autoCommit);
        props.put("auto.commit.interval.ms", "1000");
        props.put("max.poll.interval.ms", "2000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
