package sis.studentinfo;

import java.util.ArrayList;
import java.util.IllegalFormatException;

public class StudentNameFormatException
        extends IllegalArgumentException{
    public StudentNameFormatException(String message){
        super(message);
    }
}