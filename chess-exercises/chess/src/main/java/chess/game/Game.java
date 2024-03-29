package chess.game;

import chess.board.Board;
import chess.pieces.Piece;

public class Game {
    private Board board;
    public Game(){board = new Board();}

    public void start(){
        board.initialize();
    }

    public boolean isValidMovement(String position, Piece piece) {
        return Board.isValidPosition(position) &&
                (board.isPositionEmpty(position) || piece.isOpponent(board.getPiece(position)));
    }

    public boolean isPieceAnEnemy(Piece.Color current, Piece.Color other){
        return current != other;
    }

}
