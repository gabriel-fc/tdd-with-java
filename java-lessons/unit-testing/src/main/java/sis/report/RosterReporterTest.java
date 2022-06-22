package sis.report;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.courseinfo.DateUtil;
import sis.studentinfo.Student;

import static sis.report.ReportConstant.*;

public class RosterReporterTest {
    private CourseSession session;

    @Before
    public void setUp(){
        this.session = CourseSession.create(new Course("ENGL", "101"),
                new DateUtil().createDate(2003, 1, 6));

    }

    @Test
    public void testRosterReport(){
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        String rosterReport = new RosterReporter(session).getReport();
        assertEquals(ROSTER_REPORT_HEADER +
                NEWLINE +
                "A" + NEWLINE +
                "B" + NEWLINE +
                ROSTER_REPORT_FOOTER +  NEWLINE + "2" +
                NEWLINE, rosterReport);
    }
}
