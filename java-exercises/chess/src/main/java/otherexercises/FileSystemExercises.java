package otherexercises;

import org.junit.Test;

import java.io.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class FileSystemExercises {
    @Test
    public void q1() throws IOException{
        String text = "Create a test to write the text of this exercise to the file system. The test should read the " +
                "file back in and make assertions about the content. Ensure that you can run the test " +
                "multiple times and have it pass. Finally, make sure that there are no leftover files when the " +
                "test finishes, even if an exception is thrown.";
        BufferedWriter bufferIn = new BufferedWriter(new FileWriter("file-system-exercise.txt"));
        bufferIn.write(text);
        bufferIn.close();
        BufferedReader bufferOut = new BufferedReader(new FileReader("file-system-exercise.txt"));
        String output =   bufferOut.lines().collect(Collectors.joining());
        assertEquals(text, output);


    }

    @Test
    public void q2() throws IOException{
        FileWriter writer = new FileWriter("file-q2.text");
        writer.write("a");
        writer.close();
    }

    public void getDifferenceOfEfficiency(String input, ){
        long time1 = System.currentTimeMillis();

    }

    private String getStringX10(int power){
        String output = "";
        for (int i = 0; i < (int) Math.pow(10, power); i++) {
            output += 'a';
        }
        return output;
    }
}
