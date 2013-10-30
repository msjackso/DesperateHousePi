package desperatehousepi.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Intro {

	private JFrame intro_frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro window = new Intro();
					window.intro_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Intro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		intro_frame = new JFrame();
		intro_frame.setForeground(Color.RED);
		intro_frame.setBackground(Color.RED);
		intro_frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Intro.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		intro_frame.setTitle("Desperate House Pi");
		intro_frame.setBounds(100, 100, 500, 200);
		intro_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		intro_frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton newBtn = new JButton("New");
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				intro_frame.setVisible(false);
				new CreationWindow();
			}
		});
		newBtn.setForeground(Color.WHITE);
		newBtn.setBackground(Color.RED);
		newBtn.setBounds(175, 37, 150, 23);
		panel.add(newBtn);
		
		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				intro_frame.setVisible(false);
				new LoadWindow();
			}
		});
		loadBtn.setForeground(Color.WHITE);
		loadBtn.setBackground(Color.RED);
		loadBtn.setBounds(175, 71, 150, 23);
		panel.add(loadBtn);
		
		JButton helpBtn = new JButton("Help");
		helpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				intro_frame.setVisible(false);
				new HelpWindow();
			}
		});
		helpBtn.setForeground(Color.WHITE);
		helpBtn.setBackground(Color.RED);
		helpBtn.setBounds(175, 105, 150, 23);
		panel.add(helpBtn);
		intro_frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{intro_frame.getContentPane(), panel}));
	}
}
