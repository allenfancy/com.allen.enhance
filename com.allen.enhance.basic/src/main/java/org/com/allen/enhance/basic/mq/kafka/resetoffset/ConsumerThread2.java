package org.com.allen.enhance.basic.mq.kafka.resetoffset;

import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.com.allen.enhance.basic.mq.kafka.Constants;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author allen
 * @date 2020/4/22 12:38 上午
 **/
public class ConsumerThread2 implements Runnable {

    private KafkaConsumer<String, String> kafkaConsumer;

    public ConsumerThread2(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @Override
    public void run() {
        kafkaConsumer.subscribe(Collections.singleton(Constants.TOPIC));
        ConsumerRecords<String, String> records = kafkaConsumer.poll(0);
        kafkaConsumer.seekToBeginning(
                kafkaConsumer.partitionsFor(Constants.TOPIC).
                        stream().map(partitionInfo -> new TopicPartition(Constants.TOPIC, partitionInfo.partition()))
                        .collect(Collectors.toList()));
        for (ConsumerRecord<String, String> record : records) {
            System.out.printf(Thread.currentThread().getName() + "offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
        kafkaConsumer.commitAsync();
    }
}
