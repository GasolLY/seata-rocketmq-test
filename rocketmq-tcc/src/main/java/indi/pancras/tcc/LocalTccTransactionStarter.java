package indi.pancras.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import indi.pancras.tcc.service.TccTransactionService;

@SpringBootApplication
public class LocalTccTransactionStarter {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(LocalTccTransactionStarter.class, args);

        TccTransactionService service = (TccTransactionService) applicationContext.getBean("tccTransactionService");

        // rocketmq send success
        doGlobalTransaction(service, true, true);
        // rocketmq send fail
        doGlobalTransaction(service, false, false);
        // rocketmq send fail
        doGlobalTransaction(service, true, false);
        // rocketmq send fail
        doGlobalTransaction(service, false, true);
    }

    public static void doGlobalTransaction(TccTransactionService service, boolean tccOneSuccess, boolean tccTwoSuccess) throws InterruptedException {
        try {
            service.doGlobalTransaction(tccOneSuccess, tccTwoSuccess);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(1000);
    }
}
