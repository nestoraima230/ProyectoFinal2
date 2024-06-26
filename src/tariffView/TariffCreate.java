package tariffView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class TariffCreate {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TariffCreate window = new TariffCreate();
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
	public TariffCreate() {
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
		panel_1.setBounds(141, 45, 414, 397);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField.setBounds(76, 99, 240, 28);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cliente ID");
		lblNewLabel.setBounds(76, 76, 155, 28);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Cuota mensual");
		lblNewLabel_1.setBounds(76, 156, 155, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_2.setBounds(76, 181, 240, 28);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha inicial");
		lblNewLabel_2.setBounds(76, 240, 147, 13);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		
		JLabel lblNewLabel_3 = new JLabel("Fecha final");
		lblNewLabel_3.setBounds(220, 241, 135, 13);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_3.setBounds(76, 263, 96, 28);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(220, 263, 96, 28);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(291, 347, 96, 28);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Crear tarifa de gimnasio");
		lblNewLabel_4.setBounds(72, 21, 301, 45);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 33));
	}

}
