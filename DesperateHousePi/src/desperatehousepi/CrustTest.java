package desperatehousepi;

public class CrustTest {

	public static void main(String[] args) {
		Crust myCrust = new Crust();
		
		System.out.println("Made new random Crust with following Base personality traits:");
		System.out.println("Warmth = " + myCrust.warmth.getValue());
		System.out.println("Reasoning = " + myCrust.reasoning.getValue());
		System.out.println("Emotional Stability = " + myCrust.emotionalStability.getValue());
		System.out.println("Dominance = " + myCrust.dominance.getValue());
		System.out.println("Liveliness = " + myCrust.liveliness.getValue());
		System.out.println("Rule Consciousness = " + myCrust.ruleConsciousness.getValue());
		System.out.println("Social Boldness = " + myCrust.socialBoldness.getValue());
		System.out.println("Sensitivity = " + myCrust.sensitivity.getValue());
		System.out.println("Vigilance = " + myCrust.vigilance.getValue());
		System.out.println("Abstractedness = " + myCrust.abstractedness.getValue());
		System.out.println("Privateness = " + myCrust.privateness.getValue());
		System.out.println("Apprehensivness = " + myCrust.apprehensivness.getValue());
		System.out.println("Openness to Change = " + myCrust.opennessToChange.getValue());
		System.out.println("Self-Reliance = " + myCrust.selfReliance.getValue());
		System.out.println("Perfectionism = " + myCrust.perfectionism.getValue());
		System.out.println("Tension = " + myCrust.tension.getValue());
	}

}
