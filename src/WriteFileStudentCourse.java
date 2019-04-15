import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class WriteFileStudentCourse {
    public File file ;
    public WriteFileStudentCourse(String fileAddress) throws FileNotFoundException {
        // TODO Auto-generated constructor stub
        file = new File(fileAddress);
        PrintWriter pw = new PrintWriter(file);
        for (int i=0 ; i<Main.link.size() ; i++) {
            for (int j=0 ; j<Main.link.get(i).arrSemester.size() ; j++) {
                for (int k=0 ; k<Main.link.get(i).arrSemester.get(j).courseLink.size() ; k++) {
                    pw.println( Main.link.get(i).getStudentNumber() );
                    pw.println( Main.link.get(i).arrSemester.get(j).getSemesterNumber() );
                    pw.println( Main.link.get(i).arrSemester.get(j).courseLink.get(k).getCourseCode() );
                    pw.println( Main.link.get(i).arrSemester.get(j).courseLink.get(k).getCourseName() );
                    pw.println( Main.link.get(i).arrSemester.get(j).courseLink.get(k).getTestDate() );
                    pw.println( Main.link.get(i).arrSemester.get(j).courseLink.get(k).getDate() );
                }
            }
        }
        pw.flush();
        pw.close();

    }

}
