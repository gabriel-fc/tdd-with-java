package sis.courseinfo;

import java.io.Serializable;

public class Course implements Serializable {
    private String department;
    private String number;
    public Course(String department, String number) {
        this.department = department;
        this.number = number;
    }
    public String getDepartment() {
        return department;
    }
    public String getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object object){
        if (!(object instanceof Course)) return false;
        return object.getClass() == Course.class &&
                ((Course) object).getDepartment().equals(this.getDepartment()) &&
                ((Course)object).getNumber().equals(this.getNumber());
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int result = 7;
        result = result * hashMultiplier + department.hashCode();
        result = result * hashMultiplier + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.department + " " + this.number;
    }
}
