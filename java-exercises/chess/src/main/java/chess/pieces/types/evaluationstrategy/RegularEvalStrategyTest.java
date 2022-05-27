package chess.pieces.types.evaluationstrategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularEvalStrategyTest {
    private final double DELTA = 0.05;

    @Test
    public void testStrength(){
        EvaluationStrategy strategy1  = new RegularEvaluationStrategy(2.5);
        EvaluationStrategy strategy2  = new RegularEvaluationStrategy(4);

        assertEquals(2.5, strategy1.getStrength(true), DELTA);
        assertEquals(2.5, strategy1.getStrength(false), DELTA);

        assertEquals(4, strategy2.getStrength(true), DELTA);
        assertEquals(4, strategy2.getStrength(false), DELTA);

    }
}
