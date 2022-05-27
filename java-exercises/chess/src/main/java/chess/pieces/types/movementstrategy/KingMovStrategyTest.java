package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;
import chess.pieces.types.Type;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KingMovStrategyTest {

    @Test
    public void kingMovementTest(){
        Game game = new Game();
        KingMovementStrategy kingStrategy = new KingMovementStrategy();
        game.start();
        ArrayList<String> possibleMoves = kingStrategy.
                getPossibleMoves("b4", Piece.Color.WHITE, game);


        assertEquals("b5", possibleMoves.get(0));
        assertEquals("b3", possibleMoves.get(1));
        assertEquals("a4", possibleMoves.get(2));
        assertEquals("c4", possibleMoves.get(3));
        assertEquals("c5", possibleMoves.get(4));
        assertEquals("a5", possibleMoves.get(5));
        assertEquals("c3", possibleMoves.get(6));
        assertEquals("a3", possibleMoves.get(7));


    }
}
