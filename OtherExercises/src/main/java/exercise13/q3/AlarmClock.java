package exercise13.q3;

import java.util.concurrent.LinkedBlockingQueue;

public class AlarmClock {
    private LinkedBlockingQueue<Alarm> queue;
    private Object monitor;

    public AlarmClock(){
        this.queue = new LinkedBlockingQueue<>();
        this.monitor = new Object();
    }

    public void setAlarm(long time, String message){
        try{
            queue.put(new Alarm(time, message, monitor));
        }catch (InterruptedException ignored){}
    }
}
