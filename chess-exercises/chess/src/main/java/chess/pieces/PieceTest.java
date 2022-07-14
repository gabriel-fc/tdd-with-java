package chess.pieces;

import chess.pieces.types.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class PieceTest {

    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePawn(), Piece.createBlackPawn(),
                Pawn.class, Piece.createWhitePawn().getRepresentation());
        verifyCreation(
                Piece.createWhiteRook(), Piece.createBlackRook(),
                Rook.class, Piece.createWhiteRook().getRepresentation());
        verifyCreation(
                Piece.createWhiteKnight(), Piece.createBlackKnight(),
                Knight.class, Piece.createWhiteKnight().getRepresentation());
        verifyCreation(
                Piece.createWhiteBishop(), Piece.createBlackBishop(),
                Bishop.class, Piece.createWhiteBishop().getRepresentation());
        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
                Queen.class, Piece.createWhiteQueen().getRepresentation());
        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
                King.class, Piece.createWhiteKing().getRepresentation());
        Piece blank = Piece.noPiece();
        assertEquals('.'
                , blank.getRepresentation());
        assertEquals(NoPiece.class, blank.getClass());
    }
    private void verifyCreation(Piece whitePiece, Piece blackPiece,
                                Class type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getClass());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getClass());
        assertEquals(Character.toUpperCase(representation),
                blackPiece.getRepresentation());

    }
}

