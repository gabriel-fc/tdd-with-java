package chess.pieces.types;

public class PawnEvaluationStrategy implements EvaluationStrategy{
    private double strengthAlone;
    private double strengthInCompany;

    PawnEvaluationStrategy(double strengthAlone, double strengthInCompany){
        this.strengthAlone = strengthAlone;
        this.strengthInCompany = strengthInCompany;
    }

    public double getStrength(boolean isAloneInFile){
        return isAloneInFile ? strengthAlone:strengthInCompany;
    }
}
