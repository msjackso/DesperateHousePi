package desperatehousepi.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;

import desperatehousepi.Crust;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalityTestWindow {

	private JFrame PTest_frame;
	JTextArea question;
	JTextArea heading;
	
	Crust newCrust = new Crust();
	int currentTrait = 0;
	String[] tArray;
	String[] qArray;


	/**
	 * Opens up personality test window
	 */
	public PersonalityTestWindow() {
		initialize();
		PTest_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the Personality Test Window
	 */
	private void initialize() {
		
		//initialize frame
		PTest_frame = new JFrame();
		PTest_frame.setForeground(Color.RED);
		PTest_frame.setBackground(Color.RED);
		PTest_frame.setTitle("Personality Test");
		PTest_frame.setBounds(100, 100, 700, 400);
		PTest_frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		PTest_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		PTest_frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//initialize Crust object
		newCrust = new Crust();
		
		//Initialize tArray to hold the String name for the 16 traits
        tArray = new String[16];
        tArray[0] = "privateness";
        tArray[1] = "abstractedness";
        tArray[2] = "apprehensivness";
        tArray[3] = "dominance";
        tArray[4] = "emotionalStability";
        tArray[5] = "liveliness";
        tArray[6] = "opennessToChange";
        tArray[7] = "perfectionism";
        tArray[8] = "reasoning";
        tArray[9] = "ruleConsciousness";
        tArray[10] = "selfReliance";
        tArray[11] = "sensitivity";
        tArray[12] = "socialBoldness";
        tArray[13] = "tension";
        tArray[14] = "vigilance";
        tArray[15] = "warmth";


        //Initialize qArray to contain each of the questions to ask the user
        qArray  = new String[16];
        qArray[0] = "I prefer to be around others (-5) \nOR I prefer to be alone (5)\n";
        qArray[1] = "I am a practical thinker (-5) \nOR I am very imaginative (5) \n";
        qArray[2] = "I am usually very calm (-5) \nOR I tend to worry a lot (5) \n";
        qArray[3] = "I try to avoid conflicts (-5) \nOR I am a competitive person (5) \n";
        qArray[4] = "I am quick to anger (-5) \nOR I am not easily irritated (5) \n";
        qArray[5] = "I like to plan things out (-5) \nOR I do things spontaneously (5) \n";
        qArray[6] = "I enjoy things done traditionally (-5) \nOR I enjoy flexibility (5) \n";
        qArray[7] = "Disorder doesn't bother me (-5) \nOR Everything needs to be organized (5) \n";
        qArray[8] = "I view things in detail (-5) \nOR I view things abstractedly  (5) \n";
        qArray[9] = "I resist authority (-5) \nOR I follow the rules (5) \n";
        qArray[10] = "I need the company of others (-5) \nOR I need time to myself (5) \n";
        qArray[11] = "I am tough-minded (-5) \nOR I am tender-hearted (5) \n";
        qArray[12] = "I have trouble approaching people (-5) \nOR I am comfortable around strangers (5) \n";
        qArray[13] = "Traffic doesn't bother me (-5) \nOR I get frustrated in traffic (5) \n";
        qArray[14] = "People are generally good (-5) \nOR People are generally bad (5) \n";
        qArray[15] = "I am reserved (-5) \nOR I am outgoing (5) \n";
		
        //initialize button for displaying Test instructions
        JButton instructionsBtn = new JButton("Instructions");
        instructionsBtn.setToolTipText("Display Personality Test Instructions");
		instructionsBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		instructionsBtn.setBackground(Color.RED);
		instructionsBtn.setForeground(Color.WHITE);
		instructionsBtn.setBounds(531, 11, 143, 62);
		panel.add(instructionsBtn);
		
		/**********************************************
		 * Initialize buttons for answering questions
		 * as well as their associated listeners, which
		 * set button value to newCrust, check if test is done,
		 * and update heading and question if not.
		 **********************************************/
		
		//-5 button
		JButton minusFiveBtn = new JButton("-5");
		minusFiveBtn.setBackground(Color.RED);
		minusFiveBtn.setForeground(Color.WHITE);
		minusFiveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minusFiveBtn.setBounds(10, 307, 60, 43);
		minusFiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], -5);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(minusFiveBtn);
		
		//-4 button
		JButton minusFourBtn = new JButton("-4");
		minusFourBtn.setBackground(Color.RED);
		minusFourBtn.setForeground(Color.WHITE);
		minusFourBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minusFourBtn.setBounds(70, 307, 60, 43);
		minusFourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], -4);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(minusFourBtn);
		
		//-3 button
		JButton minusThreeBtn = new JButton("-3");
		minusThreeBtn.setBackground(Color.RED);
		minusThreeBtn.setForeground(Color.WHITE);
		minusThreeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minusThreeBtn.setBounds(130, 307, 60, 43);
		minusThreeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], -3);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(minusThreeBtn);
		
		//-2 button
		JButton minusTwoBtn = new JButton("-2");
		minusTwoBtn.setBackground(Color.RED);
		minusTwoBtn.setForeground(Color.WHITE);
		minusTwoBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minusTwoBtn.setBounds(190, 307, 60, 43);
		minusTwoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], -2);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(minusTwoBtn);
		
		//-1 button
		JButton minusOneBtn = new JButton("-1");
		minusOneBtn.setBackground(Color.RED);
		minusOneBtn.setForeground(Color.WHITE);
		minusOneBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minusOneBtn.setBounds(250, 307, 60, 43);
		minusOneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], -1);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(minusOneBtn);
		
		//zero button
		JButton zeroBtn = new JButton("0");
		zeroBtn.setBackground(Color.RED);
		zeroBtn.setForeground(Color.WHITE);
		zeroBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zeroBtn.setBounds(310, 307, 60, 43);
		zeroBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 0);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(zeroBtn);
		
		//1 button
		JButton plusOneBtn = new JButton("1");
		plusOneBtn.setBackground(Color.RED);
		plusOneBtn.setForeground(Color.WHITE);
		plusOneBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusOneBtn.setBounds(370, 307, 60, 43);
		plusOneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 1);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(plusOneBtn);
		
		//two button
		JButton plusTwoBtn = new JButton("2");
		plusTwoBtn.setBackground(Color.RED);
		plusTwoBtn.setForeground(Color.WHITE);
		plusTwoBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusTwoBtn.setBounds(430, 307, 60, 43);
		plusTwoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 2);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(plusTwoBtn);
		
		//three button
		JButton plusThreeBtn = new JButton("3");
		plusThreeBtn.setBackground(Color.RED);
		plusThreeBtn.setForeground(Color.WHITE);
		plusThreeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusThreeBtn.setBounds(490, 307, 60, 43);
		plusThreeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 3);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(plusThreeBtn);
		
		//four button
		JButton plusFourBtn = new JButton("4");
		plusFourBtn.setBackground(Color.RED);
		plusFourBtn.setForeground(Color.WHITE);
		plusFourBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusFourBtn.setBounds(550, 307, 60, 43);
		plusFourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 4);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(plusFourBtn);
		
		//five button
		JButton plusFiveBtn = new JButton("5");
		plusFiveBtn.setBackground(Color.RED);
		plusFiveBtn.setForeground(Color.WHITE);
		plusFiveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		plusFiveBtn.setBounds(610, 307, 60, 43);
		plusFiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setFromTest(newCrust, tArray[currentTrait], 5);
				currentTrait++;
				isFinished(currentTrait);
				question.setText(qArray[currentTrait]);
				heading.setText("Question #" + String.valueOf(currentTrait+1));
			}
		});
		panel.add(plusFiveBtn);
		
		//initialize question heading
		heading = new JTextArea("Question #" + String.valueOf(currentTrait+1));
		heading.setLineWrap(true);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		heading.setBackground(Color.GREEN);
		heading.setBounds(10, 14, 318, 57);
		panel.add(heading);
		
		//initialize question text area
		question = new JTextArea(qArray[currentTrait]);
		question.setLineWrap(true);
		question.setBackground(Color.GREEN);
		question.setFont(new Font("Tahoma", Font.PLAIN, 32));
		question.setBounds(10, 98, 660, 198);
		panel.add(question);	
		
	}
	//set trait value according to answer
	public void setFromTest(Crust c, String t, int v){
		v = v*20;
		c.set(t, String.valueOf(v));
	}
	
	//check to see if test is done, if it is exit this window and pass the trait values via newCrust
	public void isFinished(int c){
		if(c == 16){
			PTest_frame.setVisible(false);
			new CreationWindow(newCrust);
			currentTrait--;
			return;
		}
		return;
	}
}
