package chess.game;

import chess.board.Board;
import chess.pieces.BoardInterface;
import chess.pieces.Piece;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {


    @Test
    public void testIsValidMovement(){
        Board board = new Board();
        board.initialize();

        //move to empty place
        assertTrue(Game.isValidMovement("d3", Piece.Color.WHITE, board));
        //move white to black
        assertTrue(Game.isValidMovement("g3", Piece.Color.WHITE, board));
        //move black to white
        assertTrue(Game.isValidMovement("a3", Piece.Color.BLACK, board));

        //move to invalid file
        assertFalse(Game.isValidMovement("`3", Piece.Color.WHITE, board));
        assertFalse(Game.isValidMovement("i3", Piece.Color.WHITE, board));

        //move to invalid rank
        assertFalse(Game.isValidMovement("a0", Piece.Color.WHITE, board));
        assertFalse(Game.isValidMovement("a9", Piece.Color.WHITE, board));

        //move white to white
        assertFalse(Game.isValidMovement("a1", Piece.Color.WHITE, board));
        //move black to black
        assertFalse(Game.isValidMovement("a7", Piece.Color.BLACK, board));





    }
}
