package exercise13.q1;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class AlarmClockTest {
    @Test
    public void alarmClockTest(){
        String msg = "this alarm should've rang 5 seconds after being set";
        int time = 5000;
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        AlarmClock alarm = new AlarmClock(msg, time, queue);
        assertFalse(alarm.isTime());
        try {
            Thread.sleep(5010);
            assertTrue(alarm.isTime());
            assertEquals(msg, queue.take());
        }catch (InterruptedException e){}

    }
}
