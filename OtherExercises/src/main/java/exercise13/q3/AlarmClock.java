package exercise13.q3;

import java.util.concurrent.LinkedBlockingQueue;

public class AlarmClock {
    private LinkedBlockingQueue<String> queue;
    private volatile boolean running;
    private volatile String message;

    public AlarmClock(Object monitor){
        this.queue = new LinkedBlockingQueue<>();
        this.running = true;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(running){
                            try{
                                setMessage(queue.take());
                                synchronized (monitor) {
                                    monitor.notify();
                                }
                            }catch (InterruptedException ignored){}
                        }
                    }
                }
        ).start();
    }

    public void setAlarm(long time, String message){
        new Alarm(time, message, queue);
    }

    public void turnOf(){
        this.running = false;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
