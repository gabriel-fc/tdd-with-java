package sis.report;

import sis.courseinfo.CourseSession;
import sis.studentinfo.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static sis.report.ReportConstant.*;

public class RosterReporter {
    private CourseSession session;
    private Writer writer;
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

    void writeReport(Writer writer) throws IOException {
        this.writer = writer;
        writeHeader();
        writeBody();
        writeFooter();
    }
    void writeReport(String fileName) throws IOException{
        Writer bufferedWriter =
                new BufferedWriter(new FileWriter(fileName));
        try {
            writeReport(bufferedWriter);
        }
        finally {
            bufferedWriter.close();
        }
    }

    private void writeHeader() throws IOException {
        writer.write(ROSTER_REPORT_HEADER);
    }
    private void writeBody() throws IOException {
        for (Student student: session.getAllStudents())
            writer.write(student.getName() + NEWLINE);
    }
    private void writeFooter() throws IOException {
        writer.write(
                ROSTER_REPORT_FOOTER + session.getAllStudents().size() +
                        NEWLINE);
    }

}
