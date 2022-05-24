package chess.pieces.types;

public class RegularEvaluationStrategy implements EvaluationStrategy{
    private double strength;

    RegularEvaluationStrategy(double strength){
        this.strength = strength;
    }

    public double getStrength(boolean isAloneInFile){
        return strength;
    }
}
