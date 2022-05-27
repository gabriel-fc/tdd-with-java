package chess.pieces.types.evaluationstrategy;

import chess.pieces.types.evaluationstrategy.EvaluationStrategy;

public class RegularEvaluationStrategy implements EvaluationStrategy {
    private double strength;

    public RegularEvaluationStrategy(double strength){
        this.strength = strength;
    }

    public double getStrength(boolean isAloneInFile){
        return strength;
    }
}
