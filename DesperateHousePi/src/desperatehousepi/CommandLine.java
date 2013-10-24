package desperatehousepi;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CommandLine {
	
	//Declare constants
	private static final int NO_CMD = 0;
	private static final int EXIT_CMD = 1;
	
	//Declare variables
	private static Commands cmd;
	
	//Create command enumerations
	private static enum keyCommand{
		SET, GET, RANDOM, CUSTOM, DESTROY, PRINT, CLEAR, EXIT, HELP, SAVE, LOAD
	}
	
	/***************************************
	 * Creates a command line object and starts reading user input
	 * @param new_crust - A crust object, can just be null
	 * @author Anthony and Michael
	 ***************************************/
	public CommandLine(Crust new_crust){
		
		//Set the local crust equal to what is passed in
		cmd = new Commands(new_crust);
		
		//Initialize variables
		Scanner scan = new Scanner(System.in); //For reading the user input
		String command = ""; //For storing the user's command
		
		//Until the exit command is called
		while(true){
			
			//Print the prompt
			System.out.print("$: ");
			
			//Scan for the command
			command = scan.nextLine();
			
			//Parse the command and look for the exit
			if(parseCommand(command, scan)==EXIT_CMD) break;
		}
		
		//Stop reading for input and close the scanner
		scan.close();
	}
	
	/***************************************
	 * Parses through a command, executes any functions associated with command
	 * @param command - A string to be parsed
	 * @return A status number, 1 meaning exit and 0 meaning okay
	 * @author Anthony and Michael; Edited by Anthony 10/16/2013
	 ***************************************/
	private static int parseCommand(String command, Scanner scan){
		
		//If command is empty just return
		if(command.equals("")) return NO_CMD;
		
		//Create a tokenizer to break up the command string
		StringTokenizer tkn = new StringTokenizer(command);
		
		//Initialize the first part of the command
		String initCmd = tkn.nextToken();
		
		//Try the list of following commands
		try{
		
			//Find the command being used and execute it
			switch(keyCommand.valueOf(initCmd.toUpperCase())){
				
				//Exit the command line
				case EXIT:
					return EXIT_CMD;
				
				//Set a value in the passed in object
				case SET:
					cmd.set(tkn);
					return NO_CMD;
				
				//Get a value from the passed in object
				case GET:
					cmd.get(tkn);
					return NO_CMD;
				
				//Print out the object's information
				case PRINT:
					cmd.print(tkn);
					return NO_CMD;
				
				//Create an object with random default values
				case RANDOM:
					cmd.random(tkn);
					return NO_CMD;
					
				//Create an object and prompt user for input values for the object
				case CUSTOM:
					cmd.custom(tkn, scan);
					return NO_CMD;
				
				//Destroy an object
				case DESTROY:
					cmd.destroy(tkn);
					return NO_CMD;
				
				//Save the current state to file
				case SAVE:
					cmd.save(tkn);
					return NO_CMD;
					
				//Load Crust from File
				case LOAD:
					cmd.load(tkn);
					return NO_CMD;
					
				//Clear the screen
				case CLEAR:
					if(tkn.hasMoreTokens())
						for(int x = 0; x < 50; x++)
							System.out.println();
					else
						clearConsole();
					return NO_CMD;
				
				//Print out the specified help message
				case HELP:
					cmd.help(tkn);
					return NO_CMD;
				
				//Otherwise function not implemented
				default:
					System.out.println("Invalid command, try typing 'help'.");
					return NO_CMD;
			}
		
		//Command wasn't found
		}catch(IllegalArgumentException e){
			System.out.println("Invalid command, try typing 'help'.");
			return NO_CMD;
		}
	}
	
	/***************************************
	 * Clears the console independent of the operating system.
	 * @author Anthony and Michael
	 ***************************************/
	private static void clearConsole(){
		
		//In case the program is unable to get the operating system name
	    try{
	    	
	    	//Get the operating system name
	        String os = System.getProperty("os.name");
	        
	        //Call the appropriate command according to the operating system
	        if (os.contains("Windows"))
	            Runtime.getRuntime().exec("cls");
	        else
	            Runtime.getRuntime().exec("clear");
	    }catch(Exception exception){
	        System.out.println("Unable to clear screen, OS unavailable.");
	    }
	}
	
}
