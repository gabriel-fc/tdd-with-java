package chess.board;

import chess.db.DataBase;
import chess.pieces.Piece;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SerializedBoardTest {
    private Board expectedBoard;
    DataBase db;
    @Before
    public void setUp(){
        expectedBoard = new Board();
        expectedBoard.setEmptyBoard();
        db = DataBase.getDb();
        expectedBoard.put("a1",Piece.createBlackKing());
        expectedBoard.put("d5",Piece.createWhitePawn());
        db.persist(expectedBoard);
    }

    @After
    public void tearDown(){
        db.deleteDataBase();
    }

    @Test
    public void boardToFileTest(){
        assertTrue(db.persist(expectedBoard));
    }

    @Test
    public void fileToBoardTest(){
        assertTrue(expectedBoard.compareBoard(db.getBoard()));

    }
}
