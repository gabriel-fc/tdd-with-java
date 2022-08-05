package chess.pieces.types;

import chess.pieces.Piece;

import java.io.Serializable;
import java.util.ArrayList;

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
        return null;
    }
}
