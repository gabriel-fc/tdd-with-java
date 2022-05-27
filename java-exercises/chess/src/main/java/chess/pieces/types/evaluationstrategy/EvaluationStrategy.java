package chess.pieces.types.evaluationstrategy;

public interface EvaluationStrategy {
    public double getStrength(boolean isAloneInFile);
}
