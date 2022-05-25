package chess;

import chess.board.BoardTest;
import chess.pieces.PieceTest;
import chess.pieces.types.PawnEvalStrategyTest;
import chess.pieces.types.RegularEvalStrategyTest;
import chess.pieces.types.TypeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({PieceTest.class,
        BoardTest.class, CharacterTest.class,
        PawnEvalStrategyTest.class, RegularEvalStrategyTest.class, TypeTest.class})

public class AllTests {
}
