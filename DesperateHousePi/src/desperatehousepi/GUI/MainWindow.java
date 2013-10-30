package desperatehousepi.GUI;

import javax.swing.JFrame;

public class MainWindow {

	private JFrame frmMain;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		frmMain.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.setBounds(100, 100, 450, 300);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
