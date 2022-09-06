package exercise15;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ToStringerTest {
    StringBuilder expected;
    @Before
    public void setUp()throws NoSuchFieldException{
        expected = new StringBuilder();
        expected.append('"' + ClassForTest.class.getField("d").getName() + '"');
        expected.append('\n');
        expected.append(ClassForTest.class.getField("b"));
        expected.append('\n');
        expected.append(ClassForTest.class.getField("c"));
        expected.append('\n');
        expected.append(ClassForTest.class.getField("a"));
    }

    @Test
    public void testDump() {
       assertEquals(expected.toString(), ToStringer.dump(new ClassForTest()));
    }



    public static class ClassForTest{
        @Dump
        public boolean a;
        public double x;
        @Dump(order = 2)
        public String b;
        @Dump(order = 100)
        public int c;

        @Dump(order = 1, quote = true, outputMethod = "getName")
        public Date d;

        public float y;

    }

}
