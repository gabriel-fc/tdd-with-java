package sis.report;
import org.junit.Before;
import org.junit.Test;
import sis.studentinfo.Student;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ReportCardTest {
    private ReportCard card;
    @Before
    public void setUp() {
        card = new ReportCard();
    }
    @Test
    public void testMessage() {
        assertEquals(ReportCard.A_MESSAGE,
        card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE,
        card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE,
        card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE,
        card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE,
        card.getMessage(Student.Grade.F));
    }

    @Test
    public void testKeys() {
        Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
        expectedGrades.add(Student.Grade.A);
        expectedGrades.add(Student.Grade.B);
        expectedGrades.add(Student.Grade.C);
        expectedGrades.add(Student.Grade.D);
        expectedGrades.add(Student.Grade.F);
        Set<Student.Grade> grades = new HashSet<Student.Grade>();
        for (Student.Grade grade: card.getMessages().keySet())
            grades.add(grade);
        assertEquals(expectedGrades, grades);
    }
}
