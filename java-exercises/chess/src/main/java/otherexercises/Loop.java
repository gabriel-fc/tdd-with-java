package otherexercises;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Loop {
    public static int fatorialWithFor(int n){
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }
        return value;
    }

    public static int fatorialWithWhile(int n){
        int value = 1, count = 1;
        while(count <= n){
            value *= count;
            count++;
        }
        return value;
    }

    public static int fatorialWithDoWhile(int n){
        int value = 1, count = 1;
        do {
            value *= count;
            count++;
        }while (count <= n);
        return value;
    }

    public static int fatorialWithBreak(int n){
        int value = 1, count = 1;
        while (true){
            if(count > n) break;
            value *= count;
            count++;
        }
        return value;
    }

    public static String stringWithContinue(int n){
        StringBuilder output = new StringBuilder();
        for(int i = 1; i <= n; i++){
            output.append(i);
            if (i % 5 == 0) output.append('*');
            if (i == n) break;
            output.append(' ');
        }
        return output.toString();
    }

    public static Vector<String> vectorOfString(int n){
        String input = stringWithContinue(n);
        Vector<String> output = new Vector<>();
        for (String s: input.split(" ")) {
            output.add(s);
        }
        return output;

    }

    public static String stringOfVector(int n){
        Vector<String> input = vectorOfString(n);
        String output = "";
        for (Enumeration<String> num = input.elements(); num.hasMoreElements();) {
            output += num.nextElement();
            if(!num.hasMoreElements()) continue;
            output +=' ';
        }
        return output;
    }


}
