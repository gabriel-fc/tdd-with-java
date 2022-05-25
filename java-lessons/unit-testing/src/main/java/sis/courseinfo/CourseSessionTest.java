package sis.courseinfo;

import org.junit.Before;
import org.junit.Test;

import sis.studentinfo.*;

import java.util.Date;

import static org.junit.Assert.*;
import static sis.courseinfo.DateUtil.createDate;


public class CourseSessionTest extends SessionTest {
//    private CourseSession session;
//
//    private static final int CREDITS = 3;
//
//    private final double DELTA = 0.05;
//
//
//    private CourseSession createCourseSession() {
//        Date startDate = DateUtil.createDate(2003, 1, 6);
//        return CourseSession.create("ENGL", "101", startDate);
//    }
//
//    @Before
//    public void setUp(){
//        session = createCourseSession();
//        session.setNumberOfCredits(CourseSessionTest.CREDITS);
//    }
//
//    @Test
//    public void testCreate() {
//        Student student1 = new Student("Jane Doe");
//        //test size = 0
//        assertEquals(0, session.getNumberOfStudents());
//        assertTrue(session.isEmpty());
//        // test size = 1
//        session.addStudent(student1);
//        assertEquals(CREDITS, student1.getCredits());
//        assertEquals(student1, (session.getStudent(0)));
//        assertEquals(1, session.getNumberOfStudents());
//        //test size = 2
//        Student student2 = new Student("John Doe");
//        session.addStudent(student2);
//        assertEquals(CREDITS, student2.getCredits());
//        assertEquals(2, session.getNumberOfStudents());
//        assertEquals(student2, session.getStudent(1));
//
//    }
//
//    @Test
//    public void testCount() {
//        CourseSession.resetCount();
//        createCourseSession();
//        assertEquals(1, CourseSession.getCount());
//        createCourseSession();
//        assertEquals(2, CourseSession.getCount());
//    }
//
//    @Test
//    public void testStudentStatus() {
//        Student student = new Student("a");
//        assertEquals(0, student.getCredits());
//        assertFalse(student.isFullTime());
//        student.addCredits(3);
//        assertEquals(3, student.getCredits());
//        assertFalse(student.isFullTime());
//        student.addCredits(4);
//        assertEquals(7, student.getCredits());
//        assertFalse(student.isFullTime());
//        student.addCredits(5);
//        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME,
//                student.getCredits());
//        assertTrue(student.isFullTime());
//    }
//
//    @Test
//    public void testInState() {
//        Student student = new Student("a");
//        assertFalse(student.isInState());
//        student.setState(Student.IN_STATE);
//        assertTrue(student.isInState());
//        student.setState("MD");
//        assertFalse(student.isInState());
//    }
//
//    @Test
//    public void testCalculateHonorsStudentGpa() {
//        assertGpa(createHonorsStudent(), 0.0);
//        assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
//        assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
//        assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
//        assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
//        assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
//    }
//    private Student createHonorsStudent(Student.Grade grade) {
//        Student student = createHonorsStudent();
//        student.addGrade(grade);
//        return student;
//    }
//    private Student createHonorsStudent() {
//        Student student = new Student("a");
//        student.setHonors();
//        return student;
//    }
//
//
//
//
//    public void assertGpa(Student student, double points){
//        assertEquals(student.getGpa(), points, DELTA);
//    }

    public void testCourseDates() {
        Date startDate = createDate(2003, 1, 6);
        Session session = createSession("ENGL"
                ,
                "200"
                , startDate);
        Date sixteenWeeksOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    public void testCount() {
        CourseSession.resetCount();
        createSession(""
                ,
                ""
                , new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(""
                ,
                ""
                , new Date());
        assertEquals(2, CourseSession.getCount());
    }
    protected Session createSession(
            String department,
            String number,
            Date date) {
        return CourseSession.create(department, number, date);
    }



}
