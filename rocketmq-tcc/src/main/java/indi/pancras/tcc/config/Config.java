package indi.pancras.tcc.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.rm.tcc.rocketmq.RocketMQAop;
import io.seata.rm.tcc.rocketmq.TCCRocketMQ;
import io.seata.rm.tcc.rocketmq.TCCRocketMQImpl;
import io.seata.spring.annotation.GlobalTransactionScanner;

@Configuration
public class Config {
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("tcc-demo-scanner", "my_test_tx_group");
    }

    @Bean
    public DefaultMQProducer defaultMQProducer() {
        DefaultMQProducer producer = new DefaultMQProducer("tcc_rocketmq_producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }

    @Bean
    public RocketMQAop rocketMQAop(){
        return new RocketMQAop();
    }

    @Bean
    public TCCRocketMQ tccRocketMQ(){
        return new TCCRocketMQImpl();
    }
}
