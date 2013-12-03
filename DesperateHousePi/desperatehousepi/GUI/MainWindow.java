package desperatehousepi.GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JList;

import java.util.Random;
import java.util.Vector;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Interest;
import desperatehousepi.Crust.Relationship;
import desperatehousepi.Items.ItemSet.Item;
import desperatehousepi.Items.ItemSet.itemType;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow {
	
	private static final int refreshTime = 500;
	
	private JFrame frameMain;
	private Crust crust;
	private File logFile;
	private BufferedReader logFileReader;
	private JComboBox<String> comboBox;
	
	//animation variables
	private Point targetLoc;
	private Point currentLoc;
	private int movementSpeed;
	Random rand = new Random();
	String currentItem;
	ImageIcon currentItemIcon;
	
	ImageIcon background1, background2, energyIcon, entertainmentIcon, hungerIcon, appleIcon, ballIcon, bedIcon, butterIcon, coffeeIcon, fishIcon, 
		flourIcon, jarIcon, lidIcon, panIcon, rasberryIcon, recipieIcon, rollingPinIcon, saltIcon, shardIcon, signatureIcon, 
		sugarIcon, tvIcon, waterIcon, blue1,blue2,blue3,cherry1,cherry2,cherry3,choc1,choc2,choc3,pecan1,pecan2,pecan3; 
	
	JTabbedPane tabbedPane;
		JTextArea alertTab;
		JScrollPane alertTabPane;
		JPanel relationshipPanel;
		JScrollPane friendScrollPane;
		JScrollPane acquaintancesScrollPane;
		JScrollPane enemiesScrollPane;
		JList<String> friendsList;
		JList<String> acquaintancesList;
		JList<String> enemiesList;
		DefaultListModel<String> friendsListModel;
		DefaultListModel<String> acquaintancesListModel;
		DefaultListModel<String> enemiesListModel;
		JPanel statsTab;
			JLabel lblStatsTabWarmth;
			JLabel lblStatsTabWarmthVal;
			JLabel lblStatsTabReasoning;
			JLabel lblStatsTabReasoningVal;
			JLabel lblStatsTabEmotionalStability;
			JLabel lblStatsTabEmotionalStabilityVal;
			JLabel lblStatsTabDominance;
			JLabel lblStatsTabDominanceVal;
			JLabel lblStatsTabLiveliness;
			JLabel lblStatsTabLivelinessVal;
			JLabel lblStatsTabRuleConsciousness;
			JLabel lblStatsTabRuleConsciousnessVal;
			JLabel lblStatsTabSocialBoldness;
			JLabel lblStatsTabSocialBoldnessVal;
			JLabel lblStatsTabSensitivity;
			JLabel lblStatsTabSensitivityVal;
			JLabel lblStatsTabVigilance;
			JLabel lblStatsTabVigilanceVal;
			JLabel lblStatsTabAbstractedness;
			JLabel lblStatsTabAbstractednessVal;
			JLabel lblStatsTabPrivateness;
			JLabel lblStatsTabPrivatenessVal;
			JLabel lblStatsTabApprehensivness;
			JLabel lblStatsTabApprehensivnessVal;
			JLabel lblStatsTabOpennessToChange;
			JLabel lblStatsTabOpennessToChangeVal;
			JLabel lblStatsTabSelfReliance;
			JLabel lblStatsTabSelfRelianceVal;
			JLabel lblStatsTabPerfectionism;
			JLabel lblStatsTabPerfectionismVal;
			JLabel lblStatsTabTension;
			JLabel lblStatsTabTensionVal;
			JLabel lblStatsTabBday;
			JLabel lblStatsTabBdayVal;
		JList<String> interestTab;
		DefaultListModel<String> interestList;
		JList<String> inventoryTab;
		DefaultListModel<String> inventoryList;
		JPanel chatTab;
			JTextArea chatTabChatLog;
			JTextArea textField;
			JTextField chatTabSendText;
			JButton chatTabSendBtn;
	JLabel crustImage;
	JLabel bgImage;
	JLabel itemImage;
	JPanel crustInfo;
		JLabel lblName;
		JLabel lblFullName;
		JLabel lblAge;
		JLabel lblAgeVal;
		JLabel lblStage;
		JLabel lblStageVal;
		JLabel lblEnergy;
		JProgressBar energyBar;
		JLabel lblEntertainment;
		JProgressBar entertainmentBar;
		JLabel lblHunger;
		JLabel lbldate;
		JLabel lbltime;
		JProgressBar hungerBar;
	JCheckBox chckbxCrustAi;
	
	public static void main(String[] args) throws FileNotFoundException{ new MainWindow(new Crust("Jim","Rayner")); }
	
	public MainWindow(Crust c) throws FileNotFoundException {
		crust = c;
		loadGraphics();
		initialize();
		refreshAll();
		new Timer(refreshTime, refreshMeEssential).start();
		new Timer(refreshTime*5, refreshMeAll).start();
		new Timer(refreshTime/20, refreshMeAnimation).start();
		frameMain.setVisible(true);
	}
	
	//ActionListeners
	private ActionListener refreshMeEssential = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			refreshEssentials();
	   	}
	};
	private ActionListener refreshMeAll = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			refreshAll();
	   	}
	};
	private ActionListener refreshMeAnimation = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent evt){
			refreshAnimation();
		}
	};
	private JCheckBox chckbxServer;
	
	//Refresh functions
	private void refreshAll(){
		refreshRelationships();
		refreshInterests();
		refreshEssentials();
		refreshInventory();
	}
	private void refreshEssentials(){
		refreshCrustInfo();
		refreshCrustStats();
		try { refreshAlerts(); } catch (IOException e) { }
	}
	private void refreshCrustInfo(){
		
		//Set the name
		lblFullName.setText(crust.get("firstName")+" "+crust.get("middleName")+" "+crust.get("lastName"));
		
		//Set the age
		lblAgeVal.setText(crust.get("age"));
		
		//Set the energy
		energyBar.setValue(crust.getNeed("Energy"));
		
		//Set the entertainment
		entertainmentBar.setValue(crust.getNeed("Entertainment"));
		
		//Set the hunger
		hungerBar.setValue(crust.getNeed("Hunger"));
		
		//Set date and time
		DateTime dt = new DateTime(); //gets current time
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMM dd, yyyy");
		DateTimeFormatter fmt2 = DateTimeFormat.forPattern("hh:mm aa");
		lbldate.setText(fmt.print(dt));
		lbltime.setText(fmt2.print(dt));
		
		//get current item selected
		currentItem = (String)comboBox.getSelectedItem();
		currentItemIcon = new ImageIcon("images/items/color/" + currentItem.toLowerCase() + ".png");
		
		//Label containing Item Image
		itemImage.setIcon(currentItemIcon);
		itemImage.setBounds(627, 319, currentItemIcon.getIconWidth(), currentItemIcon.getIconHeight());
	}
	private void refreshCrustStats(){
		
		int bdaymonth = crust.getbdaymonth();
		int birthday = crust.getbirthday();
		DateTime dt = new DateTime(2000,bdaymonth,birthday,0,0,0);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MMM dd");
		lblStatsTabBdayVal.setText(fmt.print(dt));
		
		lblStatsTabWarmthVal.setText(crust.get("warmth"));
		lblStatsTabReasoningVal.setText(crust.get("reasoning"));
		lblStatsTabEmotionalStabilityVal.setText(crust.get("emotionalStability"));
		lblStatsTabDominanceVal.setText(crust.get("dominance"));
		lblStatsTabLivelinessVal.setText(crust.get("liveliness"));
		lblStatsTabRuleConsciousnessVal.setText(crust.get("ruleConsciousness"));
		lblStatsTabSocialBoldnessVal.setText(crust.get("socialBoldness"));
		lblStatsTabSensitivityVal.setText(crust.get("sensitivity"));
		lblStatsTabVigilanceVal.setText(crust.get("vigilance"));
		lblStatsTabAbstractednessVal.setText(crust.get("abstractedness"));
		lblStatsTabPrivatenessVal.setText(crust.get("privateness"));
		lblStatsTabApprehensivnessVal.setText(crust.get("apprehensivness"));
		lblStatsTabOpennessToChangeVal.setText(crust.get("opennessToChange"));
		lblStatsTabSelfRelianceVal.setText(crust.get("selfReliance"));
		lblStatsTabPerfectionismVal.setText(crust.get("perfectionism"));
		lblStatsTabTensionVal.setText(crust.get("tension"));
	}
	private void refreshRelationships(){
		
		enemiesListModel.clear();
		acquaintancesListModel.clear();
		friendsListModel.clear();
		
		for(Relationship r : crust.getRelationships()){
			
			if(r.getChemistry()<-25)
				enemiesListModel.addElement(r.getContactName());
			else if(r.getChemistry()<25)
				acquaintancesListModel.addElement(r.getContactName());
			else
				friendsListModel.addElement(r.getContactName());
		}
	}
	private void refreshInterests(){
			
			interestList.clear();
			
			for(Interest i : crust.getInterests()){
				interestList.addElement(i.toString());
			} 
		}
	private void refreshInventory(){
		
		inventoryList.clear();
		
		for(Item i : crust.inventory.encyclopedia.values()){
			if(i.alive)
				inventoryList.addElement(i.item.name);
		} 
	}
	private void refreshAlerts() throws IOException{
		
		String alertLine = logFileReader.readLine();
		
		while(alertLine!=null){
			alertTab.append(alertLine+"\n");
			
			alertLine = logFileReader.readLine();
		}
		
		alertTab.setCaretPosition(alertTab.getDocument().getLength());
		
	}
	private void refreshAnimation(){
		
		if(((currentLoc.x - targetLoc.x) <= movementSpeed && (currentLoc.x - targetLoc.x) >= -movementSpeed) &&
				((currentLoc.y - targetLoc.y) <= movementSpeed && (currentLoc.y - targetLoc.y) >= -movementSpeed)){
			int targetX = rand.nextInt(bgImage.getWidth())+bgImage.getX();
			int targetY = rand.nextInt(bgImage.getHeight())+bgImage.getY();
			if(targetX < 60+bgImage.getX()){
				targetX = 60+bgImage.getX();
			}
			if(targetX > bgImage.getWidth()-60+bgImage.getX()){
				targetX = bgImage.getWidth()-60+bgImage.getX();
			}
			if(targetY < 100+bgImage.getY()){
				targetY = 100+bgImage.getY();
			}
			if(targetY > bgImage.getHeight()-100+bgImage.getY()){
				targetY = bgImage.getHeight()-100+bgImage.getY();
			}
			targetLoc = new Point(targetX, targetY);
		}else{
			if(targetLoc.x > currentLoc.x){
				currentLoc.x += movementSpeed;
				crustImage.setLocation(currentLoc);
			}else{
				currentLoc.x -= movementSpeed;
				crustImage.setLocation(currentLoc);
			}
			if(targetLoc.y > currentLoc.y){
				currentLoc.y += movementSpeed;
				crustImage.setLocation(currentLoc);
			}else{
				currentLoc.y -= movementSpeed;
				crustImage.setLocation(currentLoc);
			}
			
		}
	}
	
	//Load all of the graphics into ImageIcons
	//added by Tony 11/30/13
	private void loadGraphics() throws FileNotFoundException{
		background1 = new ImageIcon("images/Backgrounds/theCounter_color.png");
		background2 = new ImageIcon("images/Backgrounds/ancientPieMap_color.png");
		energyIcon = new ImageIcon("images/icons/color/energyIcon.png");
		entertainmentIcon = new ImageIcon("images/icons/color/entertainmentIcon.png");
		hungerIcon = new ImageIcon("images/icons/color/hungerIcon.png");
		blue1 = new ImageIcon("images/chars/color/blue1_color.png");
		blue2 = new ImageIcon("images/chars/color/blue2_color.png");
		blue3 = new ImageIcon("images/chars/color/blue3_color.png");
		cherry1 = new ImageIcon("images/chars/color/cherry1_color.png");
		cherry2 = new ImageIcon("images/chars/color/cherry2_color.png");
		cherry3 = new ImageIcon("images/chars/color/cherry3_color.png");
		choc1 = new ImageIcon("images/chars/color/choc1_color.png");
		choc2 = new ImageIcon("images/chars/color/choc2_color.png");
		choc3 = new ImageIcon("images/chars/color/choc3_color.png");
		pecan1 = new ImageIcon("images/chars/color/pecan1_color.png");
		pecan2 = new ImageIcon("images/chars/color/pecan2_color.png");
		pecan3 = new ImageIcon("images/chars/color/pecan3_color.png");
	}
	
	//Initialize the whole window
	private void initialize() throws FileNotFoundException {
		
		//Open log file
		logFile = new File(crust.get("fullName").replace(" ", "_")+"_log.txt");
		
		//If it doesn't exist then make it
		if(!logFile.exists()) try{ logFile.createNewFile(); }catch(Exception e){}
		logFileReader = new BufferedReader(new FileReader(logFile));
		
		//Create the main window
		frameMain = new JFrame();
		frameMain.getContentPane().setBackground(Color.GREEN);
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		frameMain.setTitle("Main");
		frameMain.setBounds(100, 100, 870, 669);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		//Create bottom tabs
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.GREEN);
		tabbedPane.setBounds(0, 366, 854, 240);
		frameMain.getContentPane().add(tabbedPane);
		createTabs();
		
		//Create the crust's image in the top left hand corner
		crustImage = new JLabel();
		setCrustGraphics(crust);
		frameMain.getContentPane().add(crustImage);
		
		//Create Background Image
		bgImage = new JLabel();
		bgImage.setBounds(10, 11, 463, 331);
		bgImage.setIcon(background1);
		frameMain.getContentPane().add(bgImage);
		
		//initialize variables for animation
		currentLoc = crustImage.getLocation();
		targetLoc = new Point(200, 200);
		movementSpeed = 2;
		
		//Create the crust information
		crustInfo = new JPanel();
		crustInfo.setBackground(Color.GREEN);
		crustInfo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		crustInfo.setBounds(537, 11, 307, 226);
		frameMain.getContentPane().add(crustInfo);
		GridBagLayout gbl_crustInfo = new GridBagLayout();
		gbl_crustInfo.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_crustInfo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_crustInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_crustInfo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		crustInfo.setLayout(gbl_crustInfo);
		createCrustInfo();
		
		//Create the give options
		Vector<String> comboBoxItems=new Vector<String>();
	    
		for(itemType iT : itemType.values()){
			comboBoxItems.add(iT.name);
		}
	    
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(comboBoxItems);
		comboBox = new JComboBox<String>(model);
		comboBox.setEditable(true);
		comboBox.setBounds(581, 257, 134, 20);
		frameMain.getContentPane().add(comboBox);
		
		//get current item selected
		currentItem = (String)comboBox.getSelectedItem();
		currentItemIcon = new ImageIcon("images/items/color/" + currentItem.toLowerCase() + ".png");
		
		//Label containing Item Image
		itemImage = new JLabel(currentItemIcon);
		itemImage.setBounds(627, 319, currentItemIcon.getIconWidth(), currentItemIcon.getIconHeight());
		frameMain.getContentPane().add(itemImage);
		
		//Create the give button
		JButton btnGive = new JButton("Give");
		btnGive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crust.give(comboBox.getSelectedItem().toString());
			}
		});
		btnGive.setBounds(728, 256, 89, 20);
		frameMain.getContentPane().add(btnGive);
		
		//Create the give button
		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crust.use(comboBox.getSelectedItem().toString());
			}
		});
		btnUse.setBounds(728, 287, 89, 20);
		frameMain.getContentPane().add(btnUse);
		
		//Create the menu items
		JMenuBar menuBar = new JMenuBar();
		frameMain.setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
					crust.save();
				} catch (Exception e) { System.out.print(e.toString()); }
            }
        });
		mnFile.add(mntmSave);
		
		chckbxCrustAi = new JCheckBox("Crust AI");
		chckbxCrustAi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				crust.crustAI.setSelfThink(chckbxCrustAi.isSelected());
			}
		});
		menuBar.add(chckbxCrustAi);
		
		chckbxServer = new JCheckBox("Server");
		chckbxServer.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(chckbxServer.isSelected()){
					crust.startServer();
				}else{
					crust.stopServer();
				}
			}
		});
		chckbxServer.setSelected(true);
		menuBar.add(chckbxServer);
	}
	
	//Generate the initial values
	private void createStatsTabLabels(){
		
		//Create Birthday label
		lblStatsTabBday = new JLabel("Birthday: ");
		lblStatsTabBday.setBounds(10,0,136,14);
		statsTab.add(lblStatsTabBday);
		lblStatsTabBdayVal = new JLabel("0");
		lblStatsTabBdayVal.setBounds(156,0,136,14);
		statsTab.add(lblStatsTabBdayVal);
		
		//Create warmth labels
		lblStatsTabWarmth = new JLabel("Warmth:");
		lblStatsTabWarmth.setBounds(10, 11, 136, 14);
		statsTab.add(lblStatsTabWarmth);
		lblStatsTabWarmthVal = new JLabel("0");
		lblStatsTabWarmthVal.setBounds(156, 11, 46, 14);
		statsTab.add(lblStatsTabWarmthVal);
		
		//Create reasoning labels
		lblStatsTabReasoning = new JLabel("Reasoning:");
		lblStatsTabReasoning.setBounds(10, 36, 136, 14);
		statsTab.add(lblStatsTabReasoning);
		lblStatsTabReasoningVal = new JLabel("0");
		lblStatsTabReasoningVal.setBounds(156, 36, 46, 14);
		statsTab.add(lblStatsTabReasoningVal);
		
		//Create emotional stability labels
		lblStatsTabEmotionalStability = new JLabel("Emotional Stability:");
		lblStatsTabEmotionalStability.setBounds(10, 61, 136, 14);
		statsTab.add(lblStatsTabEmotionalStability);
		lblStatsTabEmotionalStabilityVal = new JLabel("0");
		lblStatsTabEmotionalStabilityVal.setBounds(156, 61, 46, 14);
		statsTab.add(lblStatsTabEmotionalStabilityVal);
		
		//Create dominance labels
		lblStatsTabDominance = new JLabel("Dominance:");
		lblStatsTabDominance.setBounds(10, 86, 136, 14);
		statsTab.add(lblStatsTabDominance);
		lblStatsTabDominanceVal = new JLabel("0");
		lblStatsTabDominanceVal.setBounds(156, 86, 46, 14);
		statsTab.add(lblStatsTabDominanceVal);
		
		//Create liveliness labels
		lblStatsTabLiveliness = new JLabel("Liveliness:");
		lblStatsTabLiveliness.setBounds(10, 111, 136, 14);
		statsTab.add(lblStatsTabLiveliness);
		lblStatsTabLivelinessVal = new JLabel("0");
		lblStatsTabLivelinessVal.setBounds(156, 111, 46, 14);
		statsTab.add(lblStatsTabLivelinessVal);
		
		//Create consciousness labels
		lblStatsTabRuleConsciousness = new JLabel("Rule Consciousness:");
		lblStatsTabRuleConsciousness.setBounds(10, 136, 136, 14);
		statsTab.add(lblStatsTabRuleConsciousness);
		lblStatsTabRuleConsciousnessVal = new JLabel("0");
		lblStatsTabRuleConsciousnessVal.setBounds(156, 136, 46, 14);
		statsTab.add(lblStatsTabRuleConsciousnessVal);
		
		//Create social boldness labels
		lblStatsTabSocialBoldness = new JLabel("Social Boldness:");
		lblStatsTabSocialBoldness.setBounds(10, 161, 136, 14);
		statsTab.add(lblStatsTabSocialBoldness);
		lblStatsTabSocialBoldnessVal = new JLabel("0");
		lblStatsTabSocialBoldnessVal.setBounds(156, 161, 46, 14);
		statsTab.add(lblStatsTabSocialBoldnessVal);
		
		//Create sensitivity labels
		lblStatsTabSensitivity = new JLabel("Sensitivity:");
		lblStatsTabSensitivity.setBounds(10, 186, 136, 14);
		statsTab.add(lblStatsTabSensitivity);
		lblStatsTabSensitivityVal = new JLabel("0");
		lblStatsTabSensitivityVal.setBounds(156, 186, 46, 14);
		statsTab.add(lblStatsTabSensitivityVal);
		
		//Create vigilance labels
		lblStatsTabVigilance = new JLabel("Vigilance:");
		lblStatsTabVigilance.setBounds(291, 11, 127, 14);
		statsTab.add(lblStatsTabVigilance);
		lblStatsTabVigilanceVal = new JLabel("0");
		lblStatsTabVigilanceVal.setBounds(428, 11, 48, 14);
		statsTab.add(lblStatsTabVigilanceVal);
		
		//Create abstractedness labels
		lblStatsTabAbstractedness = new JLabel("Abstractedness:");
		lblStatsTabAbstractedness.setBounds(291, 36, 127, 14);
		statsTab.add(lblStatsTabAbstractedness);
		lblStatsTabAbstractednessVal = new JLabel("0");
		lblStatsTabAbstractednessVal.setBounds(428, 36, 48, 14);
		statsTab.add(lblStatsTabAbstractednessVal);
		
		//Create privateness labels
		lblStatsTabPrivateness = new JLabel("Privateness:");
		lblStatsTabPrivateness.setBounds(291, 61, 127, 14);
		statsTab.add(lblStatsTabPrivateness);
		lblStatsTabPrivatenessVal = new JLabel("0");
		lblStatsTabPrivatenessVal.setBounds(428, 61, 48, 14);
		statsTab.add(lblStatsTabPrivatenessVal);
		
		//Create apprehensiveness labels
		lblStatsTabApprehensivness = new JLabel("Apprehensivness:");
		lblStatsTabApprehensivness.setBounds(291, 86, 127, 14);
		statsTab.add(lblStatsTabApprehensivness);
		lblStatsTabApprehensivnessVal = new JLabel("0");
		lblStatsTabApprehensivnessVal.setBounds(428, 86, 48, 14);
		statsTab.add(lblStatsTabApprehensivnessVal);
		
		//Create openness to change labels
		lblStatsTabOpennessToChange = new JLabel("Openness To Change:");
		lblStatsTabOpennessToChange.setBounds(291, 111, 127, 14);
		statsTab.add(lblStatsTabOpennessToChange);
		lblStatsTabOpennessToChangeVal = new JLabel("0");
		lblStatsTabOpennessToChangeVal.setBounds(428, 111, 48, 14);
		statsTab.add(lblStatsTabOpennessToChangeVal);
		
		//Create self-reliance labels
		lblStatsTabSelfReliance = new JLabel("Self Reliance:");
		lblStatsTabSelfReliance.setBounds(291, 136, 127, 14);
		statsTab.add(lblStatsTabSelfReliance);
		lblStatsTabSelfRelianceVal = new JLabel("0");
		lblStatsTabSelfRelianceVal.setBounds(428, 136, 48, 14);
		statsTab.add(lblStatsTabSelfRelianceVal);
		
		//Create perfectionism labels
		lblStatsTabPerfectionism = new JLabel("Perfectionism:");
		lblStatsTabPerfectionism.setBounds(291, 161, 127, 14);
		statsTab.add(lblStatsTabPerfectionism);
		lblStatsTabPerfectionismVal = new JLabel("0");
		lblStatsTabPerfectionismVal.setBounds(428, 161, 48, 14);
		statsTab.add(lblStatsTabPerfectionismVal);
		
		//Create tension labels
		lblStatsTabTension = new JLabel("Tension:");
		lblStatsTabTension.setBounds(291, 186, 127, 14);
		statsTab.add(lblStatsTabTension);
		lblStatsTabTensionVal = new JLabel("0");
		lblStatsTabTensionVal.setBounds(428, 186, 48, 14);
		statsTab.add(lblStatsTabTensionVal);
	}
	private void createChatTab(){
		
		//Create the log to hold past statements
		textField = new JTextArea();
		JScrollPane chatTabChatLog = new JScrollPane (textField, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textField.setLineWrap(true);
		textField.setEditable(false);
		chatTabChatLog.setBounds(0, 0, 486, 172);
		chatTab.add(chatTabChatLog);
		
		//Create the field for user input
		chatTabSendText = new JTextField();
		chatTabSendText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                	textField.append("You: "+chatTabSendText.getText()+"\n");
                	textField.append(crust.get("firstName")+": "+crust.chat(chatTabSendText.getText())+"\n");
    				chatTabSendText.setText("");
                }
            }
		});
		chatTabSendText.setBounds(0, 183, 404, 29);
		chatTab.add(chatTabSendText);
		chatTabSendText.setColumns(10);
		
		//Create the button to send chats
		chatTabSendBtn = new JButton("Send");
		chatTabSendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.append("You: "+chatTabSendText.getText()+"\n");
				textField.append(crust.get("firstName")+": "+crust.chat(chatTabSendText.getText())+"\n");
				chatTabSendText.setText("");
			}
		});
		chatTabSendBtn.setBounds(405, 183, 81, 29);
		chatTab.add(chatTabSendBtn);
		
	}
	private void createTabs(){
		
		//Create the tab for alerts
		alertTab = new JTextArea();
		alertTabPane = new JScrollPane (alertTab, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		alertTab.setEditable(false);
		tabbedPane.addTab("Alerts", null, alertTabPane, null);
		tabbedPane.setEnabledAt(0, true);
		
		//Create relationships panel
		relationshipPanel = new JPanel();
		tabbedPane.addTab("Relationships", null, relationshipPanel, null);
		relationshipPanel.setLayout(null);
		
		//Create the relationship labels
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setBounds(0, 0, 162, 22);
		lblFriends.setHorizontalAlignment(SwingConstants.CENTER);
		relationshipPanel.add(lblFriends);
		JLabel lblAcquaintances = new JLabel("Acquaintances");
		lblAcquaintances.setBounds(162, 0, 162, 22);
		lblAcquaintances.setHorizontalAlignment(SwingConstants.CENTER);
		relationshipPanel.add(lblAcquaintances);
		JLabel lblEnemies = new JLabel("Enemies");
		lblEnemies.setBounds(324, 0, 162, 22);
		lblEnemies.setHorizontalAlignment(SwingConstants.CENTER);
		relationshipPanel.add(lblEnemies);
		
		//Create the friends list
		friendsListModel = new DefaultListModel<String>();
		friendsList = new JList<String>(friendsListModel);
		
		acquaintancesListModel = new DefaultListModel<String>();
		acquaintancesList = new JList<String>(acquaintancesListModel);
		
		enemiesListModel = new DefaultListModel<String>();
		enemiesList = new JList<String>(enemiesListModel);
		
		//Create scroll panes
		friendScrollPane = new JScrollPane();
		friendScrollPane.setBounds(0, 22, 162, 190);
		relationshipPanel.add(friendScrollPane);
		friendScrollPane.setViewportView(friendsList);
		
		acquaintancesScrollPane = new JScrollPane();
		acquaintancesScrollPane.setBounds(162, 22, 162, 190);
		relationshipPanel.add(acquaintancesScrollPane);
		acquaintancesScrollPane.setViewportView(acquaintancesList);
		
		enemiesScrollPane = new JScrollPane();
		enemiesScrollPane.setBounds(324, 22, 162, 190);
		relationshipPanel.add(enemiesScrollPane);
		enemiesScrollPane.setViewportView(enemiesList);
		
		//Create the tab that holds all of the stats
		statsTab = new JPanel();
		tabbedPane.addTab("Stats", null, statsTab, null);
		statsTab.setLayout(null);
		createStatsTabLabels();
		
		//Create the tab that holds all of the interests
		interestList = new DefaultListModel<String>();
		interestTab = new JList<String>(interestList);
		tabbedPane.addTab("Interests", null, interestTab, null);
		
		//Create the tab that holds the inventory
		inventoryList = new DefaultListModel<String>();
		inventoryTab = new JList<String>(inventoryList);
		tabbedPane.addTab("Inventory", null, inventoryTab, null);
		
		//Create the chat tab
		chatTab = new JPanel();
		tabbedPane.addTab("Chat", null, chatTab, null);
		chatTab.setLayout(null);
		createChatTab();
	}
	private void createCrustInfo(){
		
		//Create the name label
		lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		crustInfo.add(lblName, gbc_lblName);
		
		//Create the name value
		lblFullName = new JLabel("John Jacob Schmitt");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFullName = new GridBagConstraints();
		gbc_lblFullName.anchor = GridBagConstraints.WEST;
		gbc_lblFullName.gridwidth = 3;
		gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullName.gridx = 1;
		gbc_lblFullName.gridy = 0;
		crustInfo.add(lblFullName, gbc_lblFullName);
		
		//Create the age label
		lblAge = new JLabel("Age: ");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 1;
		crustInfo.add(lblAge, gbc_lblAge);
		
		//Create the age value label
		lblAgeVal = new JLabel("0");
		lblAgeVal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAgeVal = new GridBagConstraints();
		gbc_lblAgeVal.gridwidth = 3;
		gbc_lblAgeVal.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblAgeVal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgeVal.gridx = 1;
		gbc_lblAgeVal.gridy = 1;
		crustInfo.add(lblAgeVal, gbc_lblAgeVal);
		
		//Create the stage label
		lblStage = new JLabel("Stage: ");
		lblStage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStage = new GridBagConstraints();
		gbc_lblStage.anchor = GridBagConstraints.EAST;
		gbc_lblStage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStage.gridx = 0;
		gbc_lblStage.gridy = 2;
		crustInfo.add(lblStage, gbc_lblStage);
		
		//Create the stage value label
		lblStageVal = new JLabel("Child");
		lblStageVal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStageVal = new GridBagConstraints();
		gbc_lblStageVal.anchor = GridBagConstraints.WEST;
		gbc_lblStageVal.gridwidth = 3;
		gbc_lblStageVal.insets = new Insets(0, 0, 5, 5);
		gbc_lblStageVal.gridx = 1;
		gbc_lblStageVal.gridy = 2;
		crustInfo.add(lblStageVal, gbc_lblStageVal);
		
		//Create the energy label
		lblEnergy = new JLabel("Energy: ",energyIcon, JLabel.CENTER);
		lblEnergy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEnergy = new GridBagConstraints();
		gbc_lblEnergy.anchor = GridBagConstraints.EAST;
		gbc_lblEnergy.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergy.gridx = 0;
		gbc_lblEnergy.gridy = 3;
		crustInfo.add(lblEnergy, gbc_lblEnergy);
		
		//Create the bar showing the energy level
		energyBar = new JProgressBar();
		GridBagConstraints gbc_energyBar = new GridBagConstraints();
		gbc_energyBar.gridwidth = 3;
		gbc_energyBar.insets = new Insets(0, 0, 5, 0);
		gbc_energyBar.gridx = 1;
		gbc_energyBar.gridy = 3;
		crustInfo.add(energyBar, gbc_energyBar);
		
		//Create the entertainment label
		lblEntertainment = new JLabel("Entertainment: ", entertainmentIcon, JLabel.CENTER);
		lblEntertainment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntertainment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEntertainment = new GridBagConstraints();
		gbc_lblEntertainment.anchor = GridBagConstraints.EAST;
		gbc_lblEntertainment.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntertainment.gridx = 0;
		gbc_lblEntertainment.gridy = 4;
		crustInfo.add(lblEntertainment, gbc_lblEntertainment);
		
		//Create the bar showing the entertainment level
		entertainmentBar = new JProgressBar();
		GridBagConstraints gbc_entertainmentBar = new GridBagConstraints();
		gbc_entertainmentBar.gridwidth = 3;
		gbc_entertainmentBar.insets = new Insets(0, 0, 5, 0);
		gbc_entertainmentBar.gridx = 1;
		gbc_entertainmentBar.gridy = 4;
		crustInfo.add(entertainmentBar, gbc_entertainmentBar);
		
		//Create the hunger label
		lblHunger = new JLabel("Hunger: ", hungerIcon, JLabel.CENTER);
		lblHunger.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHunger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHunger = new GridBagConstraints();
		gbc_lblHunger.anchor = GridBagConstraints.EAST;
		gbc_lblHunger.insets = new Insets(0, 0, 0, 5);
		gbc_lblHunger.gridx = 0;
		gbc_lblHunger.gridy = 5;
		crustInfo.add(lblHunger, gbc_lblHunger);
		
		//Create the bar showing the hunger level
		hungerBar = new JProgressBar();
		GridBagConstraints gbc_hungerBar = new GridBagConstraints();
		gbc_hungerBar.gridwidth = 3;
		gbc_hungerBar.gridx = 1;
		gbc_hungerBar.gridy = 5;
		crustInfo.add(hungerBar, gbc_hungerBar);
		
		//Create date label
		lbldate = new JLabel();
		lbldate.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbldate = new GridBagConstraints();
		gbc_lbldate.anchor = GridBagConstraints.EAST;
		gbc_lbldate.insets = new Insets(0, 0, 0, 5);
		gbc_lbldate.gridx = 0;
		gbc_lbldate.gridy = 6;
		crustInfo.add(lbldate, gbc_lbldate);
		
		//Create time label
		lbltime = new JLabel();
		lbltime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lbltime = new GridBagConstraints();
		gbc_lbltime.anchor = GridBagConstraints.EAST;
		gbc_lbltime.insets = new Insets(0, 0, 0, 5);
		gbc_lbltime.gridx = 0;
		gbc_lbltime.gridy = 7;
		crustInfo.add(lbltime, gbc_lbltime);
	}
	
	//Set appropriate crust icon given stage and type
	//edited 12/2 1:02AM by Mark
	private void setCrustGraphics(Crust c){
		String path = "images/chars/color/"+c.getPieType().filename+c.getStageAsNum()+"_color.png";
		ImageIcon image = new ImageIcon(path);
		crustImage.setIcon(image);
		crustImage.setBounds(150, 150, image.getIconWidth(),image.getIconHeight());
	}
}
