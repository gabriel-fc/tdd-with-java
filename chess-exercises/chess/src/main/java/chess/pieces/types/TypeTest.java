package chess.pieces.types;

import chess.game.Game;
import chess.pieces.Piece;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TypeTest {
    private final double DELTA = 0.05;


    @Test
    public void typeTest(){
        assertEquals(3, new Bishop(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(9, new Queen(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(0, new King(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(5, new Rook(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(2.5, new Knight(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(1.0, new Pawn(Piece.Color.WHITE).getStrength(true), DELTA);
        assertEquals(0.5, new Pawn(Piece.Color.WHITE).getStrength(false), DELTA);
    }

    @Test
    public void testKingPossibleMoves(){
        King king = new King(Piece.Color.WHITE);
        assertEquals("[a3, a4, a5, b3, b5, c3, c4, c5]",
                king.getPossibleMoves("b4").toString());

        assertEquals("[a1, a2, b2, c1, c2]",
                king.getPossibleMoves("b1").toString());

    }

    @Test
    public void testQueenPossibleMoves(){
        Piece whiteQueen = new Queen(Piece.Color.WHITE);
        Piece blackQueen = new Queen(Piece.Color.BLACK);
        assertEquals("[a3, a6, b1, b3, b5, c2, c3, c4, d1, d2, " +
                        "d4, d5, d6, d7, d8, e2, e3, e4, f1, f3, f5, g3, g6, h3, h7]",
                whiteQueen.getPossibleMoves("d3").toString());
        assertEquals("[a1, a2, a4, a5, a6, a7, a8, b2, b3, " +
                        "b4, c1, c3, c5, d3, d6, e3, e7, f3, f8, g3, h3]",
                blackQueen.getPossibleMoves("a3").toString());
    }


    @Test
    public void testBishopPossibleMoves(){
        Bishop bishop = (Bishop) Piece.createWhiteBishop();
        verify("[a1, a7, b2, b6, c3, " +
                "c5, e3, e5, f2, f6, g1, g7, h8]", bishop.getPossibleMoves("d4").toString());
    }

    @Test
    public void testKnightPossibleMoves() {
        Knight knight = (Knight) Piece.createWhiteKnight();
        verify("[b3, b5, c2, c6, e2, e6, f3, f5]",
                knight.getPossibleMoves("d4").toString());
    }

    @Test
    public void testPawnPossibleMoves(){
        Pawn pawn = (Pawn) Piece.createBlackPawn();
        verify("[d3]", pawn.getPossibleMoves("d4").toString());
    }

    @Test
    public void testRookPossibleMoves(){
    Rook rook = (Rook) Piece.createBlackRook();
    verify("[a1, a3, a4, a5, a6, a7, a8, b2, c2, d2, e2, f2, g2, h2]", rook.getPossibleMoves("a2").toString());
    }




    public void verify(String expected, String actual){
        TestCase.assertEquals(expected, actual);
    }

}
