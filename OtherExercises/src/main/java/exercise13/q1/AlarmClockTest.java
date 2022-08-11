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
        alarm = new AlarmClock(msg, time, queue, monitor);
    }

    @Test
    public void alarmClockTest(){
        long start = System.currentTimeMillis();
        try {
            while(System.currentTimeMillis() < start + time){
                assertFalse(alarm.isTime());
                assertTrue(queue.isEmpty());
            }
            Thread.sleep(5);
            assertTrue(alarm.isTime());
            assertEquals(msg, queue.take());

        }catch (InterruptedException e){}

    }

    @Test
    public void alarmClockTestForQ2(){

    }
}
