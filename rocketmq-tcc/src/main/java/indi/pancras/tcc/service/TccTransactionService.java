package indi.pancras.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import indi.pancras.tcc.action.TccActionOne;
import indi.pancras.tcc.action.TccActionTwo;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

@Service
public class TccTransactionService {
    @Autowired
    private TccActionOne tccActionOne;
    @Autowired
    private TccActionTwo tccActionTwo;

    @GlobalTransactional
    public String doGlobalTransaction(boolean tccOneSuccess, boolean tccTwoSuccess) {
        boolean result = tccActionOne.prepare(null, tccOneSuccess);
        if (!result) {
            throw new RuntimeException("TccActionOne commit 失败.");
        }
        result = tccActionTwo.prepare(null, tccTwoSuccess);
        if (!result) {
            throw new RuntimeException("TccActionTwo commit 失败.");
        }
        return RootContext.getXID();
    }
}
