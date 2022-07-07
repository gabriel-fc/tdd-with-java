package otherexercises.fileexercises;

public class FileDoesNotExistException extends RuntimeException{

    public FileDoesNotExistException(){
        super("tried to open a non-existing file");
    }
    public FileDoesNotExistException(Exception cause){
        super("tried to open a non-existing file", cause);
    }

}
