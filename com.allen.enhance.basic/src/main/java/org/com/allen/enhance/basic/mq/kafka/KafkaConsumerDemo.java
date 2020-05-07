package org.com.allen.enhance.basic.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.com.allen.enhance.basic.dubbo.Consumer;

import java.util.Properties;

/**
 * @author allen
 * @date 2020/4/17 2:25 上午
 **/
public class KafkaConsumerDemo {


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(init("127.0.0.1:9093,127.0.0.1:9094,127.0.0.1:9095", "test", false));
            ConsumerThread consumerThread = new ConsumerThread(consumer);
            Thread thread = new Thread(consumerThread);
            thread.start();
        }
    }

    private static Properties init(String cluster, String groupID, Boolean autoCommit) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, cluster);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupID);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
