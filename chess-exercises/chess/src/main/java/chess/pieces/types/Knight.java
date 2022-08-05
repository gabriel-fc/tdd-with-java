package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

        ArrayList<String> possibleMoves = new ArrayList<>();

        Movements.moveInL(position, super.getColor(),
                new Movements.LeftForward(),
                new Movements.Forward(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.LeftForward(),
                new Movements.Left(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.RightForward(),
                new Movements.Forward(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.RightForward(),
                new Movements.Right(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.LeftBackward(),
                new Movements.Backward(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.LeftBackward(),
                new Movements.Left(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.RightBackward(),
                new Movements.Backward(), possibleMoves);

        Movements.moveInL(position, super.getColor(),
                new Movements.RightBackward(),
                new Movements.Right(), possibleMoves);

        Collections.sort(possibleMoves);
        return possibleMoves;
    }

}
