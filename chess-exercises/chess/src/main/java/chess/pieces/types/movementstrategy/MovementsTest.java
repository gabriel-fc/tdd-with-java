package chess.pieces.types.movementstrategy;

import chess.game.Game;
import chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MovementsTest {
    private final Game game = new Game();

    @Before
    public void setUp(){
        game.start();
    }

    @Test
    public void BasicMovesTest(){

        //tests forward
        assertEquals("a2", (new
                Movements.Forward()).move("a1", Piece.Color.WHITE));

        assertEquals("a7", (new
                Movements.Forward()).move("a8", Piece.Color.BLACK));


        //tests backward
        assertEquals("a1", (new
                Movements.Backward()).move("a2", Piece.Color.WHITE));

        assertEquals("a8", (new
                Movements.Backward()).move("a7", Piece.Color.BLACK));


        //tests left
        assertEquals("a1", (new
                Movements.Left()).move("b1", Piece.Color.WHITE));

        assertEquals("b1", (new
                Movements.Left()).move("a1", Piece.Color.BLACK));


        //tests right
        assertEquals("b1", (new
                Movements.Right()).move("a1", Piece.Color.WHITE));

        assertEquals("a8", (new
                Movements.Right()).move("b8", Piece.Color.BLACK));



        //tests rightforward
        assertEquals("b3", (new
                Movements.RightForward()).move("a2", Piece.Color.WHITE));

        assertEquals("a6", (new
                Movements.RightForward()).move("b7", Piece.Color.BLACK));


        //tests leftforward
        assertEquals("a3", (new
                Movements.LeftForward()).move("b2", Piece.Color.WHITE));

        assertEquals("b5", (new
                Movements.LeftForward()).move("a6", Piece.Color.BLACK));

        //test rightbackward
        assertEquals("b3", (new
                Movements.RightBackward()).move("a4", Piece.Color.WHITE));

        assertEquals("a5", (new
                Movements.RightForward()).move("b6", Piece.Color.BLACK));

        //test leftbackward
        assertEquals("a2", (new
                Movements.LeftBackward()).move("b3", Piece.Color.WHITE));

        assertEquals("b7", (new
                Movements.LeftBackward()).move("a6", Piece.Color.BLACK));



    }


    @Test
    public void moveInDirection(){
        ArrayList<String> possibleMoves = new ArrayList<>();
        assertEquals("[a3, a4, a5, a6, a7, a8]", Movements.
                moveInDirection("a2", Piece.Color.WHITE, new
                        Movements.Forward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a6, a5, a4, a3, a2, a1]", Movements.
                moveInDirection("a7", Piece.Color.BLACK, new
                        Movements.Forward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a5, a4, a3, a2, a1]", Movements.
                moveInDirection("a6", Piece.Color.WHITE,  new
                        Movements.Backward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[a4, a5, a6, a7, a8]", Movements.
                moveInDirection("a3", Piece.Color.BLACK,  new
                        Movements.Backward(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[b3, c3, d3, e3, f3, g3, h3]", Movements.
                moveInDirection("a3", Piece.Color.WHITE,  new
                        Movements.Right(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[g3, f3, e3, d3, c3, b3, a3]", Movements.
                moveInDirection("h3", Piece.Color.BLACK,  new
                        Movements.Right(), possibleMoves).toString());


        possibleMoves = new ArrayList<>();
        assertEquals("[g3, f3, e3, d3, c3, b3, a3]", Movements.
                moveInDirection("h3", Piece.Color.WHITE,  new
                        Movements.Left(), possibleMoves).toString());

        possibleMoves = new ArrayList<>();
        assertEquals("[b3, c3, d3, e3, f3, g3, h3]", Movements.
                moveInDirection("a3", Piece.Color.BLACK,  new
                        Movements.Left(), possibleMoves).toString());
    }


}
