import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ReadFileStudent {
    public File file ;
    ReadFileStudent ( String fileAddress ) throws FileNotFoundException {
        file = new File(fileAddress);
        Scanner scan = new Scanner(file);
        for ( ; scan.hasNextLine() ;) {
            String number = scan.nextLine();
            String firstName = scan.nextLine();
            String lastName = scan.nextLine();
            String major = scan.nextLine();
            String year = scan.nextLine();
            Main.link.add(new Student(number, firstName, lastName, major, year)) ;
        }
        scan.close();
    }
}
