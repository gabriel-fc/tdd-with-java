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

    public static int getFileFromInput(String io){
        return io.charAt(0) - 97;
    }

    public static int getRankFromInput(String io){
        return 8 - Character.getNumericValue(io.charAt(1));
    }

    public static String setPosition(int file, int rank){
        return (char)(97+file) + Integer.toString(8 - rank);
    }

    private StringUtil(){}
}
