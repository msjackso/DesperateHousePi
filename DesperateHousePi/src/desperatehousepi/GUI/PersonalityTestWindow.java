package desperatehousepi.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

public class PersonalityTestWindow {

	private JFrame PTest_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalityTestWindow window = new PersonalityTestWindow();
					window.PTest_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonalityTestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PTest_frame = new JFrame();
		PTest_frame.setTitle("Personality Test");
		PTest_frame.setBounds(100, 100, 455, 300);
		PTest_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PTest_frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		String[] qArray;
		qArray  = new String[16];
		qArray[0] = "I prefer to be around others (-5) OR I prefer to be alone (5)\n";
		qArray[1] = "I am a practical thinker (-5) OR I am very imaginative (5) \n";
		qArray[2] = "I am usually very calm (-5) OR I tend to worry a lot (5) \n";
		qArray[3] = "I try to avoid conflicts (-5) OR I am a competitive person (5) \n";
		qArray[4] = "I am quick to anger (-5) OR I am not easily irritated (5) \n";
		qArray[5] = "I like to plan things out (-5) OR I do things spontaneously (5) \n";
		qArray[6] = "I enjoy things done traditionally (-5) OR I enjoy flexibility (5) \n";
		qArray[7] = "Disorder doesn't bother me (-5) OR Everything needs to be organized (5) \n";
		qArray[8] = "I view things in detail (-5) OR I view things abstractedly  (5) \n";
		qArray[9] = "I resist authority (-5) OR I follow the rules (5) \n";
		qArray[10] = "I need the company of others (-5) OR I need time to myself (5) \n";
		qArray[11] = "I am tough-minded (-5) OR I am tender-hearted (5) \n";
		qArray[12] = "I have trouble approaching people (-5) OR I am comfortable around strangers (5) \n";
		qArray[13] = "Traffic doesn't bother me (-5) OR I get frustrated in traffic (5) \n";
		qArray[14] = "People are generally good (-5) OR People are generally bad (5) \n";
		qArray[15] = "I am reserved (-5) OR I am outgoing (5) \n";
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		PTest_frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton instructionsBtn = new JButton("Instructions");
		instructionsBtn.setBackground(Color.RED);
		instructionsBtn.setForeground(Color.WHITE);
		instructionsBtn.setBounds(340, 11, 89, 23);
		panel.add(instructionsBtn);
		
		JButton minusFiveBtn = new JButton("-5");
		minusFiveBtn.setBackground(Color.RED);
		minusFiveBtn.setForeground(Color.WHITE);
		minusFiveBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		minusFiveBtn.setBounds(10, 227, 39, 23);
		panel.add(minusFiveBtn);
		
		JButton minusFourBtn = new JButton("-4");
		minusFourBtn.setBackground(Color.RED);
		minusFourBtn.setForeground(Color.WHITE);
		minusFourBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		minusFourBtn.setBounds(48, 227, 39, 23);
		panel.add(minusFourBtn);
		
		JButton minusThreeBtn = new JButton("-3");
		minusThreeBtn.setBackground(Color.RED);
		minusThreeBtn.setForeground(Color.WHITE);
		minusThreeBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		minusThreeBtn.setBounds(86, 227, 39, 23);
		panel.add(minusThreeBtn);
		
		JButton minusTwoBtn = new JButton("-2");
		minusTwoBtn.setBackground(Color.RED);
		minusTwoBtn.setForeground(Color.WHITE);
		minusTwoBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		minusTwoBtn.setBounds(124, 227, 39, 23);
		panel.add(minusTwoBtn);
		
		JButton minusOneBtn = new JButton("-1");
		minusOneBtn.setBackground(Color.RED);
		minusOneBtn.setForeground(Color.WHITE);
		minusOneBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		minusOneBtn.setBounds(162, 227, 39, 23);
		panel.add(minusOneBtn);
		
		JButton zeroBtn = new JButton("0");
		zeroBtn.setBackground(Color.RED);
		zeroBtn.setForeground(Color.WHITE);
		zeroBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		zeroBtn.setBounds(200, 227, 39, 23);
		panel.add(zeroBtn);
		
		JButton plusOneBtn = new JButton("1");
		plusOneBtn.setBackground(Color.RED);
		plusOneBtn.setForeground(Color.WHITE);
		plusOneBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		plusOneBtn.setBounds(238, 227, 39, 23);
		panel.add(plusOneBtn);
		
		JButton plusTwoBtn = new JButton("2");
		plusTwoBtn.setBackground(Color.RED);
		plusTwoBtn.setForeground(Color.WHITE);
		plusTwoBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		plusTwoBtn.setBounds(276, 227, 39, 23);
		panel.add(plusTwoBtn);
		
		JButton plusThreeBtn = new JButton("3");
		plusThreeBtn.setBackground(Color.RED);
		plusThreeBtn.setForeground(Color.WHITE);
		plusThreeBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		plusThreeBtn.setBounds(314, 227, 39, 23);
		panel.add(plusThreeBtn);
		
		JButton plusFourBtn = new JButton("4");
		plusFourBtn.setBackground(Color.RED);
		plusFourBtn.setForeground(Color.WHITE);
		plusFourBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		plusFourBtn.setBounds(352, 227, 39, 23);
		panel.add(plusFourBtn);
		
		JButton plusFiveBtn = new JButton("5");
		plusFiveBtn.setBackground(Color.RED);
		plusFiveBtn.setForeground(Color.WHITE);
		plusFiveBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		plusFiveBtn.setBounds(390, 227, 39, 23);
		panel.add(plusFiveBtn);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setVerticalAlignment(SwingConstants.TOP);
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuestion.setBounds(10, 36, 419, 180);
		panel.add(lblQuestion);
		
	}
}
