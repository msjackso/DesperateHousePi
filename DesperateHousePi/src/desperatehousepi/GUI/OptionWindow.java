package desperatehousepi.GUI;

import javax.swing.JFrame;

public class OptionWindow {

	private JFrame option_frame;

	/**
	 * Create the application.
	 */
	public OptionWindow() {
		initialize();
		option_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		option_frame = new JFrame();
		option_frame.setBounds(100, 100, 450, 300);
		option_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
