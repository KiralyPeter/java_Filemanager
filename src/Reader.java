import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Reader {
  
    String  fileName;

    Reader (String fileName ){

        this.fileName = fileName;
    }

    public ArrayList<Worker> readFile() {

        ArrayList<Worker> empList = new ArrayList<>();
        FileReader reader = null;
        try {

            reader = new FileReader(fileName );
            
        } catch ( FileNotFoundException ex ) {
            
            System.out.println( "Nincs meg a fájl" );
        }

        Scanner scan = new Scanner( reader );
        String row = scan.nextLine();

        while( scan.hasNext() ) {

            row = scan.nextLine();
            String[] rowSp = row.split( ":" );
            Worker emp = new Worker();

            emp.setName( rowSp[0] );
            emp.setCity(rowSp[1] );
            emp.setAddress( rowSp[2] );
            emp.setSalary( rowSp[3] );
            emp.setBonus( rowSp[4] );
            emp.setBorn( rowSp[5] );
            emp.setHire( rowSp[6] );

            empList.add( emp );
        }
        return empList;
    }  
}
