package sis.studentinfo;

public class HonorsGradingStrategy
        extends BasicGradingStrategy {

    public int getGradePointsFor(Student.Grade grade){
        int points = super.getGradePointsFor(grade);
        if(grade != Student.Grade.F) points += 1;
        return points;
    }
}
