package util;

public class StringUtil {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char[] FILES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};


    public static String buffer = "";

    public static String appendNewLine(String newString){
        return newString + NEWLINE;
    }

    public static char getFileFromInput(String io){
        return io.charAt(0);
    }

    public static int getRankFromInput(String io){
        return Character.getNumericValue(io.charAt(1)) - 1;
    }

    public static String setPosition(char file, int rank){
        return file + Integer.toString(rank+1);
    }

    private StringUtil(){}
}
