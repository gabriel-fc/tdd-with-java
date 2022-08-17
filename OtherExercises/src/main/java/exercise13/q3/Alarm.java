package exercise13.q3;

public class Alarm {
    private String message = null;
    public Alarm(long time, String message, Object monitor){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (monitor){
                            try{
                                monitor.wait(time);
                                setMessage(message);
                                monitor.notify();
                            }catch (InterruptedException ignored){}
                        }
                    }
                }
        ).start();
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
