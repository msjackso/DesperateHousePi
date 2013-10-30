package desperatehousepi.GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frameMain;
	
	public static void main(String[] args){ new MainWindow(); }
	
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frameMain.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		frameMain.setTitle("Main");
		frameMain.setBounds(100, 100, 507, 619);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 366, 491, 215);
		frameMain.getContentPane().add(tabbedPane);
		
		JTabbedPane alertTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Alerts", null, alertTab, null);
		
		JTabbedPane statTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Stats", null, statTab, null);
		
		JTabbedPane relTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Relationships", null, relTab, null);
		
		JTabbedPane interestTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Interests", null, interestTab, null);
		
		JTabbedPane chatTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Chat", null, chatTab, null);
		
		JPanel crustImage = new JPanel();
		crustImage.setBorder(new MatteBorder(0, 0, 3, 3, (Color) new Color(0, 0, 0)));
		crustImage.setBackground(Color.RED);
		crustImage.setBounds(0, 0, 185, 226);
		frameMain.getContentPane().add(crustImage);
		
		JPanel crustInfo = new JPanel();
		crustInfo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		crustInfo.setBounds(184, 0, 307, 226);
		frameMain.getContentPane().add(crustInfo);
		GridBagLayout gbl_crustInfo = new GridBagLayout();
		gbl_crustInfo.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_crustInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_crustInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_crustInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		crustInfo.setLayout(gbl_crustInfo);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		crustInfo.add(lblName, gbc_lblName);
		
		JLabel lblFullName = new JLabel("John Jacob Schmitt");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.anchor = GridBagConstraints.WEST;
		gbc_lblFullName.gridwidth = 3;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 1;
		gbc_lblFullName.gridy = 0;
		crustInfo.add(lblFullName, gbc_lblFullName);
		
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 1;
		crustInfo.add(lblAge, gbc_lblAge);
		
		JLabel lblAgeVal = new JLabel("0");
		lblAgeVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAgeVal = new GridBagConstraints();
		gbc_lblAgeVal.gridwidth = 3;
		gbc_lblAgeVal.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAgeVal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgeVal.gridx = 1;
		gbc_lblAgeVal.gridy = 1;
		crustInfo.add(lblAgeVal, gbc_lblAgeVal);
		
		JLabel lblStage = new JLabel("Stage: ");
		lblStage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStage = new GridBagConstraints();
		gbc_lblStage.anchor = GridBagConstraints.EAST;
		gbc_lblStage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStage.gridx = 0;
		gbc_lblStage.gridy = 2;
		crustInfo.add(lblStage, gbc_lblStage);
		
		JLabel lblStageVal = new JLabel("Child");
		lblStageVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStageVal = new GridBagConstraints();
		gbc_lblStageVal.anchor = GridBagConstraints.WEST;
		gbc_lblStageVal.gridwidth = 3;
		gbc_lblStageVal.insets = new Insets(0, 0, 5, 5);
		gbc_lblStageVal.gridx = 1;
		gbc_lblStageVal.gridy = 2;
		crustInfo.add(lblStageVal, gbc_lblStageVal);
		
		JLabel lblEnergy = new JLabel("Energy: ");
		lblEnergy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEnergy = new GridBagConstraints();
		gbc_lblEnergy.anchor = GridBagConstraints.EAST;
		gbc_lblEnergy.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergy.gridx = 0;
		gbc_lblEnergy.gridy = 3;
		crustInfo.add(lblEnergy, gbc_lblEnergy);
		
		JProgressBar energyBar = new JProgressBar();
		GridBagConstraints gbc_energyBar = new GridBagConstraints();
		gbc_energyBar.gridwidth = 3;
		gbc_energyBar.insets = new Insets(0, 0, 5, 0);
		gbc_energyBar.gridx = 1;
		gbc_energyBar.gridy = 3;
		crustInfo.add(energyBar, gbc_energyBar);
		
		JLabel lblEntertainment = new JLabel("Entertainment: ");
		lblEntertainment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntertainment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEntertainment = new GridBagConstraints();
		gbc_lblEntertainment.anchor = GridBagConstraints.EAST;
		gbc_lblEntertainment.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntertainment.gridx = 0;
		gbc_lblEntertainment.gridy = 4;
		crustInfo.add(lblEntertainment, gbc_lblEntertainment);
		
		JProgressBar entertainmentBar = new JProgressBar();
		GridBagConstraints gbc_entertainmentBar = new GridBagConstraints();
		gbc_entertainmentBar.gridwidth = 3;
		gbc_entertainmentBar.insets = new Insets(0, 0, 5, 0);
		gbc_entertainmentBar.gridx = 1;
		gbc_entertainmentBar.gridy = 4;
		crustInfo.add(entertainmentBar, gbc_entertainmentBar);
		
		JLabel lblHunger = new JLabel("Hunger: ");
		lblHunger.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHunger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHunger = new GridBagConstraints();
		gbc_lblHunger.anchor = GridBagConstraints.EAST;
		gbc_lblHunger.insets = new Insets(0, 0, 0, 5);
		gbc_lblHunger.gridx = 0;
		gbc_lblHunger.gridy = 5;
		crustInfo.add(lblHunger, gbc_lblHunger);
		
		JProgressBar hungerBar = new JProgressBar();
		GridBagConstraints gbc_hungerBar = new GridBagConstraints();
		gbc_hungerBar.gridwidth = 3;
		gbc_hungerBar.gridx = 1;
		gbc_hungerBar.gridy = 5;
		crustInfo.add(hungerBar, gbc_hungerBar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
