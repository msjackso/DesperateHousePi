package desperatehousepi.GUI;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;

public class CreationWindow {

	private JFrame creation_frame;

	/**
	 * Create the application.
	 */
	public CreationWindow() {
		initialize();
		creation_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		creation_frame = new JFrame();
		creation_frame.setTitle("Create a new Crust");
		creation_frame.setBounds(100, 100, 500, 500);
		creation_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creation_frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		creation_frame.getContentPane().add(panel);
		
		JFormattedTextField firstName = new JFormattedTextField();
		firstName.setBounds(27, 25, 170, 20);
		
		JFormattedTextField middleName = new JFormattedTextField();
		middleName.setBounds(27, 66, 170, 20);
		panel.setLayout(null);
		panel.add(firstName);
		panel.add(middleName);
		
		JFormattedTextField lastName = new JFormattedTextField();
		lastName.setBounds(27, 108, 170, 20);
		panel.add(lastName);
		
		JFormattedTextField warmth = new JFormattedTextField();
		warmth.setBounds(27, 274, 80, 20);
		panel.add(warmth);
		
		JFormattedTextField reasoning = new JFormattedTextField();
		reasoning.setBounds(27, 318, 80, 20);
		panel.add(reasoning);
		
		JFormattedTextField emotionalStability = new JFormattedTextField();
		emotionalStability.setBounds(27, 363, 80, 20);
		panel.add(emotionalStability);
		
		JFormattedTextField dominance = new JFormattedTextField();
		dominance.setBounds(27, 410, 80, 20);
		panel.add(dominance);
		
		JFormattedTextField liveliness = new JFormattedTextField();
		liveliness.setBounds(144, 274, 80, 20);
		panel.add(liveliness);
		
		JFormattedTextField ruleConsciousness = new JFormattedTextField();
		ruleConsciousness.setBounds(144, 318, 80, 20);
		panel.add(ruleConsciousness);
		
		JFormattedTextField socialBoldness = new JFormattedTextField();
		socialBoldness.setBounds(144, 363, 80, 20);
		panel.add(socialBoldness);
		
		JFormattedTextField sensitivity = new JFormattedTextField();
		sensitivity.setBounds(144, 410, 80, 20);
		panel.add(sensitivity);
		
		JFormattedTextField vigilance = new JFormattedTextField();
		vigilance.setBounds(251, 274, 80, 20);
		panel.add(vigilance);
		
		JFormattedTextField abstractedNess = new JFormattedTextField();
		abstractedNess.setBounds(251, 318, 80, 20);
		panel.add(abstractedNess);
		
		JFormattedTextField privateness = new JFormattedTextField();
		privateness.setBounds(251, 363, 80, 20);
		panel.add(privateness);
		
		JFormattedTextField apprehension = new JFormattedTextField();
		apprehension.setBounds(251, 410, 80, 20);
		panel.add(apprehension);
		
		JFormattedTextField opennessToChange = new JFormattedTextField();
		opennessToChange.setBounds(361, 274, 80, 20);
		panel.add(opennessToChange);
		
		JFormattedTextField selfReliance = new JFormattedTextField();
		selfReliance.setBounds(361, 318, 80, 20);
		panel.add(selfReliance);
		
		JFormattedTextField perfectionism = new JFormattedTextField();
		perfectionism.setBounds(361, 363, 80, 20);
		panel.add(perfectionism);
		
		JFormattedTextField tension = new JFormattedTextField();
		tension.setBounds(361, 410, 80, 20);
		panel.add(tension);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFirstName.setBounds(27, 11, 80, 14);
		panel.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMiddleName.setBounds(27, 53, 80, 14);
		panel.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLastName.setBounds(27, 97, 80, 8);
		panel.add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("Personality Traits");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(174, 229, 170, 14);
		panel.add(lblNewLabel);
		
		JLabel lblWarmth = new JLabel("Warmth");
		lblWarmth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWarmth.setBounds(27, 260, 109, 14);
		panel.add(lblWarmth);
		
		JLabel lblReasoning = new JLabel("Reasoning");
		lblReasoning.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblReasoning.setBounds(27, 305, 118, 14);
		panel.add(lblReasoning);
		
		JLabel lblEmotionalStability = new JLabel("Emotional Stability");
		lblEmotionalStability.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEmotionalStability.setBounds(27, 349, 118, 14);
		panel.add(lblEmotionalStability);
		
		JLabel lblDominance = new JLabel("Dominance");
		lblDominance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDominance.setBounds(27, 394, 80, 14);
		panel.add(lblDominance);
		
		JLabel lblLiveliness = new JLabel("Liveliness");
		lblLiveliness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLiveliness.setBounds(144, 260, 46, 14);
		panel.add(lblLiveliness);
		
		JLabel lblRuleConsciousness = new JLabel("Rule Consciousness");
		lblRuleConsciousness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblRuleConsciousness.setBounds(144, 305, 111, 14);
		panel.add(lblRuleConsciousness);
		
		JLabel lblSocialBoldness = new JLabel("Social Boldness");
		lblSocialBoldness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSocialBoldness.setBounds(144, 349, 109, 14);
		panel.add(lblSocialBoldness);
		
		JLabel lblSensitivity = new JLabel("Sensitivity");
		lblSensitivity.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSensitivity.setBounds(144, 394, 80, 14);
		panel.add(lblSensitivity);
		
		JLabel lblVigilance = new JLabel("Vigilance");
		lblVigilance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblVigilance.setBounds(251, 260, 46, 14);
		panel.add(lblVigilance);
		
		JLabel lblAbstractedness = new JLabel("Abstractedness");
		lblAbstractedness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAbstractedness.setBounds(251, 305, 93, 14);
		panel.add(lblAbstractedness);
		
		JLabel lblPrivateness = new JLabel("Privateness");
		lblPrivateness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPrivateness.setBounds(251, 349, 136, 14);
		panel.add(lblPrivateness);
		
		JLabel lblApprehension = new JLabel("Apprehension");
		lblApprehension.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblApprehension.setBounds(251, 394, 80, 14);
		panel.add(lblApprehension);
		
		JLabel lblOpennessToChange = new JLabel("Openness to Change");
		lblOpennessToChange.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblOpennessToChange.setBounds(361, 260, 123, 14);
		panel.add(lblOpennessToChange);
		
		JLabel lblSelfReliance = new JLabel("Self Reliance");
		lblSelfReliance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSelfReliance.setBounds(361, 305, 80, 14);
		panel.add(lblSelfReliance);
		
		JLabel lblPerfectionism = new JLabel("Perfectionism");
		lblPerfectionism.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPerfectionism.setBounds(361, 349, 80, 14);
		panel.add(lblPerfectionism);
		
		JLabel lblTension = new JLabel("Tension");
		lblTension.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTension.setBounds(361, 394, 46, 14);
		panel.add(lblTension);
	}
}
