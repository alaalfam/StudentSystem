
public class Course {
    // moshakhasate hat dars ine.
    private String courseName = "" ;
    private String courseCode = "" ;
    private String testDate = "" ;
    private String date = "" ;

    Course ( String courseCode , String courseName , String testDate , String date ) {
        this.courseCode = courseCode ;
        this.courseName = courseName ;
        this.testDate = testDate ;
        this.date = date ;
    }
    // function haye setter baraye set kardane moshakhasat.
    public void setCourseName ( String courseName ) {
        this.courseName = courseName ;
    }
    public void setCourseCode ( String courseCode ) {
        this.courseCode = courseCode ;
    }
    public void setTestDate ( String testDate ) {
        this.testDate = testDate ;
    }
    public void setDate ( String date ) {
        this.date = date ;
    }

    // functino haye getter baraye get kardane moshakhasat.
    public String getCourseName () {
        return this.courseName ;
    }
    public String getCourseCode () {
        return this.courseCode ;
    }
    public String getTestDate () {
        return this.testDate ;
    }
    public String getDate () {
        return this.date ;
    }



}
