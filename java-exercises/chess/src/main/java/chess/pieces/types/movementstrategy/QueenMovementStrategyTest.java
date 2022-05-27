package chess.pieces.types.movementstrategy;

import chess.game.Game;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QueenMovementStrategyTest{



    @Test
    public void possibleUpMovesTest(){
        QueenMovementStrategy queenMove = new QueenMovementStrategy();
        Game game = new Game();
        game.start();
        assertEquals(Arrays.asList("e3", "e4", "e5", "e6", "e7"))
    }

}
