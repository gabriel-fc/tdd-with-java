package chess;

import chess.pieces.BoardInterface;
import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import util.StringUtil;


public class BoardTest {
    Board board = new Board();
    private final double DELTA = 0.05;
    private String BLANK_RANK = StringUtil.appendNewLine("........");


    @Before
    public void setUp() {
        board.initialize();
    }

    @Test
    public void testBoardRanks() {
        assertEquals("RNBQKBNR", BoardInterface.printRank(8, board));
        assertEquals("PPPPPPPP", BoardInterface.printRank(7, board));
        assertEquals("........", BoardInterface.printRank(6, board));
        assertEquals("........", BoardInterface.printRank(5, board));
        assertEquals("........", BoardInterface.printRank(4, board));
        assertEquals("........", BoardInterface.printRank(3, board));
        assertEquals("pppppppp", BoardInterface.printRank(2, board));
        assertEquals("rnbqkbnr", BoardInterface.printRank(1, board));
    }
    @Test
    public void testCreateBoard() {
        assertEquals(32, board.pieceCount());
        assertEquals(
                StringUtil.appendNewLine("RNBQKBNR") +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        BLANK_RANK + BLANK_RANK + BLANK_RANK + BLANK_RANK +
                        StringUtil.appendNewLine("pppppppp") +
                        StringUtil.appendNewLine("rnbqkbnr"),
                BoardInterface.printBoard(board));
    }
    @Test
    public void testPieceColor() {
        Piece piece1 = Piece.createWhitePawn();
        Piece piece2 = Piece.createBlackPawn();
        assertTrue(piece1.isWhite());
        assertTrue(piece2.isBlack());
    }

    @Test
    public void testisAloneInTheFile(){
        assertTrue(board.isAloneInTheFile('p', 'a'));
        assertTrue(board.isAloneInTheFile('P', 'a'));
        assertTrue(board.isAloneInTheFile('r', 'a'));
        assertTrue(board.isAloneInTheFile('R', 'a'));
        assertTrue(board.isAloneInTheFile('p', 'b'));
        assertTrue(board.isAloneInTheFile('P', 'b'));
        assertTrue(board.isAloneInTheFile('n', 'b'));
        assertTrue(board.isAloneInTheFile('N', 'b'));

    }


    @Test
    public void testEmptyBoard(){
        board.setEmptyBoard();
        assertEquals(BLANK_RANK+BLANK_RANK+BLANK_RANK+BLANK_RANK
        +BLANK_RANK+BLANK_RANK+BLANK_RANK+BLANK_RANK, BoardInterface.printBoard(board));

    }

    @Test
    public void testPlacePiece(){
        Piece p = Piece.createBlackKnight();
        board.placePiece(p, "a1");
        assertEquals(board.getPiece("a1"), p);
    }

    @Test
    public void testGetStrengthByColor(){
        board.setEmptyBoard();
        board.placePiece(Piece.createBlackKing(), "b8");
        assertEquals(0, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackRook(), "c8");
        assertEquals(5, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackPawn(), "a7");
        assertEquals(6, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackPawn(), "c7");
        assertEquals(7, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackBishop(), "d7");
        assertEquals(10, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackPawn(), "b6");
        assertEquals(11, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createBlackQueen(), "e6");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhiteKnight(), "f4");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(2.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhiteQueen(), "g4");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(11.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhitePawn(), "f3");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(12.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhitePawn(), "h3");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(13.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhitePawn(), "f2");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(13.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhitePawn(), "g2");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(14.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhiteRook(), "e1");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(19.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.placePiece(Piece.createWhiteKing(), "f1");
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(19.5, board.getStrength(Piece.Color.WHITE), DELTA);
    }


}