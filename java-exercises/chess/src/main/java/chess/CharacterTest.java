package chess;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
