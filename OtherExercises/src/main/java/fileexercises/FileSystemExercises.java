package fileexercises;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

public class FileSystemExercises {
    @Test
    public void q1() throws IOException{
        String filePath = "file-system-exercise.txt";
        String text = "Create a test to write the text of this exercise to the file system. The test should read the " +
                "file back in and make assertions about the content. Ensure that you can run the test " +
                "multiple times and have it pass. Finally, make sure that there are no leftover files when the " +
                "test finishes, even if an exception is thrown.";
        BufferedWriter bufferIn = new BufferedWriter(new FileWriter(filePath));
        bufferIn.write(text);
        bufferIn.close();
        BufferedReader bufferOut = new BufferedReader(new FileReader(filePath));
        String output =   bufferOut.lines().collect(joining());
        assertEquals(text, output);
        new File(filePath).delete();
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
        new File("file-q2.txt").delete();
    }

    private long write(int power, Writer writer) throws IOException{
        long timeBeforeExec = System.currentTimeMillis();
        for (int i = 0; i < Math.pow(10, power); i++) {
            writer.write("a");
        }
        writer.flush();
        return System.currentTimeMillis() - timeBeforeExec;
    }

    public int getDifferenceOfEfficiency(int power) throws IOException{
        FileWriter writer = new FileWriter("file-q2.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        long timeWriter = write(power, writer);
        long timeBuffer = write(power, buffer);
        buffer.close();
        writer.close();
        return timeBuffer != 0 ? (int)(timeWriter/timeBuffer) : 0;
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
        myFile.deleteFile();
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
            String expected = stackTraceToString(e.getStackTrace());

            assertEquals(expected, byteArrayVersion(e.getStackTrace()));
            assertEquals(expected, bufferedByteArrayVersion(e.getStackTrace()));
            assertEquals(expected, charVersion(e.getStackTrace()));
            assertEquals(expected, bufferedCharVersion(e.getStackTrace()));
        }
    }

    private String stackTraceToString(StackTraceElement[] stack){
        return Arrays.stream(stack).
                map(StackTraceElement::toString).
                collect(joining("\n"));
    }

    private String charVersion(StackTraceElement[] stack) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputCharStream = new OutputStreamWriter(outputStream);
        outputCharStream.write(stackTraceToString(stack));
        outputCharStream.flush();
        InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray()));
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < outputStream.size(); i++) {
            outputString.append((char) input.read());
        }
        return outputString.toString();
    }

    private String bufferedCharVersion(StackTraceElement[] stack)throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(stackTraceToString(stack));
        bufferedWriter.flush();
        BufferedReader input = new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray()))
        );
        return input.lines().collect(joining("\n"));
    }

    private String byteArrayVersion(StackTraceElement[] stack) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StringBuilder output = new StringBuilder();

        for (char c: stackTraceToString(stack).toCharArray()) {
            outputStream.write(c);
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        for (int i = 0; i < outputStream.size(); i++) {
            output.append((char)inputStream.read());
        }
        outputStream.close();
        inputStream.close();
        return output.toString();
    }

    private String bufferedByteArrayVersion(StackTraceElement[] stack)throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedOutputStream buffer = new BufferedOutputStream(outputStream);
        StringBuilder output = new StringBuilder();

        for (char c: stackTraceToString(stack).toCharArray()) {
            buffer.write(c);
        }
        buffer.flush();
        BufferedInputStream inputStream = new BufferedInputStream(
                new ByteArrayInputStream(outputStream.toByteArray()
                ));
        for (int i = 0; i < outputStream.size(); i++) {
            output.append((char)inputStream.read());
        }
        return output.toString();
    }


    @Test
    public void q8(){
        //won't compile
        //Attributes att = new Attributes("file");
    }

    @Test
    public void q9(){
        //compiles because it's a static nested class
        Dir.Attributes att = new Dir.Attributes("file");
    }

    @Test
    public void q10() throws IOException{
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        out.writeChar('c');
        assertEquals(byteArray.size(), 2);
        byteArray.reset();
        out.writeLong(1);
        assertEquals(byteArray.size(), 8);
        byteArray.reset();
        out.writeInt(1);
        assertEquals(byteArray.size(), 4);
        byteArray.reset();
        out.writeDouble(1);
        assertEquals(byteArray.size(), 8);
        byteArray.reset();
        out.writeFloat(1);
        assertEquals(byteArray.size(), 4);
        byteArray.reset();
    }
}

