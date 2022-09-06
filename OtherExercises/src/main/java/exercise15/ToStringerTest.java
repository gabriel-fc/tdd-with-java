package exercise15;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ToStringerTest {
    StringBuilder expected;
    @Before
    public void setUp()throws NoSuchFieldException, NoSuchMethodException{
        expected = new StringBuilder();
        expected.append('"' + ClassForTest.class.getField("d").getName() + '"');
        expected.append('\n');
        expected.append(ClassForTest.class.getField("b").getName());
        expected.append('\n');
        expected.append(ClassForTest.class.getField("c").getName());
        expected.append('\n');
        expected.append(ClassForTest.class.getField("a").getName());
    }

    @Test
    public void testDump() {
       assertEquals(expected.toString(), ToStringer.dump(new ClassForTest()));
    }



    private class ClassForTest{
        @Dump
        public boolean a;
        public double x;
        @Dump(order = 2)
        public String b;
        @Dump(order = 100)
        public int c;

        @Dump(order = 1, quote = true)
        public Date d;

        public float y;

    }

}
