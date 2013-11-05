package desperatehousepi.GUI;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import desperatehousepi.Crust;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Random;

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
		
		//initialize the window with given size, title, and layout
		creation_frame = new JFrame();
		creation_frame.setTitle("Create a new Crust");
		creation_frame.setBounds(100, 100, 500, 500);
		creation_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creation_frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		creation_frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Initialize message label for displaying input errors
		final JLabel message = new JLabel("");
		message.setForeground(Color.RED);
		message.setBounds(27, 154, 414, 14);
		panel.add(message);
		
		//initialize textfields for Crust first, middle, and last name
		final JFormattedTextField firstName = new JFormattedTextField();
		firstName.setBounds(27, 25, 170, 20);
		panel.add(firstName);
		
		final JFormattedTextField middleName = new JFormattedTextField();
		middleName.setBounds(27, 66, 170, 20);
		panel.add(middleName);
		
		final JFormattedTextField lastName = new JFormattedTextField();
		lastName.setBounds(27, 108, 170, 20);
		panel.add(lastName);
		
		//initialize textfields for traits
		final JFormattedTextField warmth = new JFormattedTextField();
		warmth.setBounds(27, 274, 80, 20);
		panel.add(warmth);
		
		final JFormattedTextField reasoning = new JFormattedTextField();
		reasoning.setBounds(27, 318, 80, 20);
		panel.add(reasoning);
		
		final JFormattedTextField emotionalStability = new JFormattedTextField();
		emotionalStability.setBounds(27, 363, 80, 20);
		panel.add(emotionalStability);
		
		final JFormattedTextField dominance = new JFormattedTextField();
		dominance.setBounds(27, 410, 80, 20);
		panel.add(dominance);
		
		final JFormattedTextField liveliness = new JFormattedTextField();
		liveliness.setBounds(144, 274, 80, 20);
		panel.add(liveliness);
		
		final JFormattedTextField ruleConsciousness = new JFormattedTextField();
		ruleConsciousness.setBounds(144, 318, 80, 20);
		panel.add(ruleConsciousness);
		
		final JFormattedTextField socialBoldness = new JFormattedTextField();
		socialBoldness.setBounds(144, 363, 80, 20);
		panel.add(socialBoldness);
		
		final JFormattedTextField sensitivity = new JFormattedTextField();
		sensitivity.setBounds(144, 410, 80, 20);
		panel.add(sensitivity);
		
		final JFormattedTextField vigilance = new JFormattedTextField();
		vigilance.setBounds(251, 274, 80, 20);
		panel.add(vigilance);
		
		final JFormattedTextField abstractedness = new JFormattedTextField();
		abstractedness.setBounds(251, 318, 80, 20);
		panel.add(abstractedness);
		
		final JFormattedTextField privateness = new JFormattedTextField();
		privateness.setBounds(251, 363, 80, 20);
		panel.add(privateness);
		
		final JFormattedTextField apprehensivness = new JFormattedTextField();
		apprehensivness.setBounds(251, 410, 80, 20);
		panel.add(apprehensivness);
		
		final JFormattedTextField opennessToChange = new JFormattedTextField();
		opennessToChange.setBounds(361, 274, 80, 20);
		panel.add(opennessToChange);
		
		final JFormattedTextField selfReliance = new JFormattedTextField();
		selfReliance.setBounds(361, 318, 80, 20);
		panel.add(selfReliance);
		
		final JFormattedTextField perfectionism = new JFormattedTextField();
		perfectionism.setBounds(361, 363, 80, 20);
		panel.add(perfectionism);
		
		final JFormattedTextField tension = new JFormattedTextField();
		tension.setBounds(361, 410, 80, 20);
		panel.add(tension);
		
		//Button for clearing trait values from text boxes
		JButton clearBtn = new JButton("Clear");
		clearBtn.setForeground(Color.WHITE);
		clearBtn.setBackground(Color.RED);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//reset display message
				message.setText("");
				
				//reset all text boxes to null string
				warmth.setText("");
				reasoning.setText("");
				emotionalStability.setText("");
				dominance.setText("");
				liveliness.setText("");
				ruleConsciousness.setText("");
				socialBoldness.setText("");
				sensitivity.setText("");
				vigilance.setText("");
				abstractedness.setText("");
				privateness.setText("");
				apprehensivness.setText("");
				opennessToChange.setText("");
				selfReliance.setText("");
				perfectionism.setText("");
				tension.setText("");
			}
		});
		clearBtn.setBounds(333, 227, 108, 23);
		panel.add(clearBtn);
		
		//button for giving traits random values in text boxes
		JButton randomBtn = new JButton("Randomize");
		randomBtn.setForeground(Color.WHITE);
		randomBtn.setBackground(Color.RED);
		randomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//reset display message
				message.setText("");
				
				//set traits randomly for each text box
				warmth.setText(String.valueOf(getRandomTraitValue()));
				reasoning.setText(String.valueOf(getRandomTraitValue()));
				emotionalStability.setText(String.valueOf(getRandomTraitValue()));
				dominance.setText(String.valueOf(getRandomTraitValue()));
				liveliness.setText(String.valueOf(getRandomTraitValue()));
				ruleConsciousness.setText(String.valueOf(getRandomTraitValue()));
				socialBoldness.setText(String.valueOf(getRandomTraitValue()));
				sensitivity.setText(String.valueOf(getRandomTraitValue()));
				vigilance.setText(String.valueOf(getRandomTraitValue()));
				abstractedness.setText(String.valueOf(getRandomTraitValue()));
				privateness.setText(String.valueOf(getRandomTraitValue()));
				apprehensivness.setText(String.valueOf(getRandomTraitValue()));
				opennessToChange.setText(String.valueOf(getRandomTraitValue()));
				selfReliance.setText(String.valueOf(getRandomTraitValue()));
				perfectionism.setText(String.valueOf(getRandomTraitValue()));
				tension.setText(String.valueOf(getRandomTraitValue()));
			}
		});
		randomBtn.setBounds(28, 227, 108, 23);
		panel.add(randomBtn);
		
		//Button opens new personality test window
		JButton testBtn = new JButton("Take PF Test");
		testBtn.setForeground(Color.WHITE);
		testBtn.setBackground(Color.RED);
		testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PersonalityTestWindow();
			}
		});
		testBtn.setBounds(333, 195, 108, 23);
		panel.add(testBtn);
		
		
		//Button to create crust with given traits
		JButton createBtn = new JButton("Create Crust");
		createBtn.setForeground(Color.WHITE);
		createBtn.setBackground(Color.RED);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Keeps track of if good input was given
				boolean validInput = true;
				
				//First, reset display message to null string
				message.setText("");
				
				//then check that user entered at least a first name
				if(firstName.getText().equals("")){
				
					//display error and return
					message.setText("Your Crust must have at least a first name.");
					return;
				}
				
				//Now check that Personality traits are properly formatted
				if(!goodFormat(warmth.getText())){validInput = false;}
				if(!goodFormat(reasoning.getText())){validInput = false;} 
				if(!goodFormat(emotionalStability.getText())){validInput = false;}
				if(!goodFormat(dominance.getText())){validInput = false;}
				if(!goodFormat(liveliness.getText())){validInput = false;}
				if(!goodFormat(ruleConsciousness.getText())){validInput = false;}
				if(!goodFormat(socialBoldness.getText())){validInput = false;}
				if(!goodFormat(sensitivity.getText())){validInput = false;}
				if(!goodFormat(vigilance.getText())){validInput = false;}
				if(!goodFormat(abstractedness.getText())){validInput = false;}
				if(!goodFormat(privateness.getText())){validInput = false;}
				if(!goodFormat(apprehensivness.getText())){validInput = false;}
				if(!goodFormat(opennessToChange.getText())){validInput = false;}
				if(!goodFormat(selfReliance.getText())){validInput = false;}
				if(!goodFormat(perfectionism.getText())){validInput = false;}
				if(!goodFormat(tension.getText())){validInput = false;}
				
				//if bad input was given, display error message and exit method
				if(!validInput){
					message.setText("Personality Traits must be an Integer between 100 and -100.");
					return;
				}else{
					//otherwise input is valid, so create crust and pass it to main window
					Crust newCrust = new Crust(firstName.getText(), middleName.getText(), lastName.getText(), Integer.parseInt(warmth.getText()),
							Integer.parseInt(reasoning.getText()), Integer.parseInt(emotionalStability.getText()),Integer.parseInt(dominance.getText()),
							Integer.parseInt(liveliness.getText()), Integer.parseInt(ruleConsciousness.getText()), Integer.parseInt(socialBoldness.getText()),
							Integer.parseInt(sensitivity.getText()), Integer.parseInt(vigilance.getText()), Integer.parseInt(abstractedness.getText()),
							Integer.parseInt(privateness.getText()), Integer.parseInt(apprehensivness.getText()), Integer.parseInt(opennessToChange.getText()),
							Integer.parseInt(selfReliance.getText()), Integer.parseInt(perfectionism.getText()), Integer.parseInt(tension.getText()));
					creation_frame.setVisible(false);
					try { new MainWindow(newCrust); } catch (FileNotFoundException e) { }					
					return;
				}
			}
		});
		createBtn.setBounds(323, 24, 118, 43);
		panel.add(createBtn);
		
		
		//initialize labels
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFirstName.setBounds(27, 11, 80, 14);
		panel.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setForeground(Color.BLACK);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMiddleName.setBounds(27, 53, 80, 14);
		panel.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLastName.setBounds(27, 97, 80, 8);
		panel.add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("Personality Traits");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(174, 229, 170, 14);
		panel.add(lblNewLabel);
		
		JLabel lblWarmth = new JLabel("Warmth");
		lblWarmth.setForeground(Color.BLACK);
		lblWarmth.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblWarmth.setBounds(27, 260, 109, 14);
		panel.add(lblWarmth);
		
		JLabel lblReasoning = new JLabel("Reasoning");
		lblReasoning.setForeground(Color.BLACK);
		lblReasoning.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblReasoning.setBounds(27, 305, 118, 14);
		panel.add(lblReasoning);
		
		JLabel lblEmotionalStability = new JLabel("Emotional Stability");
		lblEmotionalStability.setForeground(Color.BLACK);
		lblEmotionalStability.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEmotionalStability.setBounds(27, 349, 118, 14);
		panel.add(lblEmotionalStability);
		
		JLabel lblDominance = new JLabel("Dominance");
		lblDominance.setForeground(Color.BLACK);
		lblDominance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDominance.setBounds(27, 394, 80, 14);
		panel.add(lblDominance);
		
		JLabel lblLiveliness = new JLabel("Liveliness");
		lblLiveliness.setForeground(Color.BLACK);
		lblLiveliness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLiveliness.setBounds(144, 260, 46, 14);
		panel.add(lblLiveliness);
		
		JLabel lblRuleConsciousness = new JLabel("Rule Consciousness");
		lblRuleConsciousness.setForeground(Color.BLACK);
		lblRuleConsciousness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblRuleConsciousness.setBounds(144, 305, 111, 14);
		panel.add(lblRuleConsciousness);
		
		JLabel lblSocialBoldness = new JLabel("Social Boldness");
		lblSocialBoldness.setForeground(Color.BLACK);
		lblSocialBoldness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSocialBoldness.setBounds(144, 349, 109, 14);
		panel.add(lblSocialBoldness);
		
		JLabel lblSensitivity = new JLabel("Sensitivity");
		lblSensitivity.setForeground(Color.BLACK);
		lblSensitivity.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSensitivity.setBounds(144, 394, 80, 14);
		panel.add(lblSensitivity);
		
		JLabel lblVigilance = new JLabel("Vigilance");
		lblVigilance.setForeground(Color.BLACK);
		lblVigilance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblVigilance.setBounds(251, 260, 46, 14);
		panel.add(lblVigilance);
		
		JLabel lblAbstractedness = new JLabel("Abstractedness");
		lblAbstractedness.setForeground(Color.BLACK);
		lblAbstractedness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAbstractedness.setBounds(251, 305, 93, 14);
		panel.add(lblAbstractedness);
		
		JLabel lblPrivateness = new JLabel("Privateness");
		lblPrivateness.setForeground(Color.BLACK);
		lblPrivateness.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPrivateness.setBounds(251, 349, 136, 14);
		panel.add(lblPrivateness);
		
		JLabel lblApprehension = new JLabel("Apprehension");
		lblApprehension.setForeground(Color.BLACK);
		lblApprehension.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblApprehension.setBounds(251, 394, 80, 14);
		panel.add(lblApprehension);
		
		JLabel lblOpennessToChange = new JLabel("Openness to Change");
		lblOpennessToChange.setForeground(Color.BLACK);
		lblOpennessToChange.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblOpennessToChange.setBounds(361, 260, 123, 14);
		panel.add(lblOpennessToChange);
		
		JLabel lblSelfReliance = new JLabel("Self Reliance");
		lblSelfReliance.setForeground(Color.BLACK);
		lblSelfReliance.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSelfReliance.setBounds(361, 305, 80, 14);
		panel.add(lblSelfReliance);
		
		JLabel lblPerfectionism = new JLabel("Perfectionism");
		lblPerfectionism.setForeground(Color.BLACK);
		lblPerfectionism.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPerfectionism.setBounds(361, 349, 80, 14);
		panel.add(lblPerfectionism);
		
		JLabel lblTension = new JLabel("Tension");
		lblTension.setForeground(Color.BLACK);
		lblTension.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTension.setBounds(361, 394, 46, 14);
		panel.add(lblTension);
	}
	
	//Function to get random bell curve value between -100 and 100
	public int getRandomTraitValue(){
		
		//value to return
		int value = 0;
		
		//Create random object
		Random rand = new Random();
			
		//Generate a bell curve average value and return it
		value = Math.round((rand.nextInt(201)+rand.nextInt(201)+rand.nextInt(201)-300)/3);
		return value;
	}
	public boolean goodFormat(String value){
		try{
			if(Integer.parseInt(value) > 100 || Integer.parseInt(value) < -100){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			return false;
		}
		
	}
}
