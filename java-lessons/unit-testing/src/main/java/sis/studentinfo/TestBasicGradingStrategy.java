package sis.studentinfo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBasicGradingStrategy {

    @Test
    public void testGetGradePoints() {
        BasicGradingStrategy strategy = new BasicGradingStrategy();
        assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
        assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
        assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
        assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}
