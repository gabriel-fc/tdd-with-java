package sis.courseinfo.summer;

import org.junit.Test;
import sis.courseinfo.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;
public class TestSummerCourseSession extends SessionTest{

    @Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL"
                ,
                "200"
                , startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }

    protected Session createSession(
            String department,
            String number,
            Date date) {
        return SummerCourseSession.create(new Course(department, number), date);
    }


}
