package chess.game;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
        game.start();
    }

    @Test
    public void testIsValidMovement(){

        Piece blackKing = Piece.createBlackKing();
        Piece whiteKing = Piece.createWhiteKing();

        //move to empty place
        assertTrue(game.isValidMovement("d3", whiteKing));
        //move white to black
        assertTrue(game.isValidMovement("g3", whiteKing));
        //move black to white
        assertTrue(game.isValidMovement("a3", blackKing));

        //move to invalid file
        assertFalse(game.isValidMovement("`3", whiteKing));
        assertFalse(game.isValidMovement("i3", whiteKing));

        //move to invalid rank
        assertFalse(game.isValidMovement("a0", whiteKing));
        assertFalse(game.isValidMovement("a9", whiteKing));

        //move white to white
        assertFalse(game.isValidMovement("a1", whiteKing));
        //move black to black
        assertFalse(game.isValidMovement("a7", blackKing));

    }

    @Test
    public void testIsPieceAnEnemy(){
        assertFalse(game.isPieceAnEnemy(Piece.Color.BLACK, Piece.Color.BLACK));
        assertTrue(game.isPieceAnEnemy(Piece.Color.WHITE, Piece.Color.BLACK));
        assertFalse(game.isPieceAnEnemy(Piece.Color.WHITE, Piece.Color.WHITE));
    }
}
