package sis.studentinfo;

import java.io.Serializable;

public class HonorsGradingStrategy
        extends BasicGradingStrategy implements Serializable {

    public int getGradePointsFor(Student.Grade grade){
        int points = super.getGradePointsFor(grade);
        if(grade != Student.Grade.F) points += 1;
        return points;
    }
}
