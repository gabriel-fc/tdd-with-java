package exercise8;


import util.StringUtil;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
    private CustomHandler countingLogHandler;
    public LogFormatter(CustomHandler countingLogHandler){
        super();
        this.countingLogHandler = countingLogHandler;
    }
    public LogFormatter(){}


    @Override
    public String format(LogRecord record) {
        String msg =  record.getMessage();
        if (countingLogHandler == null){
            msg += StringUtil.NEWLINE;
            return msg.toString();
        }
        msg += " " + "(" + record.getLevel() + " total = " +
                countingLogHandler.getCount(record.getLevel()) + ")" + StringUtil.NEWLINE;
        return msg;
    }
}
