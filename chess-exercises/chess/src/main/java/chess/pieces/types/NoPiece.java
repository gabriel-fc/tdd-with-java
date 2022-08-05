package chess.pieces.types;

import chess.pieces.Piece;

import java.util.ArrayList;

public class NoPiece extends Piece {
    public NoPiece(){
        super(Color.NONE, '.');
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        return null;
    }
}
