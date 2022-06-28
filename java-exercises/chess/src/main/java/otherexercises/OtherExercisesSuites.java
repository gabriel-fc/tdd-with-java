package otherexercises;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import otherexercises.exceptions.ExceptionsTest;
import otherexercises.numberexercise.NumberTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ExceptionsTest.class, LoopTest.class,
        NumberTest.class
})

public class OtherExercisesSuites {
}
