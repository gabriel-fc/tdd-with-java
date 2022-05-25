import org.junit.Test;
import sis.studentinfo.HonorsGradingStrategy;
import sis.studentinfo.Student;

import java.lang.management.GarbageCollectorMXBean;

import static org.junit.Assert.*;

public class StudentTest{
    private static final double GRADE_TOLERANCE = 0.05;



    @Test
    public void testCreate(){
        Student newStudent  = new Student("Jane Doe");
        assertEquals("Jane Doe", newStudent.getName());
    }

    @Test
    public void testFullTime(){
        Student studentA = new Student("a");
        assertFalse(studentA.isFullTime());
    }

    @Test
    public void testCredits() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());
        student.addCredits(5);
        assertTrue(student.isFullTime());
    }

    @Test
    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade(Student.Grade.A);
        assertGpa(student, 4.0);
        student.addGrade(Student.Grade.B);
        assertGpa(student, 3.5);
        student.addGrade(Student.Grade.C);
        assertGpa(student, 3.0);
        student.addGrade(Student.Grade.D);
        assertGpa(student, 2.5);
        student.addGrade(Student.Grade.F);
        assertGpa(student, 2.0) ;
    }
    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }

    public Student createHonorsStudent() {
        Student student = new Student("a");
        student.setGradingStrategy(new HonorsGradingStrategy());
        return student;
    }

}
