package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;

import java.util.ArrayList;

public class KingMovementStrategy extends MovementStrategy{

    public ArrayList<String> getPossibleMoves(String position, Piece.Color color, Game currentGame){
        ArrayList<String> possibleMoves = new ArrayList();

        if(currentGame.isValidMovement(moveForward(position), color))
            possibleMoves.add(moveForward(position));

        if(currentGame.isValidMovement(moveBackward(position), color))
            possibleMoves.add(moveBackward(position));

        if(currentGame.isValidMovement(moveLeft(position), color))
            possibleMoves.add(moveLeft(position));

        if(currentGame.isValidMovement(moveRight(position), color))
            possibleMoves.add(moveRight(position));

        if(currentGame.isValidMovement(moveRightForward(position), color))
            possibleMoves.add(moveRightForward(position));

        if(currentGame.isValidMovement(moveLeftForward(position), color))
            possibleMoves.add(moveLeftForward(position));

        if(currentGame.isValidMovement(moveRightBackward(position), color))
            possibleMoves.add(moveRightBackward(position));

        if(currentGame.isValidMovement(moveLeftBackward(position), color))
            possibleMoves.add(moveLeftBackward(position));

        return possibleMoves;
    }
}
