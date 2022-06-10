package chess.pieces.types;

import chess.pieces.Piece;

public class Pawn extends Piece {

    public Pawn(Color color){
        super(color, 'p');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return isAloneInFile ? 1.0 : 0.5;
    }
}
