package otherexercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoopTest {

    @Test
    public void forLoopTest(){
        assertEquals(1, Loop.fatorialWithFor(0));
        assertEquals(1, Loop.fatorialWithFor(1));
        assertEquals(3628800, Loop.fatorialWithFor(10));
    }

    @Test
    public void whileLoopTest(){
        assertEquals(1, Loop.fatorialWithWhile(0));
        assertEquals(1, Loop.fatorialWithWhile(1));
        assertEquals(3628800, Loop.fatorialWithWhile(10));
    }

    @Test
    public void doWhileLoopTest(){
        assertEquals(1, Loop.fatorialWithDoWhile(0));
        assertEquals(1, Loop.fatorialWithDoWhile(1));
        assertEquals(3628800, Loop.fatorialWithDoWhile(10));
    }

    @Test
    public void loopWithBreakTest(){
        assertEquals(1, Loop.fatorialWithBreak(0));
        assertEquals(1, Loop.fatorialWithBreak(1));
        assertEquals(3628800, Loop.fatorialWithBreak(10));
    }

    @Test
    public void StringWithContinueTest(){
        assertEquals("1 2", Loop.stringWithContinue(2));
        assertEquals("1 2 3 4 5*", Loop.stringWithContinue(5));
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Loop.stringWithContinue(12));
    }

    @Test
    public void vectorOfStringTest(){
        assertEquals("[1, 2]", Loop.vectorOfString(2).toString());
        assertEquals("[1, 2, 3, 4, 5*]", Loop.vectorOfString(5).toString());
        assertEquals("[1, 2, 3, 4, 5*, 6, 7, 8, 9, 10*, 11, 12]", Loop.vectorOfString(12).toString());
    }

    @Test
    public void vectorOfVectorTest(){
        assertEquals("1 2", Loop.stringOfVector(2));
        assertEquals("1 2 3 4 5*", Loop.stringOfVector(5));
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Loop.stringOfVector(12));
    }

}
