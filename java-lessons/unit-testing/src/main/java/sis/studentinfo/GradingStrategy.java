package sis.studentinfo;

interface GradingStrategy {
    public int getGradePointsFor(Student.Grade grade);
}
