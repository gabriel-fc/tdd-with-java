package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;
import chess.pieces.types.movementstrategy.Movements;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MovementsTest {
    private Movements movements = new Movements();
    private final Game game = new Game();

    @Before
    public void setUp(){
        game.start();
    }

    @Test
    public void BasicMovesTest(){

        //tests forward
        assertEquals("a2", (movements.new
                Forward()).move("a1", Piece.Color.WHITE));

        assertEquals("a7", (movements.new
                Forward()).move("a8", Piece.Color.BLACK));


        //tests backward
        assertEquals("a1", (movements.new
                Backward()).move("a2", Piece.Color.WHITE));

        assertEquals("a8", (movements.new
                Backward()).move("a7", Piece.Color.BLACK));


        //tests left
        assertEquals("a1", (movements.new
                Left()).move("b1", Piece.Color.WHITE));

        assertEquals("b1", (movements.new
                Left()).move("a1", Piece.Color.BLACK));


        //tests right
        assertEquals("b1", (movements.new
                Right()).move("a1", Piece.Color.WHITE));

        assertEquals("a8", (movements.new
                Right()).move("b8", Piece.Color.BLACK));



        //tests rightforward
        assertEquals("b3", (movements.new
                RightForward()).move("a2", Piece.Color.WHITE));

        assertEquals("a6", (movements.new
                RightForward()).move("b7", Piece.Color.BLACK));


        //tests leftforward
        assertEquals("a3", (movements.new
                LeftForward()).move("b2", Piece.Color.WHITE));

        assertEquals("b5", (movements.new
                LeftForward()).move("a6", Piece.Color.BLACK));

        //test rightbackward
        assertEquals("b3", (movements.new
                RightBackward()).move("a4", Piece.Color.WHITE));

        assertEquals("a5", (movements.new
                RightForward()).move("b6", Piece.Color.BLACK));

        //test leftbackward
        assertEquals("a2", (movements.new
                LeftBackward()).move("b3", Piece.Color.WHITE));

        assertEquals("b7", (movements.new
                LeftBackward()).move("a6", Piece.Color.BLACK));



    }


    @Test
    public void moveInDirection(){
        ArrayList<String> possibleMoves = new ArrayList<>();
        assertEquals("[a3, a4, a5, a6, a7, a8]", movements.
                moveInDirection("a2", Piece.Color.WHITE, movements.new
                        Forward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a6, a5, a4, a3, a2, a1]", movements.
                moveInDirection("a7", Piece.Color.BLACK, movements.new
                        Forward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a5, a4, a3, a2, a1]", movements.
                moveInDirection("a6", Piece.Color.WHITE,  movements.new
                        Backward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a4, a5, a6, a7, a8]", movements.
                moveInDirection("a3", Piece.Color.BLACK,  movements.new
                        Backward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[b3, c3, d3, e3, f3, g3, h3]", movements.
                moveInDirection("a3", Piece.Color.WHITE,  movements.new
                        Right(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[g3, f3, e3, d3, c3, b3, a3]", movements.
                moveInDirection("h3", Piece.Color.BLACK,  movements.new
                        Right(), possibleMoves).toString());


        possibleMoves = new ArrayList<>();
        assertEquals("[g3, f3, e3, d3, c3, b3, a3]", movements.
                moveInDirection("h3", Piece.Color.WHITE,  movements.new
                        Left(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[b3, c3, d3, e3, f3, g3, h3]", movements.
                moveInDirection("a3", Piece.Color.BLACK,  movements.new
                        Left(), possibleMoves).toString());
    }


}
