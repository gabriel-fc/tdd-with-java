package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;
import java.util.Collections;

public class King extends Piece {



    public King(Color color){
        super(color, 'k');
    }


    @Override
    public ArrayList<String> getPossibleMoves(String position) {
        ArrayList<String> possibleMoves = new ArrayList();
        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.Forward(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.Backward(),possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.Right(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.Left(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.RightForward(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.LeftForward(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.RightBackward(), possibleMoves);

        Movements.moveOneSquareInDirection(position, super.getColor(),
                new Movements.LeftBackward(), possibleMoves);

        Collections.sort(possibleMoves);
        return possibleMoves;
    }

}
