package chess.pieces.types;

import chess.pieces.Piece;

public class Rook extends Piece {

    public Rook(Color color){
        super(color, 'r');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 5.0;
    }
}
