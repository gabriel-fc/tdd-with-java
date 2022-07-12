package chess.db;

import chess.board.Board;

import java.io.*;

public class BoardFile {
    private final String FILEPATH = "board-db";

    public Board getBoard() throws IOException {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(FILEPATH));
            return (Board) input.readObject();

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
            output.writeObject(board);
        }finally {
            output.close();
        }
    }
}
