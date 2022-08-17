package exercise13.q3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlarmTest {
    @Test
    public void testAlarm()throws InterruptedException{
        Object monitor = new Object();
        long time = 2000;
        String expectedMessage = "alarm message";
        Alarm alarm = new Alarm(time, expectedMessage, monitor);
        long start = System.currentTimeMillis();
        synchronized (monitor){
            assertEquals(null, alarm.getMessage());
            monitor.wait();
            assertEquals(time, System.currentTimeMillis() - start);
            assertEquals(expectedMessage, alarm.getMessage());
        }
    }
}
