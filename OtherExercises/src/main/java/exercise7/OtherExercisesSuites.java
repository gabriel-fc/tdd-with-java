package exercise7;

import exercise8.ExceptionsTest;
import exercise11.FileSystemExercises;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import otherexercises.numberexercise.NumberTest;
import exercise9.ExerciseWithStringTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ExceptionsTest.class, LoopTest.class,
        NumberTest.class, ExerciseWithStringTest.class,
        FileSystemExercises.class
})

public class OtherExercisesSuites {
}
