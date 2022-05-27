package chess.pieces.types;

import chess.pieces.Piece;
import chess.pieces.types.evaluationstrategy.EvaluationStrategy;
import chess.pieces.types.evaluationstrategy.PawnEvaluationStrategy;
import chess.pieces.types.evaluationstrategy.RegularEvaluationStrategy;
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




}
