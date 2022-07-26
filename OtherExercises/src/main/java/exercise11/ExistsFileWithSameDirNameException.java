package exercise11;

public class ExistsFileWithSameDirNameException extends RuntimeException{
    public ExistsFileWithSameDirNameException(){
    super("There is a file with the same given name!");
    }
}
