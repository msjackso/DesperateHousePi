package src.desperatehousepi;

import src.desperatehousepi.Crust.Crust;

public class Main {
	
	//Declare main crust
	public static Crust crust = null;
	
	public static void main(String[] args) {
		
		//Create command line
		new CommandLine(crust);
	}

}
