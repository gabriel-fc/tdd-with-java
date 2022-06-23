package otherexercises.string;

import org.junit.Test;

import java.util.Arrays;

public class ExerciseWithStringTest {
    @Test
    public void q1Test(){
        //System.out.println(Arrays.toString("a b c.d*e".split("\\W")));
        String foo = "Create a String literal using the first two sentences of this exercise. You will create a " +
                "WordCount class to parse through the text and count the number of instances of each " +
                "word.";
        WordCount wordCount = new WordCount();
        wordCount.count(foo);

    }

}
