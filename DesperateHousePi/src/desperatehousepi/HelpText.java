package desperatehousepi;

/***************************************
 * Contains all of the help messages for the commands, as well as a general 
 * help message for when no known command name is given
 * @author Anthony
 ***************************************/

public class HelpText {

	//Create command name enumerations
	private static enum commandName{
		SET, GET, RANDOM, CUSTOM, DESTROY, PRINT, CLEAR, EXIT, HELP, SAVE, LOAD, CHAT, USE
	}
	
	/***************************************
	 * Empty constructor for HelpText class
	 * @param none
	 * @author Anthony
	 ***************************************/
	public HelpText(){
		
	}
	
	/***************************************
	 * Fetches and returns appropriate help message
	 * @param String: cmd - the command name (if given) to display help message for
	 * @return String: help message for given command or general help message
	 * @author Anthony
	 ***************************************/
	public String displayHelp(String cmd){
		
		String message = "";
		
		//Take input string and try to set it to associated enumeration
		try{
			switch(commandName.valueOf(cmd.toUpperCase())){
			
			//If given command matches an existing function, set appropriate message
			case SET:
				message = "The 'SET' function is used to set current crust's associated values.\n"
						+ "This includes the crust's firstName, middleName, and lastName,\n"
						+ "as well as the crust's associated personality traits: warmth\n"
						+ "reasoning, emotionalStability, dominance, liveliness, ruleConsciousness\n"
						+ "socialBoldness, sensitivity, vigilance, abstractedness, privateness\n"
						+ "apprehensivness, opennessToChange, selfReliance, perfectionism, tension\n"
						+ "Usage: set [object] [variable] [value]\n";
				break;
			case GET:
				message = "The 'GET' function is used to return current crust's associated values.\n"
						+ "This includes the crust's firstName, middleName, and lastName,\n"
						+ "as well as the crust's associated personality traits: warmth\n"
						+ "reasoning, emotionalStability, dominance, liveliness, ruleConsciousness\n"
						+ "socialBoldness, sensitivity, vigilance, abstractedness, privateness\n"
						+ "apprehensivness, opennessToChange, selfReliance, perfectionism, tension\n"
						+ "Usage: get [object] [variable] [value]\n";
				break;
			case RANDOM:
				message = "The 'RANDOM' function is used to create a new object with random\n"
						+ " traits. Currently creates a new crust object with random PTraits.\n"
						+ "Usage: random [object] \n";
				break;
			case CUSTOM:
				message = "The 'CUSTOM' function is used to create a new object and then prompts\n"
						+ "the user to set the values. Currently creates a new crust object and\n"
						+ "prompts user for first, middle, and last name and values for PTraits\n"
						+ "PTrait values should be integers between -100 and 100\n"
						+ "Usage: custom [object] \n";
				break;
			case DESTROY:
				message = "The 'DESTROY' function is used to destroy an object. Currently Destroys\n"
						+ "the loaded crust object.\n"
						+ "Usage: destroy [object] \n";
				break;
			case PRINT:
				message = "The 'PRINT' function is used to display the currently loaded crust's\n"
						+ "name, trait values, relationships, interests, and any other associated\n"
						+ "information.\n"
						+ "Usage: print [object] \n";
				break;
			case CLEAR:
				message = "The 'CLEAR' function is used to clear the console of all text.\n"
						+ "Usage: clear\n";
				break;
			case EXIT:
				message = "The 'EXIT' function exits the program\n"
						+ "Usage: exit\n";
				break;
			case HELP:
				message = "The 'HELP' command, displays general help information without second\n "
						+ "parameter. If second parameter given is command name, gives information\n"
						+ "about that command.\n"
						+ "Usage: help [command] \n";
				break;
			case SAVE:
				message = "The 'SAVE' command saves object information to a file. Currently\n"
						+"outputs a crust's names and PTrait values to a file as a single string,\n"
						+"naming it with given profile name.\n"
						+ "Usage: save [object] [profile name] \n";
				break;
			case LOAD:
				message = "The 'LOAD' command loads object information to an object. Currently\n"
						+"loads a crust's names and PTrait values from a file, assuming given file\n"
						+ "exists.\n"
						+ "Usage: load [object] [profile name] \n";
				break;
			case CHAT:
				message = "The 'CHAT' command opens up a prompt so that the user can chat with the\n"
						+ "crust as if chatting with a real person."
						+ "Usage: chat [object] \n";
				break;
			case USE:
				message = "The 'USE' command lets the crust use objects such as food, beds, coffee,\n"
						+ "etc, in order to keep it's needs levels at healthy levels. Currently,\n"
						+ "needs include hunger, energy and entertainment. Items that can be used\n"
						+ "by the crust include the APPLE, RASBERRY, FISH, BED, COFFEE, TV, and\n"
						+ "BALL, with each filling the need one would expect in a real person."
						+ "Usage: USE [item name] \n";
				break;
			}
		}catch(Exception e){
			//If no command given, display general help message
			if(cmd == ""){
				message = "To get started, type 'random crust' to create a new crust with random\n"
						+ "traits, or 'custom crust' to input the name and traits of the crust\n"
						+ "manually. Type 'help' and the command you want to see information\n"
						+ "about commands.\n\n"
						+ "Commands:\n"
						+ "\tSET\n\tGET\n\tRANDOM\n\tCUSTOM\n\tDESTROY\n\tPRINT\n\tCLEAR\n\tEXIT"
						+ "\n\tHELP\n\tSAVE\n\tLOAD\n";
			}
			//if bad command name given, print instructions for using help command properly
			else{
				message = "'" + cmd + "'" + " is not a recognized command. For a list of commands\n"
						+ ", type 'help' with no parameters.";
			}
		}
		return message;
	}
	
}
