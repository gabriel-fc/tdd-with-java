package sis.courseinfo;

import sis.studentinfo.Student;

import java.util.*;

public class CourseSession extends Session{


    private static int count;
    public static CourseSession create(
            Course course, Date startDate) {
        return new CourseSession(course, startDate);
    }
    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
        CourseSession.incrementCount();
    }
    static private void incrementCount() {
        ++count;
    }
    static void resetCount() {
        count = 0;
    }
    static int getCount() {
        return count;
    }
    protected int getSessionLength() {
        return 16;
    }
}