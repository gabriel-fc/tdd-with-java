package chess.pieces.types.movementstrategy;

import chess.board.Board;
import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public class Movements {


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

    public class Forward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, 0, new Backward()));
        }

    }

    public class Backward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, 0, new Forward()));
        }
    }

    public class Right implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 0, 1, new Left()));
        }

    }

    public class Left implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 0, -1, new Right()));
        }
    }

    public class LeftForward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, -1,
                    new RightBackward()));
        }
    }

    public class RightForward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, -1, 1,
                    new LeftBackward()));
        }
    }

    public class LeftBackward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, -1,
                    new RightForward()));
        }
    }

    public class RightBackward implements MoveStrategy{
        public String move(String currentPosition, Piece.Color color){
            return (Movements.execute(currentPosition, color, 1, 1,
                    new LeftForward()));
        }
    }

    public static interface MoveStrategy {
        public String move(String currentPosition, Piece.Color color);
    }


}
