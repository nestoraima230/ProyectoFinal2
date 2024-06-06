package clientView;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class ClientDetail {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldBirthDay;
	private JTextField textFieldBirthMonth;
	private JTextField textFieldBirthYear;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDetail window = new ClientDetail();
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
	public ClientDetail() {
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
		panel.setBounds(0, 0, 686, 513);
		panel.setBackground(new Color(148, 121, 150));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblName.setBounds(61, 48, 105, 21);
		panel.add(lblName);

		JLabel lblPhone = new JLabel("Telefono");
		lblPhone.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblPhone.setBounds(61, 125, 105, 21);
		panel.add(lblPhone);

		JLabel lblBirthDate = new JLabel("Fecha de nacimiento");
		lblBirthDate.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		lblBirthDate.setBounds(61, 186, 196, 21);
		panel.add(lblBirthDate);

		textFieldName = new JTextField();
		textFieldName.setBounds(61, 71, 326, 29);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(61, 147, 326, 29);
		panel.add(textFieldPhone);

		textFieldBirthDay = new JTextField();
		textFieldBirthDay.setColumns(10);
		textFieldBirthDay.setBounds(61, 210, 65, 29);
		panel.add(textFieldBirthDay);

		JLabel lblImage = new JLabel("Imagen");
		lblImage.setIcon(new ImageIcon(ClientDetail.class.getResource("/ImagenesGym/mujerFoto.png")));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(500, 71, 141, 168);
		lblImage.setOpaque(true);
		panel.add(lblImage);

		textFieldBirthMonth = new JTextField();
		textFieldBirthMonth.setColumns(10);
		textFieldBirthMonth.setBounds(204, 210, 65, 29);
		panel.add(textFieldBirthMonth);

		textFieldBirthYear = new JTextField();
		textFieldBirthYear.setColumns(10);
		textFieldBirthYear.setBounds(322, 210, 65, 29);
		panel.add(textFieldBirthYear);

		Object[][] data = {
			{ "Alejandro Perez", "$290", "Sí" },
			{ "Hannia Ruiz", "$450", "No" },
			{ "Ruben Alejandro", "$200", "No" }
		};

		String[] columnNames = { "Entrenador", "Pagos", "Asistencia" };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(61, 271, 576, 150);
		panel.add(scrollPane);

		JButton btnCredencial = new JButton("Credencial");
		btnCredencial.setBackground(new Color(255, 255, 255));
		btnCredencial.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnCredencial.setBounds(61, 451, 128, 21);
		panel.add(btnCredencial);
		
		btnCredencial.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	frame.dispose();
		        Credential credentialWindow = new Credential();
		        credentialWindow.getFrame().setVisible(true); 
		    }
		});

		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.setBackground(new Color(255, 255, 255));
		btnReporte.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnReporte.setBounds(279, 451, 150, 21);
		panel.add(btnReporte);

		btnReporte.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	ClientReport ClientReportWindow = new ClientReport();
		    	ClientReportWindow.getFrame().setVisible(true); 
		    }
		});

		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnOk.setBounds(521, 451, 113, 21);
		panel.add(btnOk);

		JLabel lblTrainer = new JLabel("Entrenador");
		lblTrainer.setForeground(new Color(255, 255, 255));
		lblTrainer.setBackground(new Color(0, 0, 0));
		lblTrainer.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblTrainer.setOpaque(true);
		lblTrainer.setBounds(61, 258, 190, 13);
		panel.add(lblTrainer);

		JLabel lblPayments = new JLabel("Pagos");
		lblPayments.setForeground(new Color(255, 255, 255));
		lblPayments.setBackground(new Color(0, 0, 0));
		lblPayments.setOpaque(true);
		lblPayments.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblPayments.setBounds(250, 259, 190, 13);
		panel.add(lblPayments);

		JLabel lblAttendance = new JLabel("Asistencia");
		lblAttendance.setBackground(new Color(0, 0, 0));
		lblAttendance.setForeground(new Color(255, 255, 255));
		lblAttendance.setOpaque(true);
		lblAttendance.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblAttendance.setBounds(440, 258, 194, 13);
		panel.add(lblAttendance);
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
