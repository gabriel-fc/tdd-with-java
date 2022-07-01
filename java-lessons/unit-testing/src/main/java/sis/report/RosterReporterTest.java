package sis.report;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.courseinfo.DateUtil;
import sis.studentinfo.Student;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static sis.report.ReportConstant.*;

public class RosterReporterTest {
    private CourseSession session;

    @Before
    public void setUp(){
        this.session = CourseSession.create(new Course("ENGL", "101"),
                new DateUtil().createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

    }

    @Test
    public void testRosterReport() throws IOException {
        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        assertReportContents(writer.toString());
    }

    private void assertReportContents(String rosterReport){
        assertEquals(
                String.format(ROSTER_REPORT_HEADER +
                        "A%n" +
                        "B%n" +
                        ROSTER_REPORT_FOOTER +
                        "%d%n", 2), rosterReport);
    }

    @Test
    public void testFiledReport() throws IOException {
        final String filename = "testFiledReport.txt";
        try {
            delete(filename);

            new RosterReporter(session).writeReport(filename);
            StringBuffer buffer = new StringBuffer();
            String line;
            BufferedReader reader =
                    new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null)
                buffer.append(String.format(line + "%n"));
            reader.close();
            assertReportContents(buffer.toString());
        }finally {
            delete(filename);
        }
    }

    private void delete(String filename){
        File file = new File(filename);
        if (file.exists())
            assertTrue("unable to delete " + filename, file.delete());
    }
}
