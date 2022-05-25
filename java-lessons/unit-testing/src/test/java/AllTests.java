import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.courseinfo.CourseSessionTest;
import sis.courseinfo.DateUtilTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.TestBasicGradingStrategy;
import sis.studentinfo.TestHonorsGradingStrategy;
import sis.courseinfo.summer.TestSummerCourseSession;


@RunWith(Suite.class)
@Suite.SuiteClasses({StudentTest.class, CourseSessionTest.class,
        RosterReporterTest.class, DateUtilTest.class, TestHonorsGradingStrategy.class,
        TestBasicGradingStrategy.class, TestSummerCourseSession.class})

public class AllTests {}