import exercise12.Q3Test;
import exercise12.Q4Test;
import exercise13.AlarmClockTest;
import exercise14.RingTest;
import exercise7.LoopTest;
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
        FileSystemExercises.class, Q3Test.class, Q4Test.class,
        AlarmClockTest.class, RingTest.class
})

public class OtherExercisesSuites {
}
