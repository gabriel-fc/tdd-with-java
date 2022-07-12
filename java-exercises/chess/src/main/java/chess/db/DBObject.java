package chess.db;

import chess.board.Board;

import java.io.Serializable;

public class DBObject implements Serializable {
    private Board board = null;
    private String boardString = null;

    protected DBObject(Board board){
        this.board = board;
    }
    protected DBObject(Board board, String boardString){
        this.board = board;
        this.boardString = boardString;
    }
    protected DBObject(String boardString){
        this.boardString = boardString;
    }

    public Board getBoard() {
        return board;
    }

    public String getBoardString() {
        return boardString;
    }
}
