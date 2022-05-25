package chess.pieces.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypeTest {
    private final double DELTA = 0.05;


    @Test
    public void typeTest(){
        assertEquals(3, Type.BISHOP.getStrength(true), DELTA);
        assertEquals(9, Type.QUEEN.getStrength(true), DELTA);
        assertEquals(0, Type.KING.getStrength(true), DELTA);
        assertEquals(5, Type.ROOK.getStrength(true), DELTA);
        assertEquals(2.5, Type.KNIGHT.getStrength(true), DELTA);

    }

    @Test
    public void kingMovementTest(){
        assertEquals("a2", Type.KING.moveForward("a1"));
        assertEquals("a1", Type.KING.moveBackward("a2"));
        assertEquals("b2", Type.KING.moveRight("a2"));
        assertEquals("a2", Type.KING.moveLeft("b2"));

        assertEquals("a1", Type.KING.moveLeftBackward("b2"));
        assertEquals("b1", Type.KING.moveRightBackward("a2"));
        assertEquals("a2", Type.KING.moveLeftForward("b1"));
        assertEquals("b2", Type.KING.moveRightForward("a1"));

    }

}
