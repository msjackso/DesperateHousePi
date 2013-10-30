package desperatehousepi.GUI;

import javax.swing.JFrame;

public class HelpWindow {

	private JFrame help_frame;

	/**
	 * Create the application.
	 */
	public HelpWindow() {
		initialize();
		help_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		help_frame = new JFrame();
		help_frame.setTitle("Help");
		help_frame.setBounds(100, 100, 450, 300);
		help_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
