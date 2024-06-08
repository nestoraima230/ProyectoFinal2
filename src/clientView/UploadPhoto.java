package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UploadPhoto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadPhoto window = new UploadPhoto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UploadPhoto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 513);
		panel.setBackground(new Color(148, 121, 150));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(251, 132, 198, 248);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(UploadPhoto.class.getResource("/ImagenesGym/mujerFoto.png")));
		lblNewLabel_1.setBounds(37, 40, 130, 172);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Subiendo foto...");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel.setBounds(284, 401, 173, 13);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnNewButton.setBounds(302, 437, 85, 21);
		panel.add(btnNewButton);
	}

}
