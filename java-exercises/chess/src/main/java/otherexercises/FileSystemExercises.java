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
//        FileWriter writer = new FileWriter("file-q2.txt");
//        writer.write("a");
//        writer.close();
        FileWriter writer = new FileWriter("file-q2.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        String text = "a";
        int dif = 0, i;
        for (i = 1; dif < 5; i++) {
            //text = getStringX10(text);
            dif = getDifferenceOfEfficiency(i, writer, buffer);
        }
        System.out.println("Com texto de " + Math.pow(10, i) + " caracteres, o writer bufferizado foi " + dif +
                " vezes mais rápido");

    }

    public int getDifferenceOfEfficiency(int power, FileWriter writer, BufferedWriter buffer) throws IOException{

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < Math.pow(10, power); i++) {
            writer.write("a");
        }
        time1 = System.currentTimeMillis() - time1;
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < Math.pow(10, power); i++) {
            buffer.write("a");
        }
        time2 = System.currentTimeMillis() - time2;
        return time2 != 0 ? (int)(time1/time2) : 0;

    }
}

