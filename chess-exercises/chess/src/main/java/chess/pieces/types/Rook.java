package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<String> possibleMoves = new ArrayList<>();
        Movements.moveInDirection(position, super.getColor(), new Movements.Forward(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(), new Movements.Backward(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(), new Movements.Left(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(), new Movements.Right(), possibleMoves);
        Collections.sort(possibleMoves);
        return possibleMoves;
    }
}
