package chess.pieces.types;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;

public class Queen extends Piece{
    public Queen(Color color){
        super(color, 'q');
    }

    @Override
    public ArrayList<String> getPossibleMoves(String position){
        ArrayList<String> possibleMoves = new ArrayList();
        movements.moveInDirection(position, getColor(),
                 movements.new Forward(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new Backward(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new Right(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new Left(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new RightForward(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new LeftForward(), possibleMoves);

        movements.moveInDirection(position, getColor(), movements.new RightBackward(), possibleMoves);

        movements.moveInDirection(position, getColor(),
                 movements.new LeftBackward(), possibleMoves);

        Collections.sort(possibleMoves);
        return possibleMoves;
    }

    @Override
    public double getStrength(boolean isAloneInFile) {
        return 9.0;
    }

}
