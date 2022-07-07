package otherexercises.fileexercises;

public class ExistsFileWithSameDirNameException extends RuntimeException{
    public ExistsFileWithSameDirNameException(){
    super("There is a file with the same given name!");
    }
}
