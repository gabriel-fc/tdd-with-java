package sis.studentinfo;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScorerTest {
    @Test
    public void testBadScoreEntered() {
        Scorer scorer = new Scorer();
        assertTrue(scorer.isValid("75"));
        assertFalse(scorer.isValid("bd"));
        assertEquals(35, scorer.score("35"));
        assertEquals(-1, scorer.score("abd"));
    }
}
