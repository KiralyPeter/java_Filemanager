import java.io.IOException;
import java.io.FileWriter;


public class Writer {
    
    // Writer üres konstruktora
    Writer(){

       
    }

    // ... és egyetlen metódusa; bemeneti paraméter: fájlnév, adat (?).. ami itt a "name" a Controller-ből
    public void fileWrite(String fileName, String data){

        // Megpróbálja (try) hozzéfűzni a fileName paraméterben kapott fájlhoz a "data" tartalmát
        try {
            FileWriter writer =  new FileWriter(fileName, true);
            writer.write (data);

            writer.close();

        // Ha hibára futna a fájlba írás, akkor a kivétel kezelve van...
        } catch (IOException e) {
            System.out.println("Hiba az írás során");
        }

    }
}
