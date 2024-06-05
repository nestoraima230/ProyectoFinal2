package check;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class CheckPin {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckPin window = new CheckPin();
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
	public CheckPin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(292, 239, 100, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(31, 462, 100, 32);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ingrese su PIN");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(240, 196, 205, 32);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.setBounds(292, 295, 100, 32);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CheckPin.class.getResource("/ImagenesGym/chicoenGymIcono.jpg")));
		lblNewLabel_1.setBounds(0, 0, 684, 511);
		panel.add(lblNewLabel_1);
	}

}
