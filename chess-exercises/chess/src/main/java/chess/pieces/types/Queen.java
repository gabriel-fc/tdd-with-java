package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;
import java.util.Collections;

public class Queen extends Piece{
    public Queen(Color color){
        super(color, 'q');
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position){
        ArrayList<String> possibleMoves = new ArrayList<>();
        Movements.moveInDirection(position, getColor(),
                 new Movements.Forward(), possibleMoves);

        Movements.moveInDirection(position, getColor(),
                 new Movements.Backward(), possibleMoves);

        Movements.moveInDirection(position, getColor(),
                 new Movements.Right(), possibleMoves);

        Movements.moveInDirection(position, getColor(),
                 new Movements.Left(), possibleMoves);

        Movements.moveInDirection(position, getColor(),
                 new Movements.RightForward(), possibleMoves);

        Movements.moveInDirection(position, getColor(),
                 new Movements.LeftForward(), possibleMoves);

        movements.moveInDirection(position, getColor(), new Movements.RightBackward(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 new Movements.LeftBackward(), possibleMoves);

        Collections.sort(possibleMoves);
        return possibleMoves;
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 9.0;
    }

}
