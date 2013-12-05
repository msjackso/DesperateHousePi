package desperatehousepi.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import desperatehousepi.Crust.Crust;

public class AncientPie {
	

	private static final int refreshTime = 500;
	ActionListener refreshMeAll;
	
	private JFrame ancientPieFrame;
	Crust crust;

	private JLabel crustImage;
	private JLabel wisdomText;
	private JButton request;
	private JButton verify;
	private JButton back;
	
	
	public AncientPie(Crust c) throws FileNotFoundException {
		crust = c;
		initialize();
		new Timer(refreshTime*5, refreshMeAll).start();
		//Action Listeners
		@SuppressWarnings("unused")
		ActionListener refreshMeAll = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				refreshAncient();
		   	}
		};
		ancientPieFrame.setVisible(true);
	}
	
	private void initialize() {
		//initialize the window with given size, title, and layout
		ancientPieFrame = new JFrame();
		ancientPieFrame.setTitle("Ancient Pie");
		
		//(x, y, w, h)
		ancientPieFrame.setBounds(200, 100, 425, 680);
		ancientPieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ancientPieFrame.getContentPane().add(panel);
		
		initAncientComponents();
		refreshAncient();
	}
	
	private void initAncientComponents() {
		
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
		
		//Set background image
		try {
			ancientPieFrame.setContentPane(new JPanel() {
				private static final long serialVersionUID = 1L;
				BufferedImage background = ImageIO.read(new File("images/backgrounds/ancientPieSpeech_color.png"));
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
			        g.drawImage(background, 0, 0, 425, 680, this);
			    }
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Crust Image
		String path = "images/chars/color/"+crust.getPieType().filename+crust.getStageAsNum()+"_color.png";
		crustImage = new JLabel(new ImageIcon(path));
		
		//Ancient Pie's words
		wisdomText = new JLabel("...");
		wisdomText.setFont(font);
		wisdomText.setForeground(Color.BLACK);
		wisdomText.setBounds(60, 40, 400, 70);
		
		//Button opens new personality test window
		request = new JButton("Request");
		request.setToolTipText("If you are ready, the Ancient Pie will assign you a quest for growth");
		request.setForeground(Color.BLACK);
		request.setBackground(Color.RED);
		request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wisdomText.setText(crust.requestGrowthQuest(crust.getStage()));
			}
		});
		request.setBounds(10, 570, 200, 26);
		
		//Button opens new personality test window
		verify = new JButton("Verify");
		verify.setToolTipText("What items do you still need?");
		verify.setForeground(Color.BLACK);
		verify.setBackground(Color.RED);
		verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wisdomText.setText(crust.requestQuestVerification());
			}			
		});
		verify.setBounds(210, 570, 200, 26);
		
		//Button opens new personality test window
		back = new JButton("Back");
		back.setToolTipText("If you are ready, the Ancient Pie will assign you a quest for growth");
		back.setForeground(Color.BLACK);
		back.setBackground(Color.RED);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ancientPieFrame.setVisible(false);
				try { new MainWindow(crust); } catch (FileNotFoundException e2) { }
			}
		});
		back.setBounds(210, 610, 200, 26);
		
	}
	
	private void refreshAncient() {		
		ancientPieFrame.setLayout(null);
		
		//Create the crust's image in the top left hand corner
		crustImage = new JLabel();
		setCrustGraphics(crust);
		ancientPieFrame.getContentPane().add(crustImage);
		ancientPieFrame.add(wisdomText);
		ancientPieFrame.add(request);
		ancientPieFrame.add(verify);
		ancientPieFrame.add(back);
	}

	private void setCrustGraphics(Crust c){
		String path = "images/chars/color/"+c.getPieType().filename+c.getStageAsNum()+"_color.png";
		ImageIcon image = new ImageIcon(path);
		crustImage.setIcon(image);
		crustImage.setBounds(60, 440, image.getIconWidth(),image.getIconHeight());
	}
}
