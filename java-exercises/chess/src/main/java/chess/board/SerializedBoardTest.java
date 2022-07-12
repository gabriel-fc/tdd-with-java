package chess.board;

import chess.db.BoardFile;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SerializedBoardTest {

    @Test
    public void boardToFileTest()throws IOException {
        BoardFile db = new BoardFile();
        Board board = new Board();
        board.initialize();
        db.persist(board);
        assertEquals(board, db.getBoard());
    }
}
