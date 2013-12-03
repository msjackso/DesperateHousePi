package desperatehousepi.GUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Crust.CrustType;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import net.miginfocom.swing.MigLayout;

public class CreationWindow {

	private JFrame creation_frame;
	private Crust newCrust;
	
	//edited 12/2 1:02AM by Mark
	private CrustType pieType = setRandomPieType();

	private JLabel empty;
	private String newFlavor;

	private JLabel lblFirstName;
	private JFormattedTextField firstName;
	private JLabel lblMiddleName;
	private JFormattedTextField middleName;
	private JLabel lblLastName;
	private JFormattedTextField lastName;
	
	private JLabel lblBirthday;
	private JFormattedTextField birthdayMonth;
	private JLabel lblBirthdayMonth;
	private JFormattedTextField birthdayDay;
	private JLabel lblBirthdayDay;
	
	private JLabel crustPreview;
	
	private JLabel lblWarmth;
	private JLabel lblReasoning;
	private JLabel lblEmotionalStability;
	private JLabel lblDominance;
	private JLabel lblLiveliness;
	private JLabel lblRuleConsciousness;
	private JLabel lblSocialBoldness;
	private JLabel lblSensitivity;
	private JLabel lblVigilance;
	private JLabel lblAbstractedness;
	private JLabel lblPrivateness;
	private JLabel lblApprehensivness;
	private JLabel lblOpennessToChange;
	private JLabel lblSelfReliance;
	private JLabel lblPerfectionism;
	private JLabel lblTension;
	private JFormattedTextField warmth;
	private JFormattedTextField reasoning;
	private JFormattedTextField emotionalStability;
	private JFormattedTextField dominance;
	private JFormattedTextField liveliness;
	private JFormattedTextField ruleConsciousness;
	private JFormattedTextField socialBoldness;
	private JFormattedTextField sensitivity;
	private JFormattedTextField vigilance;
	private JFormattedTextField abstractedness;
	private JFormattedTextField privateness;
	private JFormattedTextField apprehensivness;
	private JFormattedTextField opennessToChange;
	private JFormattedTextField selfReliance;
	private JFormattedTextField perfectionism;
	private JFormattedTextField tension;
	
	private JLabel message;
	
	private JButton testBtn;
	private JButton randomBtn;
	private JButton clearBtn;
	private JButton createBtn;
	
	/**
	 * Open window to create new Crust
	 * @wbp.parser.constructor 
	 */
	public CreationWindow() {
		newCrust = new Crust();
		newFlavor = newCrust.get("flavor");
		initialize();
		creation_frame.setVisible(true);
	}
	
	/**************************************
	 * Pass in an existing Crust, used with personality test
	 * @param c - Crust object to pass in
	 **************************************/
	public CreationWindow(Crust c){
		newCrust = c;
		newFlavor = newCrust.get("flavor");
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
		
		//(x, y, w, h)
		creation_frame.setBounds(200, 100, 425, 680);
		creation_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		creation_frame.getContentPane().add(panel);
		
		//Set background image
		try {
			creation_frame.setContentPane(new JPanel() {
			    BufferedImage background = ImageIO.read(new File("images/backgrounds/creationMap.png"));
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        g.drawImage(background, 0, 0, 425, 680, this);
			    }
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		initComponents();
		
		//Begin placing components using MigLayout
		creation_frame.setLayout(new MigLayout());
		creation_frame.add(lblFirstName, "pos 6 3");
		creation_frame.add(firstName, "wrap,gapy 2");
		creation_frame.add(lblMiddleName, "pos 6 49");
		creation_frame.add(middleName, "wrap,gapy 10");
		creation_frame.add(lblLastName, "pos 6 96");
		creation_frame.add(lastName, "wrap,gapy 10");
		
		creation_frame.add(lblBirthday, "pos 6 146");
		creation_frame.add(lblBirthdayMonth, "pos 26 170");
		creation_frame.add(birthdayMonth, "pos 75 168");
		creation_frame.add(lblBirthdayDay, "pos 122 170");
		creation_frame.add(birthdayDay, "pos 153 168");
		
		creation_frame.add(crustPreview, "pos 170 270");
		
		String col1a = "20";  String col1b = "20";
		String col2a = "120"; String col2b = "120";
		String col3a = "220"; String col3b = "220";
		String col4a = "320"; String col4b = "320";
		
		// Column 1
		creation_frame.add(lblWarmth, "pos "+col1a+" 446");
		creation_frame.add(warmth, "pos "+col1b+" 470");
		creation_frame.add(lblReasoning, "pos "+col1a+" 496");
		creation_frame.add(reasoning, "pos "+col1b+" 520");
		creation_frame.add(lblEmotionalStability, "pos "+col1a+" 546");
		creation_frame.add(emotionalStability, "pos "+col1b+" 570");
		creation_frame.add(lblDominance, "pos "+col1a+" 596");
		creation_frame.add(dominance, "pos "+col1b+" 620");

		// Column 2
		creation_frame.add(lblLiveliness, "pos "+col2a+" 446");
		creation_frame.add(liveliness, "pos "+col2b+" 470");
		creation_frame.add(lblRuleConsciousness, "pos "+col2a+" 496");
		creation_frame.add(ruleConsciousness, "pos "+col2b+" 520");
		creation_frame.add(lblSocialBoldness, "pos "+col2a+" 546");
		creation_frame.add(socialBoldness, "pos "+col2b+" 570");
		creation_frame.add(lblSensitivity, "pos "+col2a+" 596");
		creation_frame.add(sensitivity, "pos "+col2b+" 620");
		
		// Column 3
		creation_frame.add(lblVigilance, "pos "+col3a+" 446");
		creation_frame.add(vigilance, "pos "+col3b+" 470");
		creation_frame.add(lblAbstractedness, "pos "+col3a+" 496");
		creation_frame.add(abstractedness, "pos "+col3b+" 520");
		creation_frame.add(lblPrivateness, "pos "+col3a+" 546");
		creation_frame.add(privateness, "pos "+col3b+" 570");
		creation_frame.add(lblApprehensivness, "pos "+col3a+" 596");
		creation_frame.add(apprehensivness, "pos "+col3b+" 620");
		
		// Column 4
		creation_frame.add(lblOpennessToChange, "pos "+col4a+" 446");
		creation_frame.add(opennessToChange, "pos "+col4b+" 470");
		creation_frame.add(lblSelfReliance, "pos "+col4a+" 496");
		creation_frame.add(selfReliance, "pos "+col4b+" 520");
		creation_frame.add(lblPerfectionism, "pos "+col4a+" 546");
		creation_frame.add(perfectionism, "pos "+col4b+" 570");
		creation_frame.add(lblTension, "pos "+col4a+" 596");
		creation_frame.add(tension, "pos "+col4b+" 620");
		
		// Buttons
		creation_frame.add(message, "pos 6 300");
		creation_frame.add(testBtn, "pos 6 406");
		creation_frame.add(randomBtn, "pos 186 406");
		creation_frame.add(clearBtn, "pos 298 406");
		creation_frame.add(createBtn, "pos 238 340");
		
	}
	
	private void initComponents() {
		
		// Load the custom font
		Font font = null;
		try {
            //create the font to use. Specify the size!
            font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Caviar-Dreams/CaviarDreams.ttf")).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Caviar-Dreams/CaviarDreams.ttf")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
		
		// Load the custom font
		Font fontSmall = null;
		try {
            //create the font to use. Specify the size!
            fontSmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Bitstream-Vera-Sans-Mono/VeraMono.ttf")).deriveFont(10f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Bitstream-Vera-Sans-Mono/VeraMono.ttf")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
            e.printStackTrace();
        }
		
		// Initialize textfields for Crust first, middle, and last name
		int n = 13;
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(font);
		firstName = new JFormattedTextField();
		firstName.setColumns(n);

		lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(font);
		middleName = new JFormattedTextField();
		middleName.setColumns(n);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(font);
		lastName = new JFormattedTextField();
		lastName.setColumns(n);
		
		
		// textfields for month, day of birthday
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(font);
		
		lblBirthdayMonth = new JLabel("Month");
		lblBirthdayMonth.setFont(font);
		birthdayMonth = new JFormattedTextField();
		birthdayMonth.setColumns(2);
		
		lblBirthdayDay = new JLabel("Day");
		lblBirthdayDay.setFont(font);
		birthdayDay = new JFormattedTextField();
		birthdayDay.setColumns(2);
		
		//Pie Type Preview
		String path = "images/chars/color/"+pieType.filename+"1_color.png";
		crustPreview = new JLabel(new ImageIcon(path));
		
		//Initialize traits label and fields
		lblWarmth = new JLabel("<html><br>Warmth</html>");
		lblWarmth.setFont(fontSmall);
		lblReasoning = new JLabel("<html><br>Reasoning</html>");
		lblReasoning.setFont(fontSmall);
		lblEmotionalStability = new JLabel("<html>Emotional<br>Stability</html>");
		lblEmotionalStability.setFont(fontSmall);
		lblDominance = new JLabel("<html><br>Dominance</html>");
		lblDominance.setFont(fontSmall);
		lblLiveliness = new JLabel("<html><br>Liveliness</html>");
		lblLiveliness.setFont(fontSmall);
		lblRuleConsciousness = new JLabel("<html>Rule<br>Consciousness</html>");
		lblRuleConsciousness.setFont(fontSmall);
		lblSocialBoldness = new JLabel("<html><br>Social Boldness</html>");
		lblSocialBoldness.setFont(fontSmall);
		lblSensitivity = new JLabel("<html><br>Sensitivity</html>");
		lblSensitivity.setFont(fontSmall);
		lblVigilance = new JLabel("<html><br>Vigilance</html>");
		lblVigilance.setFont(fontSmall);
		lblAbstractedness = new JLabel("<html><br>Abstractedness</html>");
		lblAbstractedness.setFont(fontSmall);
		lblPrivateness = new JLabel("<html><br>Privateness</html>");
		lblPrivateness.setFont(fontSmall);
		lblApprehensivness = new JLabel("<html><br>Apprehension</html>");
		lblApprehensivness.setFont(fontSmall);
		lblOpennessToChange = new JLabel("<html>Openness<br>to Change</html>");
		lblOpennessToChange.setFont(fontSmall);
		lblSelfReliance = new JLabel("<html><br>Self Reliance</html>");
		lblSelfReliance.setFont(fontSmall);
		lblPerfectionism = new JLabel("<html><br>Perfectionism</html>");
		lblPerfectionism.setFont(fontSmall);
		lblTension = new JLabel("<html><br>Tension</html>");
		lblTension.setFont(fontSmall);
		
		warmth = new JFormattedTextField();
		warmth.setColumns(2);
		reasoning = new JFormattedTextField();
		reasoning.setColumns(2);
		emotionalStability = new JFormattedTextField();
		emotionalStability.setColumns(2);
		dominance = new JFormattedTextField();
		dominance.setColumns(2);
		liveliness = new JFormattedTextField();
		liveliness.setColumns(2);
		ruleConsciousness = new JFormattedTextField();
		ruleConsciousness.setColumns(2);
		socialBoldness = new JFormattedTextField();
		socialBoldness.setColumns(2);
		sensitivity = new JFormattedTextField();
		sensitivity.setColumns(2);
		vigilance = new JFormattedTextField();
		vigilance.setColumns(2);
		abstractedness = new JFormattedTextField();
		abstractedness.setColumns(2);
		privateness = new JFormattedTextField();
		privateness.setColumns(2);
		apprehensivness = new JFormattedTextField();
		apprehensivness.setColumns(2);
		opennessToChange = new JFormattedTextField();
		opennessToChange.setColumns(2);
		selfReliance = new JFormattedTextField();
		selfReliance.setColumns(2);
		perfectionism = new JFormattedTextField();
		perfectionism.setColumns(2);
		tension = new JFormattedTextField();
		tension.setColumns(2);
		
		//set values of txt fields given newCrust object
		warmth.setText(newCrust.get("warmth"));
		reasoning.setText(newCrust.get("reasoning"));
		emotionalStability.setText(newCrust.get("emotionalStability"));
		dominance.setText(newCrust.get("dominance"));
		liveliness.setText(newCrust.get("liveliness"));
		ruleConsciousness.setText(newCrust.get("ruleConsciousness"));
		socialBoldness.setText(newCrust.get("socialBoldness"));
		sensitivity.setText(newCrust.get("sensitivity"));
		vigilance.setText(newCrust.get("vigilance"));
		abstractedness.setText(newCrust.get("abstractedness"));
		privateness.setText(newCrust.get("privateness"));
		apprehensivness.setText(newCrust.get("apprehensivness"));
		opennessToChange.setText(newCrust.get("opennessToChange"));
		selfReliance.setText(newCrust.get("selfReliance"));
		perfectionism.setText(newCrust.get("perfectionism"));
		tension.setText(newCrust.get("tension"));
		
		//Initialize message label for displaying input errors
		message = new JLabel("");
		message.setForeground(Color.RED);
		message.setBounds(27, 198, 414, 14);
		
		//Button opens new personality test window
		testBtn = new JButton("Take Personality Test");
		testBtn.setToolTipText("Take a personality test to determine base trait values");
		testBtn.setForeground(Color.BLACK);
		testBtn.setBackground(Color.RED);
		testBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creation_frame.setVisible(false);
				
				newCrust.set("firstName", firstName.getText());
				newCrust.set("middleName", middleName.getText());
				newCrust.set("lastName", lastName.getText());
				newCrust.setbdaymonth(Integer.parseInt(birthdayMonth.getText()));
				newCrust.setbirthday(Integer.parseInt(birthdayDay.getText()));
				newCrust.set("warmth", warmth.getText());
				newCrust.set("reasoning", reasoning.getText());
				newCrust.set("emotionalStability", emotionalStability.getText());
				newCrust.set("dominance", dominance.getText());
				newCrust.set("liveliness", liveliness.getText());
				newCrust.set("ruleConsciousness", ruleConsciousness.getText());
				newCrust.set("socialBoldness", socialBoldness.getText());
				newCrust.set("sensitivity", sensitivity.getText());
				newCrust.set("vigilance", vigilance.getText());
				newCrust.set("abstractedness", abstractedness.getText());
				newCrust.set("privateness", privateness.getText());
				newCrust.set("apprehensivness", apprehensivness.getText());
				newCrust.set("oppenessToChange", opennessToChange.getText());
				newCrust.set("selfReliance", selfReliance.getText());
				newCrust.set("prefectionism", perfectionism.getText());
				newCrust.set("tension", tension.getText());
				
				new PersonalityTestWindow(newCrust);
			}
		});
		testBtn.setBounds(333, 195, 108, 23);
		
		//Button for clearing trait values from text boxes
		clearBtn = new JButton("Clear");
		clearBtn.setToolTipText("Clear personality trait values");
		clearBtn.setForeground(Color.BLACK);
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
		
		//button for giving traits random values in text boxes
		randomBtn = new JButton("Randomize");
		randomBtn.setToolTipText("Set personality trait values randomly");
		randomBtn.setForeground(Color.BLACK);
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
		
		//Button to create crust with given traits
		createBtn = new JButton("Create Crust");
		createBtn.setFont(font);
		createBtn.setToolTipText("Create a new Crust with given traits");
		createBtn.setForeground(Color.BLACK);
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
				
				if(birthdayMonth.getText().equals("") || birthdayDay.getText().equals("")){
					message.setText("Must set birthday.");
					return;
				}
				
				if(!goodDate(birthdayMonth.getText(),birthdayDay.getText())){
					message.setText("Invalid date");
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
					newCrust.set("firstName", firstName.getText());
					newCrust.set("middleName", middleName.getText());
					newCrust.set("lastName", lastName.getText());
					newCrust.setbdaymonth(Integer.parseInt(birthdayMonth.getText()));
					newCrust.setbirthday(Integer.parseInt(birthdayDay.getText()));
					newCrust.set("warmth", warmth.getText());
					newCrust.set("reasoning", reasoning.getText());
					newCrust.set("emotionalStability", emotionalStability.getText());
					newCrust.set("dominance", dominance.getText());
					newCrust.set("liveliness", liveliness.getText());
					newCrust.set("ruleConsciousness", ruleConsciousness.getText());
					newCrust.set("socialBoldness", socialBoldness.getText());
					newCrust.set("sensitivity", sensitivity.getText());
					newCrust.set("vigilance", vigilance.getText());
					newCrust.set("abstractedness", abstractedness.getText());
					newCrust.set("privateness", privateness.getText());
					newCrust.set("apprehensivness", apprehensivness.getText());
					newCrust.set("oppenessToChange", opennessToChange.getText());
					newCrust.set("selfReliance", selfReliance.getText());
					newCrust.set("prefectionism", perfectionism.getText());
					newCrust.set("tension", tension.getText());
					
					//edited 12/2/2013 1:02AM by Mark
					newCrust.typeOfPie = pieType;
					//
					creation_frame.setVisible(false);
					try { new MainWindow(newCrust); } catch (FileNotFoundException e) { }							
					return;
				}
			}
		});
		createBtn.setBounds(323, 24, 118, 63);
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
	
	boolean goodDate(String str_month,String str_day){
		int month,day;
		try{
			month = Integer.parseInt(str_month);
			day = Integer.parseInt(str_day);
		}catch(Exception e){
			return false;
		}
			
		if(month < 1 || month > 12 || day < 1) return false;

		switch(month){
			case 2:
				if(day < 1 || day > 29) return false;
				else return true;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 
				if(day > 31 ) return false;
				else return true;
			default:
				if(day >30) return false;
				else return true;
		}

	}
	
	/******************************
	 * Randomly determines the type of pie
	 * @return CrustType - enumeration of either BLUEBERRYPIE, CHERRYPIE,
	 * CHOCOLATEPIE, or PECANPIE
	 * @author Tony
	 * 11/30/2013
	 ******************************/
	public CrustType setRandomPieType(){
		Random rand = new Random();
		int i = rand.nextInt(4);
		if (i == 0)			{return CrustType.BLUEBERRYPIE;}
		else if (i == 1)	{return CrustType.CHERRYPIE;}
		else if (i == 2)	{return CrustType.CHOCOLATEPIE;}
		else				{return CrustType.PECANPIE;}
	}
}

