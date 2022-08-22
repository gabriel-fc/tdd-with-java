package exercise13.q3;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

public class AlarmTest {
    @Test
    public void testAlarm()throws InterruptedException{
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new Alarm(2000, "first alarm", queue);
        long startA1 = System.currentTimeMillis();
        new Alarm(2000, "second alarm", queue);
        long startA2 = System.currentTimeMillis();
        new Alarm(3000, "third alarm", queue);
        long startA3 = System.currentTimeMillis();
        verifyAlarm(2000, startA1, "first alarm", queue);
        verifyAlarm(2000, startA2, "second alarm", queue);
        verifyAlarm(3000, startA3, "third alarm", queue);
        }

        public void verifyAlarm(long time, long start, String expectedMessage, BlockingQueue<String> queue) throws InterruptedException{
            String actualMessage = queue.take();
            assertEquals(time,System.currentTimeMillis() - start, 2);
            assertEquals(expectedMessage, actualMessage);
        }
}
