package indi.pancras.tcc.action.impl;

import indi.pancras.tcc.action.TccActionTwo;
import io.seata.rm.tcc.api.BusinessActionContext;

import org.springframework.stereotype.Component;

@Component("tccActionTwo")
public class TccActionTwoImpl implements TccActionTwo {
    boolean flag = true;

    @Override
    public boolean prepare(BusinessActionContext actionContext, boolean success) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo prepare, xid:" + xid);
        return success;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo commit, xid:" + xid);
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        String xid = actionContext.getXid();
        System.out.println("TccActionTwo rollback, xid:" + xid);
        return true;
    }

}
