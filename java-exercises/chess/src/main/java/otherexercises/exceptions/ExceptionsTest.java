package otherexercises.exceptions;

import chess.game.Game;
import org.junit.Test;
import util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExceptionsTest {
    @Test
    public void blowsUpTest(){
        try{
            blowsUp();
            fail("Should've thrown an exception");
        }catch (SimpleException expectedError){
            assertEquals("Somebody should catch this!!!", expectedError.getMessage());
        }

    }

    @Test
    public void rethrowsTest(){
        try{
            rethrows();
            fail("Should've thrown an exception");
        }catch (RuntimeException expectedError){
            assertEquals("Somebody should catch this!!!", expectedError.getCause().getMessage());
        }
    }

    private void rethrows(){
        try{
            blowsUp();
        }catch (RuntimeException e){
            RuntimeException newException = new RuntimeException(e);
            throw newException;
        }
    }

    public void blowsUp() {
        throw new SimpleException("Somebody should catch this!!!");
    }

    public void testWithProblems() {
        try {
            doSomething();
            fail("no exception");
        }
        catch (Exception success) {}
    }


    @Test
    public void testReverseTrace(){
        try{
            throw new RuntimeException();
        }catch (RuntimeException expectedException){
            expectedException.setStackTrace(traceInReverse(expectedException.getStackTrace()));
            expectedException.printStackTrace();
        }
    }


    @Test
    public void testFormatterWithCountingHandler(){
        Logger logger = Logger.getLogger(Exceptions.class.getName());
        CustomHandler handler = new CustomHandler();
        Formatter logFormatter = new LogFormatter(handler);
        handler.setFormatter(logFormatter);
        logger.addHandler(handler);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out (SEVERE total = 1)" + StringUtil.NEWLINE);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out (SEVERE total = 2)" + StringUtil.NEWLINE);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out (SEVERE total = 3)" + StringUtil.NEWLINE);
        testExceptionMessage(Level.WARNING, logger,
                "watch out (WARNING total = 1)" + StringUtil.NEWLINE);
        testExceptionMessage(Level.FINE, logger,
                "watch out (FINE total = 1)" + StringUtil.NEWLINE);
        testExceptionMessage(Level.INFO, logger,
                "watch out (INFO total = 1)" + StringUtil.NEWLINE);
    }

    @Test
    public void testFormatterWithoutCountingHandler(){
        Logger logger = Logger.getLogger(Exceptions.class.getName());
        CustomHandler handler = new CustomHandler();
        Formatter logFormatter = new LogFormatter();
        handler.setFormatter(logFormatter);
        logger.addHandler(handler);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out" + StringUtil.NEWLINE);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out" + StringUtil.NEWLINE);
        testExceptionMessage(Level.SEVERE, logger,
                "watch out" + StringUtil.NEWLINE);
        testExceptionMessage(Level.WARNING, logger,
                "watch out" + StringUtil.NEWLINE);
        testExceptionMessage(Level.FINE, logger,
                "watch out" + StringUtil.NEWLINE);
        testExceptionMessage(Level.INFO, logger,
                "watch out" + StringUtil.NEWLINE);
    }
    @Test
    public void testCustomHandler(){
        Logger logger = Logger.getLogger(Exceptions.class.getName());
        CustomHandler handler = new CustomHandler();
        logger.addHandler(handler);
        throwException(Level.SEVERE, logger);
        throwException(Level.SEVERE, logger);
        throwException(Level.WARNING, logger);
        throwException(Level.INFO, logger);
        throwException(Level.FINE, logger);
        throwException(Level.SEVERE, logger);
    }

    private void throwException(Level level, Logger logger){
        try {
            throw new RuntimeException();
        }catch (RuntimeException expectedException){
            LogRecord record = new LogRecord(level, "watch out");
            logger.log(record);
        }
    }

    private void testExceptionMessage(Level level, Logger logger, String expectedMessage){
        try{
            throw new Exception();
            //fail("should've thrown exception");
        }catch (Exception e){
            LogRecord record = new LogRecord(level, "watch out");
            logger.log(record);
            assertEquals(expectedMessage, record.getMessage());
        }
    }

    void doSomething() throws Exception{
        throw new Exception("blah");
    }

    public StackTraceElement[] traceInReverse(StackTraceElement[] stack){
        Collections.reverse(Arrays.asList(stack));
        return stack;
    }



}
