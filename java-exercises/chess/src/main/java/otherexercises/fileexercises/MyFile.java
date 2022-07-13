package otherexercises.fileexercises;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class MyFile {
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;

    public MyFile(String filename){
        this.file = new File(filename);
    }

    public String getFileAsString(){
        try {
            openReader();
            return reader.lines().collect(joining());
        }catch (IOException e) {
            throw new FileDoesNotExistException(e);
        }finally {
            closeReader();
        }
    }

    public void clear() throws IOException{
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("");
        }finally {
            closeWriter();
        }
    }

    public List<String> getFileAsStream(){
        try {
            openReader();
            return reader.lines().collect(Collectors.toList());
        }catch (IOException e){
            throw new FileDoesNotExistException(e);
        } finally {
            closeReader();
        }
    }

    private void closeReader(){
        try{
            reader.close();
        }catch (IOException e){
            throw new FileDoesNotExistException(e);
        }

    }
    private void openReader() throws IOException{
        reader = new BufferedReader(new FileReader(file));
    }
    private void openWriter() throws IOException{
        writer = new BufferedWriter(new FileWriter(file, true));
    }
    private void closeWriter(){
        try{
            writer.close();
        }catch (IOException e){
            throw new FileDoesNotExistException(e);
        }

    }

    public void writeString(String text){
        try {
            if(!file.exists()) throw new IOException();
            openWriter();
            writer.write(text + " ");
        }catch(IOException e){
            throw new FileDoesNotExistException(e);
        } finally {
            closeWriter();
        }
    }
    public void writeListOfStrings(List<String> list){
        for (String text: list) {
            writeString(text);
        }
    }
    public boolean deleteFile(){
        return file.delete();
    }

    public void recreate()throws IOException{
        file.createNewFile();
    }

    @Override
    public String toString() {
        return file.getName();
    }


}
