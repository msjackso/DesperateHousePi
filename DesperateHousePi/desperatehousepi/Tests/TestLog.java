package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.ActionLog;

public class TestLog {

        
        @Test
        public void testActionLog() throws FileNotFoundException{
        
              Crust c = new Crust();
              assertNotNull(c);
        
              ActionLog hist = new ActionLog(c);
              assertNotNull(hist);
              
              hist.logAction("this is an action");
              
              Scanner sc = new Scanner(new File("John_Jacob_Smith_log.txt"));
		          while(sc.hasNextLine()){
		                String str = sc.nextLine();
		                System.out.println(str);
		          }
		          sc.close();
        }
}
        
        
        
        
        
