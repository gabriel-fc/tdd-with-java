package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;

import java.util.ArrayList;

public class QueenMovementStrategy extends MovementStrategy{

    @Override
    public ArrayList<String> getPossibleMoves(String position, Piece.Color color, Game currentGame) {
        return null;
    }


    protected ArrayList<String> possibleUpMoves(String position, Piece.Color color, Game currentGame){
        ArrayList<String> possibleMoves = new ArrayList<>();
        String moveForward = moveForward(position);

        if(currentGame.isValidMovement(moveForward, color)) {
            possibleMoves.add(moveForward);
            if(!currentGame.IsCapturing(position, color))
                possibleMoves.addAll(possibleUpMoves(moveForward, color, currentGame));
            return possibleMoves;
        }

        return new ArrayList<>();
    }
}
