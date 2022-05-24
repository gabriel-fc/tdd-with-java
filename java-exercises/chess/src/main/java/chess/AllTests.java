package chess;

import chess.pieces.PieceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({PieceTest.class, BoardTest.class, CharacterTest.class})

public class AllTests {
}
