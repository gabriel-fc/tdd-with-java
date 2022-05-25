package sis.report;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;

import sis.courseinfo.CourseSession;

import static java.util.Collections.sort;
import org.junit.Test;


import static sis.report.ReportConstant.NEWLINE;
public class CourseReportTest {
    @Test
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        assertEquals("CZEC 200" + NEWLINE + "ENGL 101" + NEWLINE +
                "ITAL 410" + NEWLINE, report.text());
        report = new CourseReport();
        report.add(CourseSession.create("ENGL", "410", date));
        report.add(CourseSession.create("ENGL", "200", date));
        report.add(CourseSession.create("ENGL", "101", date));
        assertEquals("ENGL 101" + NEWLINE + "ENGL 200" + NEWLINE +
                "ENGL 410" + NEWLINE, report.text());


    }

    @Test
    public void testSortStringsInNewList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");
        ArrayList<String> sortedList = new ArrayList<String>(list);
        sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));
        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }
}
