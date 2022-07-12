package otherexercises.fileexercises;

import chess.pieces.Piece;
import chess.pieces.types.Pawn;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        int dif = 0, i;
        for (i = 1; dif < 5; i++) {
            dif = getDifferenceOfEfficiency(i);
        }
        System.out.println("Com texto de "
                + (int)Math.pow(10, i)
                + " caracteres, " +
                "o writer bufferizado foi " + dif +
                " vezes mais rápido");
    }

    private void write(int power, Writer writer) throws IOException{
        for (int i = 0; i < Math.pow(10, power); i++) {
            writer.write("a");
        }
        writer.flush();
    }

    public int getDifferenceOfEfficiency(int power) throws IOException{
        FileWriter writer = new FileWriter("file-q2.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        long time1 = System.currentTimeMillis();
        write(power, writer);
        time1 = System.currentTimeMillis() - time1;
        long time2 = System.currentTimeMillis();
        write(power, buffer);
        time2 = System.currentTimeMillis() - time2;
        writer.close();
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


    /*
    Code a test that shows the use of a ByteArrayOutputStream to capture an exception and
    dump the stack trace into a string. Code it with and without an OutputStreamWriter. In both
    the character version and the byte version, use buffered readers and writers.
     */
    @Test
    public void q5()throws IOException{
        try{
            throw new RuntimeException();
        }catch (RuntimeException e){
            byteVersion(e.getStackTrace());
            charVersion(e.getStackTrace());
        }
    }
    private void charVersion(StackTraceElement[] stack) throws IOException{
        OutputStreamWriter outputStream = new OutputStreamWriter(new ByteArrayOutputStream());
        BufferedWriter buffer = new BufferedWriter(outputStream);

        long time = System.currentTimeMillis();
        outputStream.write(Arrays.stream(stack)
                .map(StackTraceElement::toString)
                .collect(joining("\n")));
        outputStream.flush();
        System.out.println("exec time with writer: " + (System.currentTimeMillis() - time));
        buffer.write(Arrays.stream(stack)
                .map(StackTraceElement::toString)
                .collect(joining("\n")));

        buffer.flush();

        System.out.println("exec time with buffered writer: " + (System.currentTimeMillis() - time));
    }

    private void byteVersion(StackTraceElement[] stack) throws IOException{

        OutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream buffer = new BufferedOutputStream(outputStream);

        long time = System.currentTimeMillis();
        for (StackTraceElement el: stack) {
            for (int i = 0; i < el.toString().length(); i++) {
                outputStream.write(el.toString().charAt(i));
            }
            outputStream.write('\n');
        }
        System.out.println("exec time with ByteArray: " + (System.currentTimeMillis() - time));
        buffer.write(Arrays.stream(stack)
                .map(StackTraceElement::toString)
                .collect(joining("\n"))
                .getBytes(StandardCharsets.UTF_8));

        buffer.flush();

        System.out.println("exec time with buffered bytearray: " + (System.currentTimeMillis() - time));
    }
//    @Test
//    public void q6() throws IOException {
//        //BufferedWriter buffer = new BufferedWriter(new ObjectOutputStream("file-q6"));
//        ObjectOutputStream buffer =new ObjectOutputStream(new FileOutputStream("file-q6"));
//        buffer.writeObject();
//    }
}

