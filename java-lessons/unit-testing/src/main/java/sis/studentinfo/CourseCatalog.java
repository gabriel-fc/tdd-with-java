package sis.studentinfo;
import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.courseinfo.Session;

import java.util.*;
import java.io.*;
public class CourseCatalog {
    private List<Session> sessions =
            new ArrayList<Session>();
    public void add(Session session) {
        sessions.add(session);
    }
    public List<Session> getSessions() {
        return sessions;
    }
    public void clearAll() {
        sessions.clear();
    }
    public void store(String filename) throws IOException {
        ObjectOutputStream output = null;
        try {
            output =
                    new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(sessions);
        }
        finally {
            output.close();
        }
    }
    public void load(String filename)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(filename));
            sessions = (List<Session>)input.readObject();
        }
        finally {
            input.close();
        }
    }
// ...
}