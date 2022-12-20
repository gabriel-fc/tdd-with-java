package chess.db;

import chess.board.Board;
import chess.board.BoardInterface;
import chess.pieces.Piece;
import chess.util.StringUtil;

import java.io.*;
import java.nio.file.Files;

public class DataBase {
    private static DataBase db;
    private FileHandler file;


    private DataBase(){
        file = new FileHandler();
    }

    public static DataBase getDb(){
        if(db == null){
            db = new DataBase();
        }
        return db;
    }


    private String query() {
        return file.read().replaceAll("\n", "");
    }

    public boolean persist(Board board) {
        String toBePersisted = BoardInterface.printBoard(board);
        return file.write(toBePersisted);
    }

    public Board getBoard(){
        String boardRep = query();
        Board board = new Board();
        String position;
        for (int i = 0; i < boardRep.length(); i++) {
            position = StringUtil.byUnidimensionalRepresentationGetPosition(i);
            board.put(position, Piece.byRepresentationGetPiece(boardRep.charAt(i)));
        }
        if (board.isEmpty()) board.setEmptyBoard();

        return board;
    }

    public void deleteDataBase(){
        file.deleteFile();
    }
}
