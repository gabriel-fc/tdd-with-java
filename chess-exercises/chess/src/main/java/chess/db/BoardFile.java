package chess.db;

import chess.board.Board;
import chess.board.BoardInterface;
import chess.board.SerializedBoardTest;

import java.io.*;

public class BoardFile {
    private final String FILEPATH = "board-db";

    private DBObject getBoard() throws IOException {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(FILEPATH));
            return (DBObject) input.readObject();

        }catch (ClassNotFoundException e){
            throw new RuntimeException("Classe incompatível ao buscar objeto Board no arquivo " + FILEPATH, e);
        }finally {
            input.close();
        }
    }

    public void persist(Board board) throws IOException{
        ObjectOutputStream output = null;
        try{
            output = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            output.writeObject(new DBObject(board));
        }finally {
            output.close();
        }
    }

    public void persist(String boardString) throws IOException{
        ObjectOutputStream output = null;
        try{
            output = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            output.writeObject(new DBObject(boardString));
        }finally {
            output.close();
        }
    }

    public void persist(Board board, String boardString) throws IOException{
        ObjectOutputStream output = null;
        try{
            output = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            output.writeObject(new DBObject(board, boardString));
        }finally {
            output.close();
        }
    }

    public String getBoardRepresentation()throws IOException{
        return getBoard().getBoardString();
    }

    public Board getBoardObject() throws IOException{
        return getBoard().getBoard();
    }

}
