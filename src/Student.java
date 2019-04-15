import java.util.LinkedList;

public class Student {
    // tarife moshakhasate daneshjo.
    public LinkedList<Semester> arrSemester = new LinkedList<Semester>();
    private String studentNumber = "" ;
    private String firstName = "" ;
    private String lastName = "" ;
    private String major = "" ;
    private String year = "" ;
//	private int semester = arrSemester.size() ;
    // term haye har daneshjo to linkedlist zakhire mishe. va har term shamele koli dars mishe.

    // constructor baraye meghdar dehi avaliye har daneshjo.
    Student (String stNumber , String fName , String lName , String m , String y ) {
        this.studentNumber = stNumber ;
        this.firstName = fName ;
        this.lastName = lName ;
        this.major = m ;
        this.year = y ;
        this.arrSemester.add(new Semester());
//		this.semester = arrSemester.size() ;
    }
    // function haye setter baraye set kardane moshakhasat.
    public void setStudentNumber (String stNumber) {
        this.studentNumber = stNumber ;
    }
    public void setFirstName (String fName) {
        this.firstName = fName ;
    }
    public void setLastName (String lName) {
        this.lastName = lName ;
    }
    public void setMajor (String m) {
        this.major = m ;
    }
    public void setYear (String y) {
        this.year = y ;
    }
    public void setSemester (int s) {
//		this.semester = s ;
    }
    // function haye getter baraye gereftane moshakhasat.
    public String getStudentNumber () {
        return this.studentNumber;
    }
    public String getFirstName () {
        return this.firstName;
    }
    public String getLastName () {
        return this.lastName ;
    }
    public String getMajor () {
        return this.major;
    }
    public String getYear () {
        return this.year;
    }
    public int getSemester () {
        return this.arrSemester.size() ;
    }
}
