package desperatehousepi.Crust;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ActionLog{
   
	Crust crust;
	
	public ActionLog(Crust c){
		crust = c;
	}
   
   /*********************************
    * Takes in an action string as an argument 
    * and appends it to the file "log.txt".
    * @author Brad
    * @Edited Michael
    * *******************************/
   public void logAction(String action){
      try{
         FileWriter fstream = new FileWriter(crust.get("fullName").replace(" ", "_")+"_log.txt", true);
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
