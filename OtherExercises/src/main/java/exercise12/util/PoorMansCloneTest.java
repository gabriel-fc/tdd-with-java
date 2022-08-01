package exercise12.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PoorMansCloneTest {
    @Test
    public void poorMansTest()throws Exception{
        A obj = new A();
        obj.x = 10;
        obj.y = "foo";
        Object clone = PoormansClone.clone(obj);
        assertEquals(A.class, clone.getClass());
        assertNotEquals(obj, clone);
        assertEquals(10, ((A)clone).x);
        assertEquals("foo", ((A)clone).y);
    }




    public static class A{
        public int x;
        public String y;
        public A(){}
    }
}
