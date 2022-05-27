package chess.pieces.types.evaluationstrategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnEvalStrategyTest {
    private final double DELTA = 0.05;



    @Test
    public void testStrength(){
        EvaluationStrategy strategy = new PawnEvaluationStrategy(1, 0.5);
        assertEquals(1.0, strategy.getStrength(true), DELTA);
        assertEquals(0.5, strategy.getStrength(false), DELTA);


    }
}
