package exercise12.util;

import org.junit.Test;

public class ObjectDumperTest {
    @Test
    public void testDump(){
        ObjectDumper.dump(new A("abc", new B()));
    }


    private class A{
        private String a;
        private B b;

        private A(String a, B b){
            this.a = a;
            this.b = b;
        }

        public void aa(){}

        public B bb(){return b;}
    }

    private class B{
        private int b = 5;
        private Double c = 5.5;

        public Double getC() {
            return c;
        }

        public int getB() {
            return b;
        }
    }


}
