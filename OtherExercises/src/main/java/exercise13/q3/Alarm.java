package exercise13.q3;

import java.util.concurrent.BlockingQueue;

public class Alarm {
    BlockingQueue<String> queue;
    private boolean finished = false;
    private final String name;
    private Thread thread;
    public Alarm(String name, long time, String message, BlockingQueue<String> queue){
        this.queue = queue;
        this.name = name;
        this.thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try{
                            synchronized (this) {
                                this.wait(time);
                                setHasRanged();
                                setMessage(message);
                            }
                        }catch (InterruptedException ignored){}
                    }
                }
        );
        thread.start();
    }

    public void setHasRanged() {
        this.finished = true;
    }

    private void setMessage(String message) {
        try{
            queue.put(message);
        }catch (InterruptedException ignored){}
    }

    public void delete(){
        thread.interrupt();
    }

    public boolean hasRanged(){
        return finished;
    }
}
