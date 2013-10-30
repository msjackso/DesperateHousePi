package desperatehousepi.GUI;

import javax.swing.JFrame;

public class LoadWindow {

	private JFrame load_frame;

	/**
	 * Create the application.
	 */
	public LoadWindow() {
		initialize();
		load_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		load_frame = new JFrame();
		load_frame.setTitle("Load Window");
		load_frame.setBounds(100, 100, 450, 300);
		load_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
