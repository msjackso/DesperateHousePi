package desperatehousepi.GUI;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

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
		help_frame.getContentPane().setBackground(Color.GREEN);
		help_frame.setTitle("Help");
		help_frame.setBounds(100, 100, 450, 300);
		help_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		help_frame.getContentPane().setLayout(null);
		
		JButton btnOpenDoc = new JButton("Open Documentation");
		btnOpenDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("documentation.docx");
				try {
					java.awt.Desktop.getDesktop().edit(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnOpenDoc.setForeground(Color.WHITE);
		btnOpenDoc.setBackground(Color.RED);
		btnOpenDoc.setBounds(10, 11, 414, 107);
		help_frame.getContentPane().add(btnOpenDoc);
		
		JButton btnOpenQuickStart = new JButton("Open Quick Start Guide");
		btnOpenQuickStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("quickstart.docx");
				try {
					java.awt.Desktop.getDesktop().edit(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnOpenQuickStart.setForeground(Color.WHITE);
		btnOpenQuickStart.setBackground(Color.RED);
		btnOpenQuickStart.setBounds(10, 144, 414, 107);
		help_frame.getContentPane().add(btnOpenQuickStart);
	}
}
