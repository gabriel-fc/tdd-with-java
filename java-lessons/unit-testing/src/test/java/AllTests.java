import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.courseinfo.CourseSessionTest;
import sis.courseinfo.CourseTest;
import sis.courseinfo.DateUtilTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.*;
import sis.courseinfo.summer.TestSummerCourseSession;


@RunWith(Suite.class)
@Suite.SuiteClasses({StudentTest.class, CourseSessionTest.class,
        RosterReporterTest.class, DateUtilTest.class, HonorsGradingStrategyTest.class,
        BasicGradingStrategyTest.class, TestSummerCourseSession.class,
        ScorerTest.class, StudentLoggingTest.class, CourseTest.class,
        AccountTest.class
})

public class AllTests {}