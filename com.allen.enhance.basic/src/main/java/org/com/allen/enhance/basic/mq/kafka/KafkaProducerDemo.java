package org.com.allen.enhance.basic.mq.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author allen
 * @date 2020/4/17 2:25 上午
 **/
public class KafkaProducerDemo {
    private final Producer<String, String> kafkaProducer;

    private KafkaProducerDemo() {
        kafkaProducer = createKafkaProducer();
    }

    private Producer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9093,127.0.0.1:9094,127.0.0.1:9095");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer(props);
        return kafkaProducer;
    }

    void produce() {
        for (int i = 100000; i < 1000000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String key = "key - " + Constants.TOPIC + i;
            String data = "hello kafka message:" + key;
            kafkaProducer.send(new ProducerRecord<>(Constants.TOPIC, key, data), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //do sth
                }
            });
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        new KafkaProducerDemo().produce();
    }
}
