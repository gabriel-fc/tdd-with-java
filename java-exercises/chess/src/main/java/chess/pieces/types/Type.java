package chess.pieces.types;

import chess.pieces.Piece;
import util.StringUtil;



public enum Type {
    PAWN('p', new PawnEvaluationStrategy(1.0, 0.5)),
    QUEEN('q', new RegularEvaluationStrategy(9)),
    BISHOP('b', new RegularEvaluationStrategy(3)),
    KNIGHT('n', new RegularEvaluationStrategy(2.5)),
    KING('k', new RegularEvaluationStrategy(0)),
    ROOK('r', new RegularEvaluationStrategy(5)),
    NO_PIECE('.', new RegularEvaluationStrategy(0));

    private final char representation;

    private EvaluationStrategy evaluationStrategy;

    private Type(char rep, EvaluationStrategy eval){
        this.representation = rep;
        this.evaluationStrategy = eval;
    }

    public char getRepresentation(Piece.Color color){
        return color == Piece.Color.BLACK ? Character.toUpperCase(representation) : representation;
    }

    public double getStrength(boolean isAloneInFile){
        return evaluationStrategy.getStrength(isAloneInFile);
    }

    public String moveForward(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition(file, ++rank);
    }

    public String moveBackward(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition(file, --rank);
    }

    public String moveRight(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition((char) (file + 1), rank);
    }

    public String moveLeft(String currentPosition){
        int rank = StringUtil.getRankFromInput(currentPosition);
        char file = StringUtil.getFileFromInput(currentPosition);
        return StringUtil.setPosition((char) (file - 1), rank);
    }

    public String moveLeftForward(String currentPosition){
        return moveForward(moveLeft(currentPosition));
    }

    public String moveRightForward(String currentPosition){
        return moveForward(moveRight(currentPosition));
    }

    public String moveLeftBackward(String currentPosition){
        return moveBackward(moveLeft(currentPosition));
    }

    public String moveRightBackward(String currentPosition){
        return moveBackward(moveRight(currentPosition));
    }
}
