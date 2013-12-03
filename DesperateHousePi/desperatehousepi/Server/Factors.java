package desperatehousepi.Server;

public class Factors {
	
	public static final double ODDS_BASE = 2.9;
	public static final double ODDS_BALANCE = 290.0;
	
	public double odds;
	public String largestFactorString;
	public double largestFactor;
	
	public Factors(double o, double lF, String lFS){
		odds = o;
		largestFactor = lF;
		largestFactorString = lFS;
	}
	
}
