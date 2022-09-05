package exercise15;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringerTest {
    StringBuilder expected;
    @Before
    public void setUp()throws NoSuchFieldException, NoSuchMethodException{
        expected = new StringBuilder();
        expected.append(ClassForTest.class.getField("a").getName());
        expected.append(ClassForTest.class.getMethod("b").getName());
        expected.append(ClassForTest.class.getMethod("c").getName());
        expected.append(ClassForTest.class.getMethod("d").getName());
        
    }

    @Test
    public void testDump() {
       assertEquals(expected.toString(), ToStringer.dump(new ClassForTest()));
    }


    private class ClassForTest{
        @Dump
        public boolean a;
        public double x;

        @Dump
        public String b(){return null;}
        @Dump
        public int c(){return 0;}

        @Dump
        public void d(){}

        public float y(){return 0.1f;}

    }

}
