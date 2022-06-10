package chess.board;

import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
        assertEquals(32, board.getPiecesCount());
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
        assertTrue(board.isAloneInTheFile('p', 0));
        assertTrue(board.isAloneInTheFile('P', 0));
        assertTrue(board.isAloneInTheFile('r', 0));
        assertTrue(board.isAloneInTheFile('R', 0));
        assertTrue(board.isAloneInTheFile('p', 1));
        assertTrue(board.isAloneInTheFile('P', 1));
        assertTrue(board.isAloneInTheFile('n', 1));
        assertTrue(board.isAloneInTheFile('N', 1));

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
        board.put("a1", p);
        assertEquals(board.getPiece("a1"), p);
    }

    @Test
    public void testGetStrengthByColor(){
        board.setEmptyBoard();
        board.put("b8", Piece.createBlackKing());
        assertEquals(0, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("c8", Piece.createBlackRook());
        assertEquals(5, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("a7", Piece.createBlackPawn());
        assertEquals(6, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("c7", Piece.createBlackPawn());
        assertEquals(7, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("d7", Piece.createBlackBishop());
        assertEquals(10, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("b6", Piece.createBlackPawn());
        assertEquals(11, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("e6", Piece.createBlackQueen());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(0, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("f4", Piece.createWhiteKnight());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(2.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("g4", Piece.createWhiteQueen());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(11.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("f3", Piece.createWhitePawn());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(12.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("h3", Piece.createWhitePawn());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(13.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("f2", Piece.createWhitePawn());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(13.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("g2", Piece.createWhitePawn());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(14.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("e1", Piece.createWhiteRook());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(19.5, board.getStrength(Piece.Color.WHITE), DELTA);
        board.put("f1", Piece.createWhiteKing());
        assertEquals(20, board.getStrength(Piece.Color.BLACK), DELTA);
        assertEquals(19.5, board.getStrength(Piece.Color.WHITE), DELTA);
    }
}