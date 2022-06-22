package sis.courseinfo.summer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;


public class SummerCourseSession extends CourseSession {
    public static SummerCourseSession create(
            Course course, Date startDate) {
        return new SummerCourseSession(course, startDate);
    }
    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        int sessionLength = 8;
        int daysInWeek = 7;
        int daysFromFridayToMonday = 3;
        int numberOfDays =
                sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    @Override
    protected int getSessionLength() {
        return 8;
    }


}
