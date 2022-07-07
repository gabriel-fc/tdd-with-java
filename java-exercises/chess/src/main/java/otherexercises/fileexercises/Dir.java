package otherexercises.fileexercises;

import java.io.File;
import java.util.ArrayList;

public class Dir {
    private File dir;
    private ArrayList<MyFile> files;

    public Dir(String dirPath){
        File f = new File(dirPath);
        if(f.exists() && !f.isDirectory()){
            throw new ExistsFileWithSameDirNameException();
        }
        this.dir = f;
    }

    public void ensureExists(){
        if (!dir.exists()) dir.mkdir();
    }

    public void setFiles(ArrayList<MyFile> files){
        this.files = files;
    }

    public ArrayList<MyFile> getFiles(){
        if (!dir.exists()) throw new DirDoesNotExistException();
        return files;
    }

}
