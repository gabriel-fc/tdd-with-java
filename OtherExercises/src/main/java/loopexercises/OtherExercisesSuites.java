package loopexercises;

import exceptions.ExceptionsTest;
import fileexercises.FileSystemExercises;
import loopexercises.LoopTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import otherexercises.numberexercise.NumberTest;
import stringexercises.ExerciseWithStringTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ExceptionsTest.class, LoopTest.class,
        NumberTest.class, ExerciseWithStringTest.class,
        FileSystemExercises.class
})

public class OtherExercisesSuites {
}
