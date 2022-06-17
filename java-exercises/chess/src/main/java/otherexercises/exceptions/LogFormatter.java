package otherexercises.exceptions;

import util.StringUtil;

import java.text.Format;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
    private CustomHandler countingLogHandler;
    public LogFormatter(CustomHandler countingLogHandler){
        this.countingLogHandler = countingLogHandler;
    }
    public LogFormatter(){}


    @Override
    public String format(LogRecord record) {
        String msg = record.getLevel().toString() + ": " + record.getMessage();

        if (countingLogHandler == null){
            msg += StringUtil.NEWLINE;
            return msg.toString();
        }
        msg += " " + "(" + record.getLevel() + " total = " +
                countingLogHandler.getCount(record.getLevel()) + ")" + StringUtil.NEWLINE;
        return msg;
    }
}
