package sis.search;

import java.util.concurrent.*;
public class Server extends Thread {

    private BlockingQueue<Search> queue =
            new LinkedBlockingQueue<Search>();
    private ResultsListener listener;
    public Server(ResultsListener listener) {
        this.listener = listener;
        start();

    }
    public void run() {
        while (true)
            try {
                execute(queue.take());
            }
            catch (InterruptedException e) {
                break;
            }
    }
    public void add(Search search) throws Exception {
        queue.put(search);
    }
    private void execute(Search search) {
        search.execute();
        listener.executed(search);
    }
    public void shutDown() throws Exception {
        this.interrupt();
    }
}
