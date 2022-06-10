package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Color color){
        super(color, 'b');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 3.0;
    }

//    @Override
//    public ArrayList<String> getPossibleMoves(String position) {
//        ArrayList<String> possibleMoves = new ArrayList<>();
//        possibleMoves.add(diagonalLeftAndForward(position));
//
//    }

    private String diagonalLeftAndForward(String position){
        return movements.new Forward().move(movements.new
                LeftForward().move(position, super.getColor()), super.getColor());
    }
}
