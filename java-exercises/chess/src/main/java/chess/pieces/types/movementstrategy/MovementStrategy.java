package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public abstract class MovementStrategy {
    public String moveForward(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition(file, ++rank);
    }

    public String moveBackward(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition(file, --rank);
    }

    public String moveRight(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition((char) (file + 1), rank);
    }

    public String moveLeft(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition((char) (file - 1), rank);
    }

    public String moveLeftForward(String currentPosition){
        return moveForward(moveLeft(currentPosition));
    }

    public String moveRightForward(String currentPosition){
        return moveForward(moveRight(currentPosition));
    }

    public String moveLeftBackward(String currentPosition){
        return moveBackward(moveLeft(currentPosition));
    }

    public String moveRightBackward(String currentPosition){
        return moveBackward(moveRight(currentPosition));
    }
    public abstract ArrayList<String> getPossibleMoves(String position, Piece.Color color, Game currentGame);
    
}
