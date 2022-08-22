package exercise13.q3;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmClockTest {
    @Test
    public void testAlarmClock()throws InterruptedException{
        Object monitor = new Object();
        AlarmClock alarmClock = new AlarmClock(monitor);
        assertTrue(alarmClock.setAlarm("a1", 2000, "first alarm"));
        assertTrue(alarmClock.setAlarm("a2", 4000, "second alarm"));
        assertFalse(alarmClock.setAlarm("a2", 4000, "shouldn't be set "));
        long start = System.currentTimeMillis();
        synchronized (monitor){
            monitor.wait();
            assertEquals(2000, System.currentTimeMillis() - start, 2);
            assertEquals("first alarm", alarmClock.getMessage());
            monitor.wait();
            assertEquals(4000, System.currentTimeMillis() - start, 2);
            assertEquals("second alarm", alarmClock.getMessage());
            assertTrue(alarmClock.setAlarm("a2", 1000, "third alarm"));
            start = System.currentTimeMillis();
            monitor.wait();
            assertEquals(1000, System.currentTimeMillis() - start, 2);
            assertEquals("third alarm", alarmClock.getMessage());
        }
        alarmClock.turnOf();
    }

    @Test
    public void testRemoveAlarm() throws InterruptedException{
        Object monitor = new Object();
        AlarmClock alarmClock = new AlarmClock(monitor);
        alarmClock.setAlarm("alarm", 1000, "this alarm will be cancelled");
        assertFalse(alarmClock.removeAlarm("alarme"));
        assertTrue(alarmClock.removeAlarm("alarm"));
        Thread.sleep(1000);
        assertEquals(null, alarmClock.getMessage());
        
    }
}
