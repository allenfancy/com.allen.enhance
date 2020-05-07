package org.com.allen.enhance.basic.mq.kafka;

import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author allen
 * @date 2020/4/18 12:16 上午
 **/
public class ConsumerThread implements Runnable {

    private KafkaConsumer<String, String> kafkaConsumer;

    public ConsumerThread(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @SneakyThrows
    @Override
    public void run() {
        kafkaConsumer.subscribe(Arrays.asList(Constants.TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf(Thread.currentThread().getName() + "offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
            TimeUnit.SECONDS.sleep(3);
            kafkaConsumer.commitAsync();
        }
    }
}
