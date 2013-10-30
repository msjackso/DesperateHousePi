package desperatehousepi.GUI;

import javax.swing.JFrame;

public class CreationWindow {

	private JFrame creation_frame;

	/**
	 * Create the application.
	 */
	public CreationWindow() {
		initialize();
		creation_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		creation_frame = new JFrame();
		creation_frame.setTitle("Create a new Crust");
		creation_frame.setBounds(100, 100, 450, 300);
		creation_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
