import java.io.*;
import java.lang.*;

public class ActionLog{

   public static void logAction(String action) throws IOException{
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
