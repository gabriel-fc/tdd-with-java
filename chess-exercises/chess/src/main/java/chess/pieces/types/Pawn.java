package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Pawn extends Piece  {

    public Pawn(Color color){
        super(color, 'p');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return isAloneInFile ? 1.0 : 0.5;
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        ArrayList<String> possibleMoves = new ArrayList();
        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.Forward(), possibleMoves);
        Collections.sort(possibleMoves);
        return possibleMoves;
    }
}
