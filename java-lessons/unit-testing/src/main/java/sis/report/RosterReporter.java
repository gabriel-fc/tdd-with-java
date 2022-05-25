package sis.report;

import sis.courseinfo.CourseSession;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.*;

public class RosterReporter {
    private CourseSession session;
    public RosterReporter(CourseSession session){
        this.session = session;
    }

    public String getReport() {
        StringBuilder buffer = new StringBuilder();
        writeHeader(buffer);
        writeBody(buffer);
        writeFooter(buffer);
        return buffer.toString();
    }

    void writeHeader(StringBuilder buffer){
        buffer.append(ROSTER_REPORT_HEADER + NEWLINE);
    }

    void writeBody(StringBuilder buffer){
        for (Student student: session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }
    }

    void writeFooter(StringBuilder buffer) {
        buffer.append(
                ROSTER_REPORT_FOOTER + NEWLINE + session.getNumberOfStudents() + NEWLINE);
    }

}
