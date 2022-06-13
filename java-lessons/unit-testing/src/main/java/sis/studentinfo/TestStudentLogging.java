package sis.studentinfo;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStudentLogging {

    @Test
    public void testLoggingHierarchy() {
        Logger logger = Logger.getLogger("sis.studentinfo.Student");
        assertTrue(logger == Logger.getLogger("sis.studentinfo.Student"));
        Logger parent = Logger.getLogger("sis.studentinfo");
        assertEquals(parent, logger.getParent());
        assertEquals(Logger.getLogger("sis"), parent.getParent());
    }
}
