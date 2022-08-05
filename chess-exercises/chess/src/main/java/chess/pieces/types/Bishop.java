package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;
import java.util.Collections;

public class Bishop extends Piece {
    public Bishop(Color color){
        super(color, 'b');
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 3.0;
    }


    private String diagonalLeftAndForward(String position){
        return new Movements.Forward().move(new
                Movements.LeftForward().move(position, super.getColor()), super.getColor());
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        ArrayList<String> possibleMoves = new ArrayList<>();
        Movements.moveInDirection(position, super.getColor(),
                new Movements.LeftForward(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(),
                new Movements.RightForward(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(),
                new Movements.LeftBackward(), possibleMoves);
        Movements.moveInDirection(position, super.getColor(),
                new Movements.RightBackward(), possibleMoves);
        Collections.sort(possibleMoves);
        return possibleMoves;
    }
}
