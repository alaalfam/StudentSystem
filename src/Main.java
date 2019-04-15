import java.io.FileNotFoundException;
import java.util.LinkedList;
import javax.swing.*;
public class Main {
    public static LinkedList<Student> link = new LinkedList<Student>();

    boolean isDelete = false ;

    private static Frame1 f;

    private static ReadFileStudentCourse readCourse;

    private static ReadFileStudent readStudent;

    private WriteFileStudentCourse writeCourse;

    private WriteFileStudentCourse writeCourse2;

    private WriteFileStudentCourse writeCourse3;

    private WriteFileStudentCourse writeCourse4;

    private WriteFileStudentCourse writeCourse5;

    private WriteFileStudentCourse writeCourse6;

    private WriteFileStudent writeStudent;

    private WriteFileStudent writeStudent2;

    public void loadTableCourse (String studentNumber , int numSemester , JTable tableCourse) throws FileNotFoundException {
        int J=0 ;
        for (int i=0 ; i<link.size() ; i++) {
            if (link.get(i).getStudentNumber().equals(studentNumber)) {
                if ( numSemester > link.get(i).arrSemester.size() ) {
                    insertSemester(studentNumber, numSemester);
                }

                if ( !link.get(i).arrSemester.get(numSemester-1).courseLink.isEmpty() ) {
                    J = link.get(i).arrSemester.get(numSemester-1).courseLink.size();
                    for (int j=0 ; j<link.get(i).arrSemester.get(numSemester-1).courseLink.size() ; j++) {
                        tableCourse.setValueAt(link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getCourseCode(), j+1, 0);
                        tableCourse.setValueAt(link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getCourseName(), j+1, 1);
                        tableCourse.setValueAt(link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getTestDate(), j+1, 2);
                        tableCourse.setValueAt(link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getDate(), j+1, 3);
                    }
                }
            }
        }
        tableCourse.setValueAt("", J+1, 0);
        tableCourse.setValueAt("", J+1, 1);
        tableCourse.setValueAt("", J+1, 2);
        tableCourse.setValueAt("", J+1, 3);

        tableCourse.repaint();
        tableCourse.revalidate();
        isDelete = false ;

    }

    public void loadTable (JTable table) {
        table.setValueAt("Student Number", 0, 0);
        table.setValueAt("First name", 0, 1);
        table.setValueAt("Last name", 0, 2);
        table.setValueAt("Major", 0, 3);
        table.setValueAt("Year", 0, 4);
        table.setValueAt("Semester", 0, 5);

        for (int i=0 ; i<link.size() ; i++) {
            table.setValueAt(link.get(i).getStudentNumber(), i+1, 0);
            table.setValueAt(link.get(i).getFirstName(), i+1, 1);
            table.setValueAt(link.get(i).getLastName(), i+1, 2);
            table.setValueAt(link.get(i).getMajor(), i+1, 3);
            table.setValueAt(link.get(i).getYear(), i+1, 4);
            table.setValueAt(link.get(i).arrSemester.size(), i+1, 5);
        }
    }

    public  boolean insertStudent(String stNumber , String fName , String lName , String m , String y) throws FileNotFoundException {
        if ( !link.isEmpty() ) {
            for (int i=0 ; i<link.size() ; i++) {
                if ( link.get(i).getStudentNumber().equals(stNumber) ) {
                    JOptionPane.showMessageDialog(null, "We have a student with this studentNumber. Please make with another stuedntNumber.");
                    return true;
                }
            }
        }
        Student objS = new Student(stNumber , fName , lName , m , y);
        link.add(objS);
        setWriteStudent2(new WriteFileStudent("D:\\java\\work space\\SystemStudentNew\\DataBase\\DataBaseStudent.txt"));

        return false ;
    }

    public void deleteStudent (String stNumber) throws FileNotFoundException {
        for (int i=0 ; i<link.size() ; i++) {
            if ( link.get(i).getStudentNumber().equals(stNumber) ) {
                link.remove(i) ;
                setWriteStudent(new WriteFileStudent(".\\DataBase\\DataBaseStudent.txt"));
                setWriteCourse6(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                return ;
            }
        }
        System.out.println("we have not any student with this student number.");

    }

    public void insertSemester (String stNumber , int numSemester) throws FileNotFoundException {
        if ( !link.isEmpty() ) {
            for (int i=0 ; i<link.size() ; i++) {
                if (link.get(i).getStudentNumber().equals(stNumber)) {
                    if (numSemester > link.get(i).arrSemester.size()) {
                        Semester objS = new Semester();
                        objS.setSemesterNumber(numSemester);
                        link.get(i).arrSemester.add(objS);
                        link.get(i).setSemester( link.get(i).arrSemester.size() );
                        setWriteCourse5(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                        return ;

                    }
                    else {
                        return ;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "dont find this student. Please add student with this student number first.");
            return ;
        }
        JOptionPane.showMessageDialog(null, "there is no student in StudenSystem. Please add one first.");
    }

    public void deleteSemester (String stNumber , int numSemester) throws FileNotFoundException {
        if ( !link.isEmpty() ) {
            for ( int i=0 ; i<link.size() ; i++ ) {
                if ( link.get(i).getStudentNumber().equals(stNumber) ) {
                    link.get(i).arrSemester.remove(numSemester-1) ;
                    setWriteCourse4(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                    return ;
                }
            }
            JOptionPane.showMessageDialog(null, "We have not any student with this student number. Please add one with this student number.");
            return ;
        }
        JOptionPane.showMessageDialog(null, "We have not any student. Please add one first.");
    }

    public boolean selectUnit ( String stNumber , int numSemester , String courseCode , String courseName , String testDate , String date ) throws FileNotFoundException {
        // false = add shod
        // true = add nashod.
        for ( int i=0 ; i<link.size() ; i++ ) {
            if ( link.get(i).getStudentNumber().equals(stNumber) ) {
                if ( link.get(i).arrSemester.isEmpty() ) {
                    insertSemester(stNumber , numSemester);
                }
                if ( !link.get(i).arrSemester.get(numSemester-1).courseLink.isEmpty() ) {
                    for (int j=0 ; j<link.get(i).arrSemester.get(numSemester-1).courseLink.size() ; j++) {
                        if ( link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getCourseCode().equals(courseCode) ) {
                            JOptionPane.showMessageDialog(null, "This course is repetitive");
                            return true ;
                        }
                    }
                    // agar  tekrari nabood.
                    Course lesson = new Course(courseCode, courseName, testDate, date);
                    link.get(i).arrSemester.get(numSemester-1).courseLink.add(lesson);
                    setWriteCourse3(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                    return false ;
                }
                else {
                    // agar khali bood. lesson bayad add beshe be courseLink
                    // course bayad add beshe be arrSemester.
                    Course lesson = new Course(courseCode, courseName, testDate, date);
                    link.get(i).arrSemester.get(numSemester-1).courseLink.add(lesson);
                    setWriteCourse2(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                    return false ;
                }
            }
        }
        return true ;
    }
    public void deleteCourse (String studentNumber , int numSemester , String courseCode) throws FileNotFoundException {
        boolean hasNotCourse = true ;
        for (int i=0 ; i<link.size() ; i++) {
            if (link.get(i).getStudentNumber().equals(studentNumber)) {
                for (int j=0 ; j<link.get(i).arrSemester.get(numSemester-1).courseLink.size() ; j++) {
                    if ( link.get(i).arrSemester.get(numSemester-1).courseLink.get(j).getCourseCode().equals(courseCode) ) {
                        hasNotCourse = false ;
                        link.get(i).arrSemester.get(numSemester-1).courseLink.remove(j);
                        setWriteCourse(new WriteFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
                    }
                }
                if (hasNotCourse) {
                    JOptionPane.showMessageDialog(null, "We have not any course with this code course.");
                }
            }
        }
        isDelete = true ;
    }

    public static void main(String[] args) throws FileNotFoundException {
        setReadStudent(new ReadFileStudent(".\\DataBase\\DataBaseStudent.txt"));
        setReadCourse(new ReadFileStudentCourse(".\\DataBase\\DataBaseStudentCourse.txt"));
        setF(new Frame1());
    }

    /**
     * @return the writeStudent2
     */
    public WriteFileStudent getWriteStudent2() {
        return writeStudent2;
    }

    /**
     * @param writeStudent2 the writeStudent2 to set
     */
    public void setWriteStudent2(WriteFileStudent writeStudent2) {
        this.writeStudent2 = writeStudent2;
    }

    /**
     * @return the writeStudent
     */
    public WriteFileStudent getWriteStudent() {
        return writeStudent;
    }

    /**
     * @param writeStudent the writeStudent to set
     */
    public void setWriteStudent(WriteFileStudent writeStudent) {
        this.writeStudent = writeStudent;
    }

    /**
     * @return the writeCourse6
     */
    public WriteFileStudentCourse getWriteCourse6() {
        return writeCourse6;
    }

    /**
     * @param writeCourse6 the writeCourse6 to set
     */
    public void setWriteCourse6(WriteFileStudentCourse writeCourse6) {
        this.writeCourse6 = writeCourse6;
    }

    /**
     * @return the writeCourse5
     */
    public WriteFileStudentCourse getWriteCourse5() {
        return writeCourse5;
    }

    /**
     * @param writeCourse5 the writeCourse5 to set
     */
    public void setWriteCourse5(WriteFileStudentCourse writeCourse5) {
        this.writeCourse5 = writeCourse5;
    }

    /**
     * @return the writeCourse4
     */
    public WriteFileStudentCourse getWriteCourse4() {
        return writeCourse4;
    }

    /**
     * @param writeCourse4 the writeCourse4 to set
     */
    public void setWriteCourse4(WriteFileStudentCourse writeCourse4) {
        this.writeCourse4 = writeCourse4;
    }

    /**
     * @return the writeCourse3
     */
    public WriteFileStudentCourse getWriteCourse3() {
        return writeCourse3;
    }

    /**
     * @param writeCourse3 the writeCourse3 to set
     */
    public void setWriteCourse3(WriteFileStudentCourse writeCourse3) {
        this.writeCourse3 = writeCourse3;
    }

    /**
     * @return the writeCourse2
     */
    public WriteFileStudentCourse getWriteCourse2() {
        return writeCourse2;
    }

    /**
     * @param writeCourse2 the writeCourse2 to set
     */
    public void setWriteCourse2(WriteFileStudentCourse writeCourse2) {
        this.writeCourse2 = writeCourse2;
    }

    /**
     * @return the writeCourse
     */
    public WriteFileStudentCourse getWriteCourse() {
        return writeCourse;
    }

    /**
     * @param writeCourse the writeCourse to set
     */
    public void setWriteCourse(WriteFileStudentCourse writeCourse) {
        this.writeCourse = writeCourse;
    }

    /**
     * @return the readStudent
     */
    public static ReadFileStudent getReadStudent() {
        return readStudent;
    }

    /**
     * @param readStudent the readStudent to set
     */
    public static void setReadStudent(ReadFileStudent readStudent) {
        Main.readStudent = readStudent;
    }

    /**
     * @return the readCourse
     */
    public static ReadFileStudentCourse getReadCourse() {
        return readCourse;
    }

    /**
     * @param readCourse the readCourse to set
     */
    public static void setReadCourse(ReadFileStudentCourse readCourse) {
        Main.readCourse = readCourse;
    }

    /**
     * @return the f
     */
    public static Frame1 getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public static void setF(Frame1 f) {
        Main.f = f;
    }

}