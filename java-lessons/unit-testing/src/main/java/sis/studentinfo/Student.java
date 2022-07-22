package sis.studentinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student implements Serializable {
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

    private String id = "";
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();


    private String name="";
    private String firstName = "";
    private String middleName = "";
    private String lastName ="";
    private int credits;

    private boolean isHonors = false;

    private ArrayList<Grade> grades;
    private double gpa;
    private String state;

    final static Logger logger =
            Logger.getLogger(Student.class.getName());

    public Student(String fullName) {
        this.name = fullName;
        credits = 0;
        this.grades = new ArrayList<>();
        List<String> nameParts = split(fullName);
        final int maximumNumberOfNameParts = 3;
        if (nameParts.size() > maximumNumberOfNameParts) {
            String message =
                    "Student name '" + fullName +
                            "' contains more than " + maximumNumberOfNameParts +
                            " parts";


            //Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }
    private String removeLast(List<String> list) {
        if (list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }
    private List<String> tokenize(String string) {
        List<String> results = new ArrayList<String>();
        StringBuffer word = new StringBuffer();
        int index = 0;
        while (index < string.length()) {
            char ch = string.charAt(index);
            if (ch != ' ') // prefer Character.isSpace. Defined yet?
                word.append(ch);
            else
            if (word.length() > 0) {
                results.add(word.toString());
                word = new StringBuffer();
            }
            index++;
        }
        if (word.length() > 0)
            results.add(word.toString());
        return results;
    }

    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();
        for (String name: fullName.split(" "))
            results.add(name);
        return results;
    }
    public void addCredits(int credits){ this.credits += credits;}
    public int getCredits() {
        return credits;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
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
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade: grades)
            total += gradingStrategy.getGradePointsFor(grade);
        double result = total / grades.size();
        Student.logger.fine("end getGpa " + System.currentTimeMillis());
        return result;
    }


    public void addGrade(Grade grade){
        grades.add(grade);
    }
    public void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Student findByLastName(String lastName) {
        return new Student(lastName);
    }

}
