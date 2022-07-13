package chess.pieces.types.movementstrategy;

import chess.board.Board;
import chess.pieces.Piece;
import chess.util.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;

public class Movements implements Serializable {


    public String moveOneSquareInDirection(String currentPosition, Piece.Color color,
                                           MoveStrategy direction, ArrayList<String> possibleMoves){
        String nextPosition = direction.move(currentPosition, color);
        if (Board.isValidPosition(nextPosition)){
            possibleMoves.add(nextPosition);
            return nextPosition;
        }
        return null;
    }


    private static String execute(String currentPosition, Piece.Color color, int rankMove,
                                  int fileMove, MoveStrategy oppositeMove){
        int rank = StringUtil.getRankFromInput(currentPosition);
        int file = StringUtil.getFileFromInput(currentPosition);
        if(color == Piece.Color.BLACK)
            return oppositeMove.move(currentPosition, Piece.Color.WHITE);
        return StringUtil.setPosition(file + fileMove, rank + rankMove);
    }

    public ArrayList<String> moveInDirection(String currentPosition, Piece.Color color,
                                             MoveStrategy direction, ArrayList<String> possibleMoves){

        String nextPosition = moveOneSquareInDirection(currentPosition, color, direction, possibleMoves);

        if(nextPosition != null) moveInDirection(nextPosition, color, direction, possibleMoves);

        return possibleMoves;
    }

    public static class Forward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, 0, new Backward()));
        }

    }

    public static class Backward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, 0, new Forward()));
        }
    }

    public static class Right implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 0, 1, new Left()));
        }

    }

    public static class Left implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 0, -1, new Right()));
        }
    }

    public static class LeftForward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, -1,
                    new RightBackward()));
        }
    }

    public static class RightForward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, 1,
                    new LeftBackward()));
        }
    }

    public static class LeftBackward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, -1,
                    new RightForward()));
        }
    }

    public static class RightBackward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, 1,
                    new LeftForward()));
        }
    }

    public interface MoveStrategy {
        public String move(String currentPosition, Piece.Color color);
    }


}
