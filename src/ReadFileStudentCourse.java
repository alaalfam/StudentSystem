import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ReadFileStudentCourse {
    File file ;
    public ReadFileStudentCourse( String fileAddress ) throws FileNotFoundException {
        // TODO Auto-generated constructor stub
        file = new File(fileAddress);
        Scanner scan = new Scanner(file);

        for ( ; scan.hasNextLine() ;) {
            String number = scan.nextLine();
            int semester = Integer.parseInt( scan.nextLine() );
            String courseCode = scan.nextLine();
            String courseName = scan.nextLine();
            String testDate = scan.nextLine();
            String date = scan.nextLine();
            for (int j=0 ; j<Main.link.size() ; j++) {
                if (Main.link.get(j).getStudentNumber().equals(number)) {
                    Course c = new Course(courseCode, courseName, testDate, date);
                    Semester s = new Semester();

                    s.setSemesterNumber(semester);
                    s.courseLink.add(c);

                    if (Main.link.get(j).arrSemester.size() >= semester) {
                        Main.link.get(j).arrSemester.get(semester-1).setSemesterNumber(semester);
                        Main.link.get(j).arrSemester.get(semester-1).courseLink.add(c) ;
                    }
                    else {
                        Main.link.get(j).arrSemester.add(s) ;
                    }
                }
            }
        }
        scan.close();

    }


}