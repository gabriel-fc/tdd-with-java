package otherexercises.fileexercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MyFile {
    private File file;
    private BufferedReader buffer;

    public MyFile(String filename) throws IOException {
        this.file = new File(filename);
        this.buffer = new BufferedReader(new FileReader(file));
    }

    public String getFileAsString() throws IOException{
        return buffer.lines().collect(Collectors.joining());
    }

    public List<String> getFileAsStream() throws IOException{
        return buffer.lines().collect(Collectors.toList());
    }
}
