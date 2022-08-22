package exercise13.q3;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class AlarmTest {
    private BlockingQueue<String> queue;

    @Before
    public void setUp(){
        queue= new LinkedBlockingQueue<>();
    }

    @Test
    public void testAlarm()throws InterruptedException{
        Alarm a1 = new Alarm("a1", 2000, "first alarm", queue);
        long startA1 = System.currentTimeMillis();
        Alarm a2 = new Alarm("a2",2000, "second alarm", queue);
        long startA2 = System.currentTimeMillis();
        Alarm a3 = new Alarm("a3", 3000, "third alarm", queue);
        long startA3 = System.currentTimeMillis();
        verifyAlarm(a1, 2000, startA1, "first alarm");
        verifyAlarm(a2, 2000, startA2, "second alarm");
        verifyAlarm(a3, 3000, startA3, "third alarm");
        }

        public void verifyAlarm(Alarm alarm, long time, long start, String expectedMessage) throws InterruptedException{
            String actualMessage = queue.take();
            assertEquals(time,System.currentTimeMillis() - start, 2);
            assertEquals(expectedMessage, actualMessage);
            assertTrue(alarm.hasRanged());
        }
    @Test
    public void testDelete() throws InterruptedException{
        Alarm alarm = new Alarm("alarm", 1000, "this alarm will be deleted", queue);
        alarm.delete();
        Thread.sleep(1005);
        assertTrue(queue.isEmpty());
    }

}
