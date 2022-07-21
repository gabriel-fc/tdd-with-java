package sis.testing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuiteBuilderTest {
    @Test
    public void testGatherTestClassNames() {
        SuiteBuilder builder = new SuiteBuilder();
        List<String> classes = builder.gatherTestClassNames();
        assertTrue(classes.contains("testing.SuiteBuilderTest"));
        assertFalse(classes.contains("testing.testclasses.NotATestClass"));
    }
}
