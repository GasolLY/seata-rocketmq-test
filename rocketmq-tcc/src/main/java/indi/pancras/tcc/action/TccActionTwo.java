package indi.pancras.tcc.action;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface TccActionTwo {
    @TwoPhaseBusinessAction(name = "TccActionTwo")
    public boolean prepare(BusinessActionContext actionContext, boolean success);

    public boolean commit(BusinessActionContext actionContext);

    public boolean rollback(BusinessActionContext actionContext);
}
