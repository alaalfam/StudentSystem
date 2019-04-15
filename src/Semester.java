import java.util.LinkedList;

public class Semester {
    public LinkedList<Course> courseLink = new LinkedList<Course>();
    // har term shamele koli dars mishe.
    private int semesterNumber = 1 ;
    public void setSemesterNumber (int semesterNumber) {
        this.semesterNumber = semesterNumber ;
    }
    public int getSemesterNumber () {
        return this.semesterNumber ;
    }
}
