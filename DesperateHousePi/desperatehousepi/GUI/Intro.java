package desperatehousepi.GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

import desperatehousepi.Crust.Crust;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Intro {

	private JFrame intro_frame;
	private JFileChooser fc;

	private JButton newBtn;
	private JButton loadBtn;
	private JButton helpBtn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Intro();
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
		intro_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialize the window with given size, title, and layout
		intro_frame = new JFrame();
		intro_frame.setTitle("Ancient Pie");
		
		//(x, y, w, h)
		intro_frame.setBounds(200, 100, 425, 680);
		intro_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		intro_frame.getContentPane().add(panel);

		initIntroComponents();
		

		intro_frame.setLayout(null);
		intro_frame.add(newBtn);
		intro_frame.add(loadBtn);
		intro_frame.add(helpBtn);
	}
	
	private void initIntroComponents() {
		
		//Background Image
		try {
			intro_frame.setContentPane(new JPanel() {
				private static final long serialVersionUID = 1L;
				BufferedImage background = ImageIO.read(new File("images/backgrounds/welcomeScreen.png"));
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        g.drawImage(background, 0, 0, 425, 680, this);
			    }
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int baseY = 340;
		int baseX = 150;
		
		//Create a new Crust			
		newBtn = new JButton("New");
		newBtn.setToolTipText("Start a new adventure!");
		newBtn.setForeground(Color.BLACK);
		newBtn.setBackground(Color.RED);
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				intro_frame.setVisible(false);
				new CreationWindow();
			}
		});
		newBtn.setBounds(baseX, baseY, 150, 26);
		
		//Load a previously created Crust
		loadBtn = new JButton("Load");
		loadBtn.setToolTipText("Load a previously saved file");
		loadBtn.setForeground(Color.BLACK);
		loadBtn.setBackground(Color.RED);
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Create a file chooser
				fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fc.showDialog(intro_frame, "Load");
				
				//If a valid file was loaded
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            Crust c = new Crust();
		            try {
						c.load(file.getName());
					} catch (IOException e) { }
		            
		            intro_frame.setVisible(false);
		            try {
						new MainWindow(c);
					} catch (FileNotFoundException e) { }
		            
		        }
			}			
		});
		loadBtn.setBounds(baseX, baseY+40, 150, 26);
		
		//Get help
		helpBtn = new JButton("Help");
		helpBtn.setToolTipText("View the documentation");
		helpBtn.setForeground(Color.BLACK);
		helpBtn.setBackground(Color.RED);
		helpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HelpWindow();
			}			
		});
		helpBtn.setBounds(baseX, baseY+80, 150, 26);
	}
}
