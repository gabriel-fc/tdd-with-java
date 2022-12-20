package chess.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    private final File file;
    private final String FILEPATH = "board-db";

    private final Path path;




    public FileHandler(){
        file = new File(FILEPATH);
        path = file.toPath();
    }


    public void createFile(){
        try {
            Files.createFile(path);
        }catch (IOException e){
            throw new RuntimeException("couldn't create file");
        }
    }

    public void deleteFile(){
        try {
            Files.delete(path);
        }catch (IOException e){
            throw new RuntimeException("couldn't delete file");
        }
    }


    public boolean write(String data){
        try{
            if(!file.exists()) createFile();
            Files.writeString(path, data);
            return true;
        }catch (IOException e){
            return false;
        }
    }


    public String read(){
        try{
            if(!file.exists()) createFile();
            return Files.readString(path);
        }catch (IOException e){
            throw new RuntimeException("couldn't read data");
        }
    }

}
