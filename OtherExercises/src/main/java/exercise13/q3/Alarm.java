package exercise13.q3;

import java.util.concurrent.BlockingQueue;

public class Alarm {
    BlockingQueue<String> queue;
    public Alarm(long time, String message, BlockingQueue<String> queue){
        this.queue = queue;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try{
                            synchronized (this) {
                                this.wait(time);
                                setMessage(message);
                            }
                        }catch (InterruptedException ignored){}
                    }
                }
        ).start();
    }

    private void setMessage(String message) {
        try{
            queue.put(message);
        }catch (InterruptedException ignored){}
    }
}
