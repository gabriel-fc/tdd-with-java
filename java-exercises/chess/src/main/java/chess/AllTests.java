package chess;

import chess.board.BoardTest;
import chess.game.GameTest;
import chess.pieces.PieceTest;

import chess.pieces.types.TypeTest;
import chess.pieces.types.movementstrategy.MovementsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({PieceTest.class,
        BoardTest.class, CharacterTest.class,
        TypeTest.class, MovementsTest.class, GameTest.class})

public class  AllTests {
}
