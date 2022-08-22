package exercise13.q3;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class AlarmClock {
    private LinkedBlockingQueue<String> queue;

    private HashMap<String, Alarm> alarms = new HashMap<>();
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

    public boolean setAlarm(String name, long time, String message){
        if (isNameAvailable(name)){
            alarms.put(name, new Alarm(name, time, message, queue));
            return true;
        }
        return false;
    }

    public boolean removeAlarm(String name){
        if (!isNameAvailable(name)){
            alarms.get(name).delete();
            alarms.remove(name);
            return true;
        }
        return false;
    }

    public void turnOf(){
        this.running = false;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private boolean isNameAvailable(String name){
        return !alarms.containsKey(name) || alarms.get(name).hasRanged();
    }
}
