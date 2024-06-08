package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NewClient {

	JFrame frame;
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(143, 24, 382, 453);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(35, 110, 208, 28);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(35, 82, 105, 13);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		
		JLabel lblNewLabel_7 = new JLabel("Crear cliente");
		lblNewLabel_7.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblNewLabel_7.setBounds(123, 23, 208, 37);
		panel_1.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(35, 186, 208, 28);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(35, 163, 105, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		
		textField_5 = new JTextField();
		textField_5.setBounds(45, 245, 59, 28);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 245, 59, 28);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(224, 245, 59, 28);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
		lblNewLabel_2.setBounds(28, 222, 200, 13);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(26, 293, 179, 13);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		
		textField_2 = new JTextField();
		textField_2.setBounds(35, 316, 208, 28);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setBounds(28, 354, 45, 13);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		
		JLabel lblNewLabel_6 = new JLabel("$");
		lblNewLabel_6.setBounds(83, 354, 85, 13);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(253, 56, 113, 158);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(NewClient.class.getResource("/ImagenesGym/mujerFoto.png")));
		lblNewLabel_5.setOpaque(true);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(264, 411, 95, 31);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Subir foto");
		btnNewButton.setBounds(28, 411, 105, 32);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 0, 0));

	}

}
