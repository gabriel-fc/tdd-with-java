package sis.report;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import java.util.Date;

public class TestComparable {

    @Test
    public void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create(new Course("CMSC", "101"), date);
        CourseSession sessionB = CourseSession.create(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        CourseSession sessionC = CourseSession.create(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));
    }

    @Test
    public void testCompareTo(){
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
    }
}
