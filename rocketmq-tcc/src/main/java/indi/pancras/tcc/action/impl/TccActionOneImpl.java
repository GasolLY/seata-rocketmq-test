package indi.pancras.tcc.action.impl;

import indi.pancras.tcc.action.TccActionOne;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.seata.rm.tcc.api.BusinessActionContext;

@Component("tccActionOne")
public class TccActionOneImpl implements TccActionOne {
    @Autowired
    private MQProducer producer;

    boolean flag = true;
    @Override
    public boolean prepare(BusinessActionContext actionContext, boolean success) {
        String xid = actionContext.getXid();
        System.out.println("TccActionOne prepare, xid:" + xid);
        try {
            producer.send(new Message("test", "helloworld".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionOne commit, xid:" + xid);
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionOne rollback, xid:" + xid);
        return true;
    }
}
