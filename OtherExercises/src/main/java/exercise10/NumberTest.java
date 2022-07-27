package otherexercises.numberexercise;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class NumberTest {



    @Test
    public void q1(){
        BigDecimal decimal1 = new BigDecimal("2.0");
        BigDecimal decimal2 = new BigDecimal("3.0");
        assertEquals(new BigDecimal("5.0"), decimal1.add(decimal2));
        assertEquals(new BigDecimal("2.0"), decimal1);
    }

    @Test
    public void q2(){
        BigDecimal decimal1 = new BigDecimal("10.00");
        BigDecimal decimal2 = new BigDecimal("1");
        assertEquals(decimal1, decimal2.multiply(new BigDecimal("10")).
                setScale(2, RoundingMode.DOWN));
    }

    @Test
    public void q3(){
        double delta = 0.0005;
        assertNotEquals(0.9, (float) 0.005*2.0, delta);
        System.out.println((float) 0.005*2.0);
        assertNotEquals(0.9, 0.005*2.0, delta);
    }

    @Test
    public void q4(){
        /**
         *  float x = 0.01;
         * it wont compile because we are providing a double value to a float variable.
         * We can add an f to the end of the number so the compiler will understand it as a float, or
         * we can cast it.
         **/
        float x = 0.01f;
        float y = (float)0.01;
    }

    @Test
    public void q5(){
        int x = 0xDEAD;
        System.out.println(x);
        System.out.println(Integer.toOctalString(0xDEAD));
    }

    @Test
    public void q6(){
        assertTrue(Double.isNaN(0.0/0));
        assertTrue(Double.isNaN(Double.POSITIVE_INFINITY/Double.POSITIVE_INFINITY));
        assertTrue(Double.isNaN(Double.POSITIVE_INFINITY/Double.NEGATIVE_INFINITY));


        assertTrue(Double.isNaN(Math.sqrt(-2)));
        assertTrue(Double.isNaN(Math.log(-2)));

        //infinity
        assertTrue(Double.isInfinite(Double.POSITIVE_INFINITY/0.0));
        assertTrue(Double.isInfinite(Double.POSITIVE_INFINITY/999999999));
    }

    @Test
    public void q8(){
        assertEquals("[3, 6, 9]", getDivisibleBy3WithModulus(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toString());

    }

    private List<Integer> getDivisibleBy3WithModulus(int ...numbers){
        List<Integer> output = new ArrayList<>();
        for (int n: numbers) {
            if (n%3 == 0) output.add(n);
        }
        return output;
    }

    @Test
    public void q10(){

            float x = 1;
         // float y = 1.0;  -> doesn't  work
            float z = (int)1.0;
        /*
            attributing an int to a float variable works because int type uses less memory space than float.
            the second case doesn't work because double types needs more space than float.
         */
    }

    @Test
    public void q11(){
        assertEquals(1, (int)1.9);
    }

    @Test
    public void q12(){
        assertEquals(1,(int)1.9); // casting to int always rounds down
        assertEquals(2,(int)Math.rint(1.9)); // math.rint rounds to the nearest int
    }

    @Test
    public void q14(){
        int x= 5, y=10;
        assertEquals(42,x * 5 + y++ * 7 / 4); //x * 5 + y++ * 7 / 4 -> x = 5, y = 11, expression = 25 + 70/4 = 25 + 17 = 42
        y--;
        assertEquals(300, ++x * 5 * y++); // x = 6, y = 11, expression = 300 | 6 * 5 * 10 = 300;
        x--;
        y--;
        assertEquals(275, x++ * 5 * ++y); // x = 6, y = 11, expression = 275 | 5 * 5 * 11 = 275;
        x--;
        y--;
        assertEquals(51, ++x + 5 * 7 + y++); // x = 6, y = 11, expression = 220 | 6 * 5 * 7 + 10 = 275;
        x--;
        y--;
        //assertEquals(220, (++y++) % (++x++)); wont compile
        assertTrue(x * 7 == 35 || y++ == 0); // x = 5, y = 11, expression = true because the first condition is true when x == 5
        assertEquals(66,++x * ++y); // x = 6, y = 11, expression = 66 | 6 * 16 = 60;
        x--;
        y--;
        assertEquals(50,x++ * y++); // x = 6, y = 11, expression = 50 | 5 * 10 = 50;
        x--;
        y--;
        //assertTrue(true && x * 7); wont compile because logical ops doesn't accept int
        assertTrue( x * 2 == y || ++y == 10); // x == 5, y == 11, expression == true | first expression is
        //5*2 == 10
    }


    @Test
    public void q15(){
        assertEquals(34, 17<<1);
    }

    @Test
    public void q16(){
        assertEquals(-2, ~1);
    }

    @Test
    public void q17(){
        assertEquals(-1,-1>>1);
        assertEquals(2147483647,-1>>>1);//max int

        //the >> op shift the signal bit too, and >>> doesnt
    }

    @Test
    public void q18(){
        for (int i = 0; i < 1000; i++) {
            int x =  (int)(50 * Math.random());
            assertTrue(x >= 0 && x < 50);
        }
    }


    @Test
    public void q19(){
        ArrayList<Integer> numbers = new ArrayList<>();
        fillList(numbers);
        for (int i = 0; i < 100; i++) {
            swap(numbers, generateNumber(), generateNumber());
        }
    }
    private void fillList(List list){
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }
    private void swap(ArrayList<Integer> list, int a, int b){
        int x = list.get(a);
        list.set(a, list.get(b));
        list.set(b, x);
    }

    private Generator gen;
    private int generateNumber(){
        if (gen == null) gen = new Generator();
        return gen.nextInt(100);
    }

    public class Generator {
        final long seed = System.currentTimeMillis();
        final Random gen = new Random(seed);

        public int nextInt(int bound) {
            return gen.nextInt(bound);
        }
    }

    @Test
    public void q20(){
        assertEquals(new Random(1).nextDouble(), new Random(1).nextDouble(), 0.0);
        assertNotEquals(new Random(1).nextDouble(), new Random().nextDouble());
    }

    @Test
    public void q21(){
        int x = 20, y = 30;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        assertEquals(30, x);
        assertEquals(20, y);

        int t = Integer.MAX_VALUE, i;
        for (i = 1; t > 0 ; i++) {
            System.out.println(t);
            t = t >> 1;
        }
        System.out.println(i);
    }

    @Test
    public void q22(){
        int x = Character.MAX_VALUE;
        char y = Character.MATH_SYMBOL;
        assertEquals(Character.MIN_VALUE,(char)(Character.MAX_VALUE >>> 16));
        assertEquals((byte) 0,(byte) (Byte.MAX_VALUE >>> 8));
        assertEquals((short) 0, (short) (Short.MAX_VALUE >>> 16));
        assertEquals(0, Integer.MAX_VALUE >>> 31);
        assertEquals((long) 0, Long.MAX_VALUE >>> 63);
    }
}


