import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

// Fájl olvasó osztály...
public class Reader {
  
    String  fileName;

    // Konstruktor, ami átveszi a fájlnevet
    Reader (String fileName ){

        this.fileName = fileName;
    }

    // Publikus metódus...
    public ArrayList<Worker> readFile() {

        // Létre hoz egy "empList" tömböt
        ArrayList<Worker> empList = new ArrayList<>();

        // Inicializál egy FilerReader példányt
        FileReader reader = null;
        try {

            // A "reader" példánynak átadja a fájl nevét
            reader = new FileReader(fileName );
            
        // Ha nem sikerül a fájlt átadni, akkor a kivétel kezelve van...
        } catch ( FileNotFoundException ex ) {
            
            System.out.println( "Nincs meg a fájl" );
        }

        // Új Scanner objektum
        Scanner scan = new Scanner( reader );

        // String osztályú sor, ami a fájl sorát kapja
        String row = scan.nextLine();

        // Addig amíg van sor...
        while( scan.hasNext() ) {

            // Beolvassa a sort
            row = scan.nextLine();

            // Meghatározza a sort felosztó karaktert
            String[] rowSp = row.split( ":" );

            // Új, "emp" (dolgozó) példány
            Worker emp = new Worker();

            // Feltölti az aktuális példány adatait
            emp.setName( rowSp[0] );
            emp.setCity(rowSp[1] );
            emp.setAddress( rowSp[2] );
            emp.setSalary( rowSp[3] );
            emp.setBonus( rowSp[4] );
            emp.setBorn( rowSp[5] );
            emp.setHire( rowSp[6] );

            // Az empList-hez hozzáadja az aktuális "emp" példányt
            empList.add( emp );
        }

        // Az empList tömböt adja vissza...
        return empList;
    }  
}
