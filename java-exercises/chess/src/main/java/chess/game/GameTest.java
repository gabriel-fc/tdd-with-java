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
        Game game = new Game();
        game.start();
        Piece blackKing = Piece.createBlackKing();
        Piece whiteKing = Piece.createWhiteKing();

        //move to empty place
        assertTrue(game.isValidMovement("d3", whiteKing.getColor()));
        //move white to black
        assertTrue(game.isValidMovement("g3", whiteKing.getColor()));
        //move black to white
        assertTrue(game.isValidMovement("a3", blackKing.getColor()));

        //move to invalid file
        assertFalse(game.isValidMovement("`3", whiteKing.getColor()));
        assertFalse(game.isValidMovement("i3", whiteKing.getColor()));

        //move to invalid rank
        assertFalse(game.isValidMovement("a0", whiteKing.getColor()));
        assertFalse(game.isValidMovement("a9", whiteKing.getColor()));

        //move white to white
        assertFalse(game.isValidMovement("a1", whiteKing.getColor()));
        //move black to black
        assertFalse(game.isValidMovement("a7", blackKing.getColor()));





    }
}
