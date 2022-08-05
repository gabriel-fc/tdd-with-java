package chess.pieces.types;

import chess.pieces.Piece;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Color color){
        super(color, 'n');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 2.5;
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        return null;
    }
}
