package exercise13.q1;

import java.util.concurrent.LinkedBlockingQueue;

public class AlarmClock{

    private volatile boolean isTime = false;

    public AlarmClock(String message, int time, LinkedBlockingQueue<String> queue){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(time);
                    queue.put(message);
                    isTime = true;

                }catch (InterruptedException e){}

            }
        }).start();
    }

    public AlarmClock(String message, int time, LinkedBlockingQueue<String> queue, Object monitor){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            synchronized (monitor){
                                monitor.wait(time);
                                queue.put(message);
                                isTime = true;
                                monitor.notify();
                            }

                        }catch (InterruptedException e){}
                    }
                }
        ).start();
    }

    public boolean isTime(){return this.isTime;}

}
