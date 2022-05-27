package chess.pieces.types.evaluationstrategy;

import chess.pieces.types.evaluationstrategy.EvaluationStrategy;

public class PawnEvaluationStrategy implements EvaluationStrategy {
    private double strengthAlone;
    private double strengthInCompany;

    public PawnEvaluationStrategy(double strengthAlone, double strengthInCompany){
        this.strengthAlone = strengthAlone;
        this.strengthInCompany = strengthInCompany;
    }

    public double getStrength(boolean isAloneInFile){
        return isAloneInFile ? strengthAlone:strengthInCompany;
    }
}
