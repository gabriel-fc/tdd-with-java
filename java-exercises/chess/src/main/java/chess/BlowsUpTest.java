package chess;

import chess.game.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BlowsUpTest {
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
        throw new RuntimeException("Somebody should catch this!!!");
    }

    public void testWithProblems() {
        try {
            doSomething();
            fail("no exception");
        }
        catch (Exception success) {}
    }
    void doSomething() throws Exception{
        throw new Exception("blah");
    }

}
