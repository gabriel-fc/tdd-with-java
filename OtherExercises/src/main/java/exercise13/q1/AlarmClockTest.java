package exercise13.q1;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class AlarmClockTest {
    private String msg;
    private int time;
    private Object monitor;
    private LinkedBlockingQueue queue;

    AlarmClock alarm;
    @Before
    public void setUp(){
        msg = "this alarm should've rang 5 seconds after being set";
        time = 5000;
        monitor = new Object();
        queue = new LinkedBlockingQueue<>();
    }

    @Test
    public void alarmClockTest(){
        alarm = new AlarmClock(msg, time, queue);
        long start = System.currentTimeMillis();
        try {
            while(System.currentTimeMillis() < start + time){
                verifyBeforeEndOfThread();
            }
            Thread.sleep(50);
            verifyAfterEndOfThread(start+50);

        }catch (InterruptedException e){}

    }

    @Test
    public void alarmClockTestForQ2(){
        alarm = new AlarmClock(msg, time, queue, monitor);
        long start= System.currentTimeMillis();
        try{
            synchronized (monitor){
                verifyBeforeEndOfThread();
                monitor.wait();
                verifyAfterEndOfThread(start);

            }

        }catch(InterruptedException e){}
    }


    private void verifyBeforeEndOfThread(){
        assertFalse(alarm.isTime());
        assertTrue(queue.isEmpty());
    }

    private void verifyAfterEndOfThread(long start){
        try{
            assertEquals(time, System.currentTimeMillis() - start);
            assertTrue(alarm.isTime());
            assertEquals(msg, queue.take());
        }catch (InterruptedException e){}

    }
}
