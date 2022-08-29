package exercise14;

public class InvalidOperationOverEmptyRingException extends RuntimeException{
    public InvalidOperationOverEmptyRingException(){
        super("this operation is invalid for an empty ring");
    }
}
