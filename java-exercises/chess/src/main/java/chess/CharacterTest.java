package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterTest {
    @Test
    public void characterTest(){

    }

    @Test
    public void testWhiteSpace(){
        assertTrue(Character.isWhitespace('\u001F'));
        assertTrue(Character.isWhitespace('\f'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\r'));
    }

    @Test
    public void testValidCharIdentifier() {
        assertFalse(Character.isUnicodeIdentifierStart('6'));
        assertFalse(Character.isJavaIdentifierPart('^'));

    }
}
