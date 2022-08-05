import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.courseinfo.CourseSessionTest;
import sis.courseinfo.CourseTest;
import sis.courseinfo.DateUtilTest;
import sis.db.DataFileTest;
import sis.db.KeyFileTest;
import sis.report.RosterReporterTest;
import sis.search.SearchTest;
import sis.search.ServerTest;
import sis.security.SecureProxyTest;
import sis.studentinfo.*;
import sis.courseinfo.summer.TestSummerCourseSession;
import sis.util.IOUtilTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({StudentTest.class, CourseSessionTest.class,
        RosterReporterTest.class, DateUtilTest.class, HonorsGradingStrategyTest.class,
        BasicGradingStrategyTest.class, TestSummerCourseSession.class,
        ScorerTest.class, StudentLoggingTest.class, CourseTest.class,
        AccountTest.class, SerializationTest.class, CourseCatalogTest.class,
        DataFileTest.class, KeyFileTest.class, IOUtilTest.class,
        SerializationTest.class, StudentDirectoryTest.class, AccountTest.class,
        AccountFactoryTest.class, SearchTest.class, ServerTest.class, SecureProxyTest.class,
        MultithreadedAccountTest.class, StudentLoggingTest.class
})

public class AllTests {}