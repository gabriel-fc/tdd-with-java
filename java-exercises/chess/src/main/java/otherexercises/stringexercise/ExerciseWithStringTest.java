package otherexercises.stringexercise;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ExerciseWithStringTest {
    @Test
    public void q1Test(){
        //System.out.println(Arrays.toString("a b c.d*e".split("\\W")));
        String foo = "Create a String literal using the first two sentences of this exercise. " +
                "You will create a WordCount class to parse through the text and count the number " +
                "of instances of each word.";

        WordCount wordCount = new WordCount();
        wordCount.count(foo);
        assertTrue(wordCount.contains("create"));
        assertTrue(wordCount.contains("of"));
        assertEquals(3, wordCount.getIncidence("of"));
    }

    @Test
    public void q2Test(){
        Name name1 = new Name("foo");
        Name name2 = new Name("Foo");
        Name name3 = new Name("foo");
        assertEquals(name1, name3);
        assertNotEquals(name1, name2);
        Set<Name> nameSet = new HashSet<>();
        nameSet.add(name2);
        assertTrue(nameSet.contains(name2));
    }
}
