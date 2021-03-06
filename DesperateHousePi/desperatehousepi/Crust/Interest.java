package desperatehousepi.Crust;

public class Interest {
	
	String name;
	int importance;
	String description;
	Crust crust;
	
	Interest(String n, int lvl, String desc, Crust c){
		name = n;
		importance = lvl;
		description = desc;
		crust = c;
	}
	
	Interest(String n){
		name = n;
		importance = 0;
	}
	
	Interest(){
		name = "";
		importance = 0;
		description = "";
	}
	
	public String getName(){
		return name;
	}
	
	public int getImportance(){
		return importance;
	}
	
	public void setImportance(int i){
		if(i>100)
			importance = 100;
		else if(i<-100)
			importance = -100;
		else
			importance = i;
	}
	
	public String toString(){
		return (name+": "+importance);
	}
	
	public String action(){
		
		return crust.first_name+" "+description;
	}
}
