package chess.pieces.types;

import chess.pieces.Piece;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color){
        super(color, 'r');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 5.0;
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        return null;
    }
}
