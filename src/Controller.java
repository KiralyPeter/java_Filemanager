import java.util.ArrayList;


public class Controller {
    
    Controller(){

        start();

    }

    private void start () {

        ArrayList<Worker> empList = new ArrayList<>();
        Reader read = new Reader ("dolgozok100.txt");

       empList = read.readFile();
       
        int people = countWorkers( empList);
        ArrayList<String> nameList = getNames(empList);
       
    }

    

    
    private int countWorkers( ArrayList<Worker> empList){
        int counter = 0;
        for (int i = 0;  i< empList.size(); i++) {

            counter ++;
        }
        return counter;
    }
        
    private ArrayList<String> getNames(ArrayList<Worker>empList){
        ArrayList<String> nameList = new ArrayList<>();
        for(int i = 0; i < empList.size(); i++){

            Worker worker = new Worker();
            worker = empList.get(i);

            nameList.add( worker.getName());
        }
        return nameList;
    }

   private void writeFile ( ArrayList<String>nameList){

        Writer writer = new Writer();
        for( int i = 0; i < 5; i++){
            String name = nameList.get(i);
            writer.fileWrite("nevek.txt", name);
            writer.fileWrite("nevek.txt", "\n");
        }
   }
}
