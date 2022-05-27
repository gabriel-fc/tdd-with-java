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



}
