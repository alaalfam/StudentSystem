import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

public class WriteFileStudent {
    public File file ;
    public WriteFileStudent(String fileAddress) throws FileNotFoundException {
        // TODO Auto-generated constructor stub
        file = new File(fileAddress);
        PrintWriter pw = new PrintWriter(file);
        for (int i=0 ; i<Main.link.size() ; i++) {
            pw.println( Main.link.get(i).getStudentNumber() );
            pw.println( Main.link.get(i).getFirstName() );
            pw.println( Main.link.get(i).getLastName() );
            pw.println( Main.link.get(i).getMajor() );
            pw.println( Main.link.get(i).getYear() );
        }
        pw.flush();
        pw.close();
    }
}

