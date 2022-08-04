package sis.studentinfo;
import junit.framework.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MultithreadedAccountTest {
    private Account account;
    private Thread makeThread(){
        return new Thread(new Runnable() {
            public void run() {
                account.withdraw(new BigDecimal("80.00"));
            }});
    }

    @Before
    public void setUp(){
        account = new Account();
    }

    @Test
    public void testConcurrency() throws Exception {
        account.credit(new BigDecimal("100.00"));
        Thread t1 = makeThread();
        Thread t2 = makeThread();
        t1.start();
        t1.join();
        t2.start();
        assertEquals(new BigDecimal("20.00"), account.getBalance());
    }
}