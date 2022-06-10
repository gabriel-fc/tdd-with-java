package sis.studentinfo;

public class Scorer {
    public int score(String input) {
        if(isValid(input)) return Integer.parseInt(input);
        return -1;
    }
    public boolean isValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
