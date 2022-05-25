package chess.game;

import chess.board.Board;
import chess.pieces.Piece;
import util.StringUtil;

public class Game {

    public static boolean isValidMovement(String position, Piece.Color color, Board board){
        return isValidFile(StringUtil.getFileFromInput(position))
                && isValidRank(StringUtil.getRankFromInput(position)) &&
        (board.isPositionEmpty(position) ||
                isDifferentColor(color, board.getPiece(position)));
    }

    private static boolean isValidFile(char file){
        return file >= 97 && file < 105;
    }

    private static boolean isValidRank(int rank){
        return rank >= 0 && rank < 8;
    }

    private static boolean isDifferentColor(Piece.Color color, Piece piece){
        return color != piece.getColor();
    }




}
