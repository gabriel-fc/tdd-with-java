package sis.courseinfo;

import sis.studentinfo.Student;

import java.util.*;

public class CourseSession extends Session{
//    private static int count;
//
//    private final ArrayList<Student> students;
//
//    private final String department;
//
//    private int credits;
//    private final String number;
//    private final Date startDate;
//    private Date endDate;
//
//    public static final String NEWLINE = System.getProperty("line.separator");
//
//    public int compareTo(CourseSession that){
//        int departmentsCompered = getDepartment().compareTo(that.getDepartment());
//        return departmentsCompered  != 0 ? departmentsCompered :
//                this.getNumber().compareTo(that.getNumber());
//
//    }
//
//    protected CourseSession(String department, String number, Date startDate){
//        students = new ArrayList<>();
//        this.department = department;
//        this.number = number;
//        //set date
//        this.startDate = startDate;
//        this.endDate = new DateUtil().setEndDate(startDate);
//    }
//
//    public static CourseSession create(String department, String number, Date startDate) {
//        CourseSession.incrementCount();
//        return new CourseSession(department, number, startDate);
//    }
//    public Student getStudent(int index) {
//        return students.get(index);
//    }
//
//    public int getNumberOfStudents() {
//        return students.size();
//    }
//    public void addStudent(String name){
//        Student newStudent = new Student(name);
//        newStudent.addCredits(credits);
//        this.students.add(newStudent);
//    }
//
//    public void addStudent(Student newStudent){
//        newStudent.addCredits(credits);
//        this.students.add(newStudent);
//    }
//
//    public boolean isEmpty() {return students.isEmpty();}
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public Date getEndDate() {
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.setTime(getStartDate());
//        final int daysInWeek = 7;
//        final int daysFromFridayToMonday = 3;
//        int numberOfDays =
//                getSessionLength() * daysInWeek - daysFromFridayToMonday;
//        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
//        return calendar.getTime();
//    }
//
//
//    public String getNumber() {
//        return number;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public ArrayList<Student> getAllStudents(){
//        return students;
//    }
//
//
//    @Override
//    public String toString() {
//        Iterator<Student> iter = students.iterator();
//        String output = "Number of students: " + students.size() +
//                NEWLINE + "Students:" + NEWLINE;
//        while(iter.hasNext()){
//            output += iter.next() + NEWLINE;
//        }
//        return output;
//    }
//    public static void resetCount() {
//        count = 0;
//    }
//
//    public static void incrementCount() { count++; }
//
//    public static int getCount() {return count; }
//
//    public int getCredits() {
//        return credits;
//    }
//
//    public void setNumberOfCredits(int credits) {
//        this.credits = credits;
//    }
//    protected int getSessionLength() {
//        return 16;
//    }

    private static int count;
    public static CourseSession create(
            String department,
            String number,
            Date startDate) {
        return new CourseSession(department, number, startDate);
    }
    protected CourseSession(
            String department, String number, Date startDate) {
        super(department, number, startDate);
        CourseSession.incrementCount();
    }
    static private void incrementCount() {
        ++count;
    }
    static void resetCount() {
        count = 0;
    }
    static int getCount() {
        return count;
    }
    protected int getSessionLength() {
        return 16;
    }
}