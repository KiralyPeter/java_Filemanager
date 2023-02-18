import java.io.IOException;
import java.io.FileWriter;


public class Writer {
    

    Writer(){


    }
    public void fileWrite(String fileName, String data){

        try {
            FileWriter writer =  new FileWriter(fileName, true);
            writer.write (data);

            writer.close();
        } catch (IOException e) {
            System.out.println("Hiba az írás során");
        }

    }
}
