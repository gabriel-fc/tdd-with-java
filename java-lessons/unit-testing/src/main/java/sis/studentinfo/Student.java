package sis.studentinfo;

import java.util.ArrayList;
import java.util.Locale;

public class Student {
    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);
        private int points;
        Grade(int points) {
            this.points = points;
        }
        int getPoints() {
            return points;
        }
    }
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";

    private GradingStrategy gradingStrategy = new BasicGradingStrategy();


    private final String name;
    private int credits;

    private boolean isHonors = false;

    private ArrayList<Grade> grades;
    private double gpa;
    private String state;
    public Student(String name){
        this.name = name;
        this.credits = 0;
        this.state = "";
        this.grades = new ArrayList<>();
        this.gpa = 0;
    }

    public void addCredits(int credits){ this.credits += credits;}

    public int getCredits() {
        return credits;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return ("Name: " + this.name + "\n");
    }

    public boolean isFullTime(){
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public void setState(String state) {
        this.state = state.toUpperCase();
    }

    public String getState() {
        return state;
    }

    public boolean isInState(){
        return state.equals(Student.IN_STATE);
    }

    public void setHonors() {
        isHonors = true;
        setGradingStrategy(new HonorsGradingStrategy());
    }

    public double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade: grades) {
           total += gradingStrategy.getGradePointsFor(grade);
        }
        return total / grades.size();
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }


    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }




}
