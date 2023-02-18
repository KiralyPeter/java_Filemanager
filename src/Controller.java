// A Controller osztály, ez vezérli a teljes programot

import java.util.ArrayList;

// A Controller osztály konstruktora
public class Controller {
    
    Controller(){

        // meghívja a start() függvényt
        start();

    }

    // őt hívja meg a Controller konstruktora
    private void start () {

        // Létrehoz egy Worker osztályú "empList" példányt az ArrayList osztályból
        ArrayList<Worker> empList = new ArrayList<>();

        // Létrehoz egy "read" példányt a Reader osztályból; ennek az osztálynak átadja a fájt (dolgozok100.txt)
        Reader read = new Reader ("dolgozok100.txt");

        // Az "empList" objektumnak átadja a "read" objektum readFile() metódusának eredményét
        empList = read.readFile();
       
        // Itt egy "pepole" változónak átadja a megszámolt dolgozókat. A válozó nincs használatban... (?)
        int people = countWorkers( empList);
        System.out.println("Dolgozók száma: " + people);

        // Egy String osztályú "nameList" lista példányt hoz létre, ami a Controller (tehát ezen) osztály getNames metódusával tölti fel a nevek listáját.
        ArrayList<String> nameList = getNames(empList);

        // Kiírja a "nameList" tömböt fájlba. 
        writeFile(nameList);
       
    }

    

    // privát metódus: megszámolja a munkásokat, bemeneti paramétere az "empList" tömb
    private int countWorkers( ArrayList<Worker> empList){

        // egy számlálót inicializás 0 értékkel
        int counter = 0;

        // ciklus, ami végigmegy az "empList" tömbön (empList.size-ig), és minden egyes ciklusban növeli a számlálót +1-el
        for (int i = 0;  i< empList.size(); i++) {

            counter ++;
        }

        // visszaadja a számláló értékét
        return counter;
    }
        
    // privát metódus: egy nameList litsába gyűjti a dolgozó neveket
    private ArrayList<String> getNames(ArrayList<Worker>empList){
        
        // Létrehoz egy "nameList" tömböt
        ArrayList<String> nameList = new ArrayList<>();

        // Ciklussal végigmegy a metódus paraméterében kapott empList-en
        for(int i = 0; i < empList.size(); i++){

            // létrehoz egy Worker osztályú "worker" példányt
            Worker worker = new Worker();

            // Az empList 'i'-ik elemét átadja a "worker" objektumnak
            worker = empList.get(i);

            // A névlistához (nameList) hozzá adja az aktuális "worker" példány getName értékét (a dolgozó nevét...)
            nameList.add( worker.getName());
        }
        return nameList;
    }

   // Fájlba írja a "nameList" tömböt
   private void writeFile ( ArrayList<String>nameList){

        // Létrehoz egy új Writer osztályú "writer" objektumot
        Writer writer = new Writer();

        // Ciklussal végig megy a nameList tömbön és fájlba írja a tömb 'i'-ik elemét és egy sortörést
        // Csak az első 5 nevet írja ki a fájlba
        for( int i = 0; i < 5; i++){
            String name = nameList.get(i);
            writer.fileWrite("nevek.txt", name);
            writer.fileWrite("nevek.txt", "\n");
        }
   }
}
