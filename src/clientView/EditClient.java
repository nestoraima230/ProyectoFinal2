package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class EditClient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClient window = new EditClient();
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
	public EditClient() {
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
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblNewLabel.setBounds(61, 48, 105, 21);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Telefono");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_1.setBounds(61, 125, 105, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblNewLabel_2.setBounds(61, 186, 196, 21);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(61, 71, 326, 29);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 147, 326, 29);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(61, 210, 65, 29);
		panel.add(textField_2);

		JLabel lblNewLabel_3 = new JLabel("Imagen");
		lblNewLabel_3.setIcon(new ImageIcon(EditClient.class.getResource("/ImagenesGym/mujerFoto.png")));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(500, 71, 141, 168);
		lblNewLabel_3.setOpaque(true);
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(322, 210, 65, 29);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(204, 210, 65, 29);
		panel.add(textField_4);

		Object[][] data = { { "Alejandro Perez", "$290", "Sí" }, { "Hannia Ruiz", "$450", "No" },
				{ "Ruben Alejandro", "$200", "No" } };

		String[] columnNames = { "Entrenador", "Pagos", "Asistencia" };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		table.setBounds(61, 271, 576, 150);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(61, 271, 576, 150);
		panel.add(scrollPane);

		btnNewButton = new JButton("Credencial");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnNewButton.setBounds(61, 451, 128, 21);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Reporte");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnNewButton_1.setBounds(279, 451, 150, 21);
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("OK");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnNewButton_2.setBounds(521, 451, 113, 21);
		panel.add(btnNewButton_2);

		lblNewLabel_4 = new JLabel("Entrenador");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBounds(61, 258, 190, 13);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Pagos");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNewLabel_5.setBounds(250, 259, 190, 13);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Asistencia");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNewLabel_6.setBounds(440, 258, 194, 13);
		panel.add(lblNewLabel_6);
	}

	public void show() {
		// TODO Auto-generated method stub
		
	}
}
