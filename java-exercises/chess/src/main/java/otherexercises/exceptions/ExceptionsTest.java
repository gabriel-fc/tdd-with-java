package otherexercises.exceptions;

import chess.game.Game;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

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
            //traceInReverse(expectedException.getStackTrace());
            expectedException.setStackTrace(traceInReverse(expectedException.getStackTrace()));
            expectedException.printStackTrace();
        }
    }

    @Test
    public void testCustomHandler(){
        Logger logger = Logger.getLogger(Exceptions.class.getName());
        Handler handler = new CustomHandler();
        logger.addHandler(handler);
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
            LogRecord record = new LogRecord(level, "this message will be overridden");
            logger.log(record);
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
