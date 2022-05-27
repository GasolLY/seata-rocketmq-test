package indi.pancras.tcc;

import org.apache.rocketmq.client.exception.MQClientException;

import indi.pancras.tcc.consumer.Consumer;

public class ConsumerStarter {
    public static void main(String[] args) throws MQClientException {
        Consumer consumer = new Consumer();
        consumer.start();
    }
}
