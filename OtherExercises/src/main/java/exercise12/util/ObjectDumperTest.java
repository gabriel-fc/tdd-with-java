package exercise12.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectDumperTest {
    @Test
    public void testDump(){
        String expected = "Current Object: exercise12.util exercise12.util.ObjectDumperTest$A A\n" +
                "  java.lang java.lang.String String\n" +
                "  Current Object: exercise12.util exercise12.util.ObjectDumperTest$B B\n" +
                "  java.lang java.lang.Integer Integer\n" +
                "  java.lang java.lang.Double Double\n" +
                "End of Object: exercise12.util exercise12.util.ObjectDumperTest$B B\n" +
                "\n" +
                "End of Object: exercise12.util exercise12.util.ObjectDumperTest$A A\n";

        assertEquals( expected, ObjectDumper.dump(new A("abc", new B())));
    }
    private class A{
        private String a;
        public B b;

        private A(String a, B b){
            this.a = a;
            this.b = b;
        }
        public void aa(){}

        public B bb(){return b;}
    }

    private class B{
        public int b = 5;
        public Double c = 5.5;

        public Double getC() {
            return c;
        }

        public int getB() {
            return b;
        }
    }
}
