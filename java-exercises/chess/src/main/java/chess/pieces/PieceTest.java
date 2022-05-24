package chess.pieces;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import chess.pieces.types.Type;
import static org.junit.Assert.assertTrue;
public class PieceTest {

    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePawn(), Piece.createBlackPawn(),
                Type.PAWN, Type.PAWN.getRepresentation(Piece.Color.WHITE));
        verifyCreation(
                Piece.createWhiteRook(), Piece.createBlackRook(),
                Type.ROOK, Type.ROOK.getRepresentation(Piece.Color.WHITE));
        verifyCreation(
                Piece.createWhiteKnight(), Piece.createBlackKnight(),
                Type.KNIGHT, Type.KNIGHT.getRepresentation(Piece.Color.WHITE));
        verifyCreation(
                Piece.createWhiteBishop(), Piece.createBlackBishop(),
                Type.BISHOP, Type.BISHOP.getRepresentation(Piece.Color.WHITE));
        verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(),
                Type.QUEEN, Type.QUEEN.getRepresentation(Piece.Color.WHITE));
        verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(),
                Type.KING, Type.KING.getRepresentation(Piece.Color.WHITE));
        Piece blank = Piece.noPiece();
        assertEquals('.'
                , blank.getRepresentation());
        assertEquals(Type.NO_PIECE, blank.getType());
    }
    private void verifyCreation(Piece whitePiece, Piece blackPiece,
                                Type type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation),
                blackPiece.getRepresentation());
    }
}

