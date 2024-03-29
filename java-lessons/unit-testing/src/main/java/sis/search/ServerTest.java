package sis.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sis.util.LineWriter;
import sis.util.TestUtil;

import java.util.List;

import static org.junit.Assert.*;

public class ServerTest {
    private int numberOfResults = 0;
    private Server server;
    private static final long TIMEOUT = 3000L;
    private static final String[] URLS = {
            SearchTest.URL, SearchTest.URL, SearchTest.URL };

    @Before
    public void setUp() throws Exception {
        TestUtil.delete(SearchTest.FILE);
        LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);
        ResultsListener listener = new ResultsListener() {
            public void executed(Search search) {
                numberOfResults++;
            }};
        server = new Server(listener);
    }

    @After
    public void tearDown() throws Exception {
        assertTrue(server.isAlive());
        server.shutDown();
        server.join(3000);
        assertFalse(server.isAlive());
    }

    @Test
    public void testSearch() throws Exception {
        long start = System.currentTimeMillis();
        executeSearches();
        long elapsed = System.currentTimeMillis() - start;
        assertTrue(elapsed < 20);
        waitForResults();
    }

    @Test
    public void testLogs() throws Exception {
        executeSearches();
        waitForResults();
        verifyLogs();
    }
    private void executeSearches() throws Exception {
        for (String url: URLS)
            server.add(new Search(url, "xxx"));
    }

    private void waitForResults() {
        long start = System.currentTimeMillis();
        while (numberOfResults < URLS.length) {
            try {Thread.sleep(1); }
            catch (InterruptedException e) {}
            if (System.currentTimeMillis() - start > TIMEOUT)
                fail("timeout");
        }
    }

    private void verifyLogs() {
        List<String> list = server.getLog();
        assertEquals(URLS.length * 2, list.size());
        for (int i = 0; i < URLS.length; i += 2)
            verifySameSearch(list.get(i), list.get(i + 1));
    }
    private void verifySameSearch(
            String startSearchMsg, String endSearchMsg) {
        String startSearch = substring(startSearchMsg, Server.START_MSG);
        String endSearch = substring(endSearchMsg, Server.END_MSG);
        assertEquals(startSearch, endSearch);
    }
    private String substring(String string, String upTo) {
        int endIndex = string.indexOf(upTo);
        assertTrue("didn't find " + upTo + " in " + string,
                endIndex != -1);
        return string.substring(0, endIndex);
    }
}