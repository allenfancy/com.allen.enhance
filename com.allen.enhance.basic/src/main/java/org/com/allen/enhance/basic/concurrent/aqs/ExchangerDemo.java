package org.com.allen.enhance.basic.concurrent.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author allen.wu
 * @since 2018-08-16 16:09
 * 使用Exchanger来模拟生成者和消费者
 */
public class ExchangerDemo {

    /**
     * 生产者
     */
    static class Producer implements Runnable {

        private List<String> buffer;
        private Exchanger<List<String>> exchanger;

        Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {
                System.out.println("生产者第" + i + "次提供");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("生产者装入" + i + "--" + j);
                    buffer.add("buffer:" + i + "--" + j);
                }
                System.out.println("生产者装满了，等待与消费者消费者交换...");
                try {
                    exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private List<String> buffer;
        private Exchanger<List<String>> exchanger;

        Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消费者第" + i + "次提取");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("消费者 : " + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();
        Thread producerThread = new Thread(new Producer(buffer1, exchanger));
        Thread consumerThread = new Thread(new Consumer(buffer2, exchanger));
        producerThread.start();
        consumerThread.start();
    }
}
