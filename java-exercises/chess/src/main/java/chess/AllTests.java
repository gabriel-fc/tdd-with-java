package chess;

import chess.board.BoardTest;
import chess.pieces.PieceTest;
import chess.pieces.types.evaluationstrategy.PawnEvalStrategyTest;
import chess.pieces.types.evaluationstrategy.RegularEvalStrategyTest;
import chess.pieces.types.TypeTest;
import chess.pieces.types.movementstrategy.KingMovStrategyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({PieceTest.class,
        BoardTest.class, CharacterTest.class,
        PawnEvalStrategyTest.class, RegularEvalStrategyTest.class,
        TypeTest.class, KingMovStrategyTest.class})

public class AllTests {
}
