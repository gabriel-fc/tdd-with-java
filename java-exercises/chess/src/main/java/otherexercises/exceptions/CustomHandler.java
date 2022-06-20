package otherexercises.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

class CustomHandler extends Handler {
    private static HashMap<Level, Integer> count;
    private LogRecord record;
    public void flush() {}
    public void close() {}
    public void publish(LogRecord record) {
        this.record = record;
        count.replace(record.getLevel(), count.get(record.getLevel()) + 1);

        if(getFormatter() == null){
            String msg = "\nNumber of logs for each level:\n";
            for (Map.Entry<Level, Integer> pair : count.entrySet()) {
                msg += pair.getKey() + ": " + pair.getValue() + "\n";
            }
        }
        else {
            record.setMessage(getFormatter().format(record));
        }
    }

    public CustomHandler(){
        if (count == null){
            count = new HashMap<>();
            count.put(Level.SEVERE, 0);
            count.put(Level.WARNING, 0);
            count.put(Level.INFO, 0);
            count.put(Level.FINE, 0);
        }
    }

    public int getCount(Level level){
        return count.get(level);
    }
}
