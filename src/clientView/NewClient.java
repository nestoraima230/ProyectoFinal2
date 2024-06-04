package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NewClient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewClient window = new NewClient();
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
	public NewClient() {
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
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel.setBounds(59, 59, 105, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(59, 134, 105, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_2.setBounds(59, 205, 200, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_3.setBounds(59, 274, 179, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_4.setBounds(59, 359, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(NewClient.class.getResource("/ImagenesGym/mujerFoto.png")));
		lblNewLabel_5.setBounds(493, 80, 143, 207);
		lblNewLabel_5.setOpaque(true);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(59, 82, 296, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(59, 157, 296, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(59, 297, 296, 28);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(200, 228, 59, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(296, 228, 59, 28);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(105, 228, 59, 28);
		panel.add(textField_5);
		
		JButton btnNewButton = new JButton("Subir foto");
		btnNewButton.setBounds(59, 431, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBounds(270, 431, 85, 21);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("$");
		lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(135, 361, 85, 13);
		panel.add(lblNewLabel_6);

	}

}
