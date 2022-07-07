package otherexercises.fileexercises;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

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
        String output =   bufferOut.lines().collect(joining());
        assertEquals(text, output);
    }

    @Test
    public void q2() throws IOException{
        FileWriter writer = new FileWriter("file-q2.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        int dif = 0, i;
        for (i = 1; dif < 5; i++) {
            dif = getDifferenceOfEfficiency(i, writer, buffer);
        }
        System.out.println("Com texto de " + (int)Math.pow(10, i) + " caracteres, o writer bufferizado foi " + dif +
                " vezes mais rápido");
        writer.close();
    }

    private void write(int power, Writer writer) throws IOException{
        for (int i = 0; i < Math.pow(10, power); i++) {
            writer.write("a");
        }
    }

    public int getDifferenceOfEfficiency(int power, FileWriter writer, BufferedWriter buffer) throws IOException{

        long time1 = System.currentTimeMillis();
        write(power, writer);
        time1 = System.currentTimeMillis() - time1;
        long time2 = System.currentTimeMillis();
        write(power, buffer);
        time2 = System.currentTimeMillis() - time2;
        return time2 != 0 ? (int)(time1/time2) : 0;
    }


    @Test
    public void q3() throws IOException{
        MyFile myFile = new MyFile("file-q3.txt");
        myFile.clear();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("joao", "maria", "lucas", "claudia"));
        myFile.writeString("carlos");
        assertEquals("carlos ", myFile.getFileAsString());
        myFile.writeListOfStrings(input);
        assertEquals("carlos " + input.stream().collect(joining(" ")) + " ",
                myFile.getFileAsString());
        try {
            myFile.deleteFile();
            myFile.writeString("carlos");
            fail("should've thrown an exception");
        }catch (FileDoesNotExistException e){
            myFile.recreate();
        }
    }

    @Test
    public void q4() {
        String dirPath = "q4-dir";
        Dir dir = new Dir(dirPath);
        new File(dirPath).delete();
        dir.ensureExists();
        assertTrue(new File(dirPath).exists());
        new File(dirPath).delete();
        try{
            dir.getFiles();
            fail("should've thrown an exception");
        }catch (DirDoesNotExistException e){
            dir.ensureExists();
        }
        ArrayList<MyFile> files = new ArrayList<>(Arrays.asList(new MyFile("arq1"),
                new MyFile("arq2"), new MyFile("arq3")));
        dir.setFiles(files);
        assertEquals(dir.getFiles(), files);

    }
}

