package desperatehousepi.Crust;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import desperatehousepi.ItemSet.itemType;

public class CrustAI {
	
	Crust crust;
	ActionListener crustAI = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			
			//If the user wants the crust not to think for itself
			if(!selfThink) return;
			
			//CASE: Hunger<49
			if( crust.getNeed("Hunger")<49 ){
				if( altFlag == true ){
					crust.history.logAction("I'm hungry.. D:");
					altFlag = !altFlag;
				}
				//See if we have a consumable in our inventory first
				for( desperatehousepi.ItemSet.Item i : crust.inventory.encyclopedia.values() ){
					if( i.getValue("Hunger")>0 && crust.inventory.has(i.item) ){
						crust.use(i.item.name());
						return;
					}
				}
				//If not, go hunting for fish
				crust.give("fish");
				//Log hunting experience in history log.txt
				crust.history.logAction("Crust has gone hunting and got FISH");
				//Use the fish
				crust.use("fish");
			}
			
			//CASE: Energy<49
			if( crust.getNeed("Energy")<49 )
				if( !crust.inventory.has(itemType.BED) ){
					if( talkFlag ){
						crust.history.logAction(bedMsg);
						talkFlag = false;
					}
					//this is neccessary so the crust doesn't spam messages
					delay++;
					if( delay>10 ){ delay = 0; altFlag=true; talkFlag=true; bedMsg = "Please "+bedMsg; }
				}
				else{
					crust.use("bed");
				}
			//CASE: Energy<45
			if( crust.getNeed("Energy")<45 ){
				//Look for COFFEE
				crust.give("coffee");
				//Log that the crust has found COFFEE
				crust.history.logAction("Crust has found COFFEE");
				//Consume the COFFEE
				crust.use("coffee");
			}
			//CASE: Entertainment<
			if( crust.getNeed("Entertainment")<25 )
				crust.history.logAction("Entertain me, human.");
		}
	};
	
	//Initialize crust AI
	boolean altFlag = true;
	boolean talkFlag = true;
	boolean selfThink = false;
	int delay = 0;
	String bedMsg = "Please make me a BED (;-;)";
	
	public CrustAI(Crust c){
		
		//Set local crust to passed in crust
		crust = c;
		
		//Set the timer for the AI
		new Timer(1000, crustAI).start();
	}
	
	public void setSelfThink(boolean val){
		selfThink = val;
	}
	
}
