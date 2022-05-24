package chess.pieces.types;

public interface EvaluationStrategy {
    public double getStrength(boolean isAloneInFile);
}
