package exercise13.q3;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlarmClockTest {
    @Test
    public void testAlarmClock()throws InterruptedException{
        Object monitor = new Object();
        AlarmClock alarmClock = new AlarmClock(monitor);
        alarmClock.setAlarm(2000, "first alarm");
        alarmClock.setAlarm(4000, "secondAlarm");
        long start = System.currentTimeMillis();
        synchronized (monitor){
            monitor.wait();
            assertEquals(2000, System.currentTimeMillis() - start, 2);
            assertEquals("first alarm", alarmClock.getMessage());
            monitor.wait();
            assertEquals(4000, System.currentTimeMillis() - start, 2);
        }
        alarmClock.turnOf();
    }
}
