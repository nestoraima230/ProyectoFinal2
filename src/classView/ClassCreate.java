package classView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class ClassCreate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassCreate window = new ClassCreate();
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
	public ClassCreate() {
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
		panel.setBackground(new Color(148, 121, 150));
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(182, 10, 333, 472);
		panel.add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clase");
		lblNewLabel_1.setBounds(37, 76, 135, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField.setBounds(37, 111, 250, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duracion");
		lblNewLabel_1_1.setBounds(37, 164, 250, 32);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_1.setBounds(37, 206, 250, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Instructor");
		lblNewLabel_1_1_1.setBounds(37, 240, 250, 32);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_2.setBounds(37, 282, 250, 32);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Capacidad");
		lblNewLabel_1_1_1_1.setBounds(37, 324, 141, 32);
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_4.setBounds(37, 361, 105, 32);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Horario");
		lblNewLabel_1_2.setBounds(173, 324, 96, 32);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_3.setBounds(175, 361, 112, 32);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBounds(194, 418, 93, 32);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Crea una clase");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
		lblNewLabel.setBounds(61, 21, 226, 25);
		panel_2.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}

