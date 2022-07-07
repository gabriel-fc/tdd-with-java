package otherexercises.fileexercises;

public class DirDoesNotExistException extends RuntimeException{
    public DirDoesNotExistException(){
        super("Directory doesn't exist!");
    }
}
