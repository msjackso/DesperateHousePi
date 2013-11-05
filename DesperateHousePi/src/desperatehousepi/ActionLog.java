package desperatehousepi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ActionLog{
   
   
   /*********************************
    * Takes in an action string as an argument 
    * and appends it to the file "log.txt".
    * @author Brad
    * *******************************/
   public void logAction(String action) throws IOException{
      try{
         FileWriter fstream = new FileWriter("log.txt", true);
         BufferedWriter log = new BufferedWriter(fstream);
         log.write(action);
         log.newLine();
         log.close();
      }
      catch (Exception e){
         System.err.println("Error: " + e.getMessage());
      }
   }



}
