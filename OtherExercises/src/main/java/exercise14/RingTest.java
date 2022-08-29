package exercise14;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RingTest  {
    private Ring<String> ring;

    @Before
    public void setUp(){
        ring = new Ring<>();
    }

    @Test
    public void testAdd(){
        ring.add("item 1");
        assertEquals(1, ring.size());
        ring.add("item 2");
        assertEquals(2, ring.size());
        ring.add("item 3");
        assertEquals("item 1", ring.getCurrent());
        assertEquals("item 3", ring.getNext());
        assertEquals("item 2", ring.getNext());
    }

    @Test
    public void testRemove(){
        ring.add("item 1");
        ring.remove();
        assertEquals(0, ring.size());
        tryGetCurrentOverEmptyRing();
        ring.add("item 1");
        ring.add("item 2");
        ring.getNext();
        ring.add("item 3");
        ring.remove();
        assertEquals(2, ring.size());
        assertEquals("item 3", ring.getCurrent());
        assertEquals("item 1", ring.getPrevious());
        assertEquals("item 3", ring.getNext());
    }

    @Test
    public void testGetNext(){
        try{
            ring.getNext();
            fail("should've thrown exception");
        }catch (RuntimeException e){
            assertEquals(new InvalidOperationOverEmptyRingException().getMessage(), e.getMessage());
        }
        ring.add("item 1");
        assertEquals("item 1", ring.getNext());
        ring.add("item 2");
        assertEquals("item 2", ring.getNext());
        assertEquals("item 1", ring.getNext());
    }

    @Test
    public void testGetPrevious(){
        try{
            ring.getPrevious();
            fail("should've thrown exception");
        }catch (RuntimeException e){
            assertEquals(new InvalidOperationOverEmptyRingException().getMessage(), e.getMessage());
        }
        ring.add("item 1");
        assertEquals("item 1", ring.getPrevious());
        ring.add("item 2");
        assertEquals("item 2", ring.getPrevious());
        assertEquals("item 1", ring.getPrevious());
    }

    @Test
    public void testGetCurrent(){
        tryGetCurrentOverEmptyRing();
        ring.add("element 1");
        assertEquals("element 1", ring.getCurrent());
        ring.add("element 2");
        assertEquals("element 1", ring.getCurrent());
        ring.getNext();
        assertEquals("element 2", ring.getCurrent());
    }

    private void tryGetCurrentOverEmptyRing(){
        try{
            ring.getCurrent();
            fail("should've thrown exception");
        }catch (RuntimeException e){
            assertEquals(new InvalidOperationOverEmptyRingException().getMessage(), e.getMessage());
        }
    }
}


