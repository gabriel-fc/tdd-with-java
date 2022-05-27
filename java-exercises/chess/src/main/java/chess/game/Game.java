package chess.game;

import chess.board.Board;
import chess.pieces.Piece;
import chess.pieces.types.Type;
import util.StringUtil;

public class Game {
    private Board board;


    public Game(){board = new Board();}

    public void start(){
        board.initialize();
    }

    public boolean isValidMovement(String position, Piece.Color color){
        return isValidFile(StringUtil.getFileFromInput(position))
                && isValidRank(StringUtil.getRankFromInput(position)) &&
        (board.isPositionEmpty(position) ||
                isDifferentColor(color, board.getPiece(position).getColor()));
    }

    private boolean isValidFile(char file){
        return file >= 97 && file < 105;
    }

    public boolean IsCapturing(String position, Piece.Color color){
        return !board.isPositionEmpty(position) && board.getPiece(position).getColor() != color;
    }

    private boolean isValidRank(int rank){
        return rank >= 0 && rank < 8;
    }

    private boolean isDifferentColor(Piece.Color color, Piece.Color color2){
        return color != color2;
    }




}
