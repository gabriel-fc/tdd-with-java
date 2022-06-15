package chess.game;

import chess.board.Board;
import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    public Game(){board = new Board();}

    public void start(){
        board.initialize();
    }

    public boolean isValidMovement(String position, Piece piece){
        return Board.isValidPosition(position) &&
                (board.isPositionEmpty(position) || piece.isOpponent(board.getPiece(position)));
    }


}
