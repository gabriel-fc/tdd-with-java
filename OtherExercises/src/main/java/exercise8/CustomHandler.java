package exercise8;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

class CustomHandler extends Handler {
    private HashMap<Level, Integer> count;
    private LogRecord record;
    public void flush() {}
    public void close() {}
    public void publish(LogRecord record) {
        this.record = record;
        incrementCount(record.getLevel());
        if(getFormatter() == null){
            logMessageIfHasNoFormatter();
        }
        else {
            record.setMessage(getFormatter().format(record));
        }
    }

    private void incrementCount(Level level){
        count.replace(level, count.get(level) + 1);
    }
    private String logMessageIfHasNoFormatter(){
        String msg = "\nNumber of logs for each level:\n";
        for (Map.Entry<Level, Integer> pair : count.entrySet()) {
            msg += pair.getKey() + ": " + pair.getValue() + "\n";
        }
        return msg;
    }

    public CustomHandler(){
        count = new HashMap<>(){{
            put(Level.SEVERE, 0);
            put(Level.WARNING, 0);
            put(Level.INFO, 0);
            put(Level.FINE, 0);
        }};
    }

    public int getCount(Level level){
        return count.get(level);
    }
}
