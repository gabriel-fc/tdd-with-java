package exercise11;

import java.io.File;
import java.util.ArrayList;

public class Dir {

    private Attributes attributes;
    public Dir(String dirPath){
        attributes = new Attributes(dirPath);
        if (attributes.isDirectory())
            throw new ExistsFileWithSameDirNameException();
    }

    public void ensureExists(){
        if (!attributes.exists()) attributes.create();
    }

    public void setFiles(ArrayList<MyFile> files){
        attributes.setFiles(files);
    }

    public ArrayList<MyFile> getFiles(){
        return attributes.getFiles();
    }

    public static class Attributes{
        private File dir;
        private ArrayList<MyFile> files;
        protected Attributes(String dirPath){
            this.dir = new File(dirPath);
            dir.deleteOnExit();
        }

        protected void setFiles(ArrayList<MyFile> files){
            this.files = files;
        }

        protected boolean isDirectory(){
            return dir.isDirectory();
        }

        protected boolean exists(){
            return dir.exists();
        }

        protected boolean create() {
            return dir.mkdir();
        }

        public ArrayList<MyFile> getFiles() {
            if (!exists()) throw new DirDoesNotExistException();
            return files;
        }
    }

}
