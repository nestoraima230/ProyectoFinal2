package check;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

import MainView.MainWindows;
//import classView.ClassDetail;

public class CheckPin {
	private JFrame frame;
	private JTextField textField;
	private JButton btnIngresar;
	private String pin = "1234";

	public CheckPin() {
		initialize();
		attachListeners();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); 
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 511);
		panel.setBackground(new Color(148, 121, 150));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(196, 77, 320, 358);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(160, 5, 0, 0);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Ingrese su PIN");
		lblNewLabel.setBounds(60, 84, 205, 32);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setBounds(98, 149, 124, 32);
		panel_1.add(textField);
		textField.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(0, 0, 0));
		btnIngresar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnIngresar.setBounds(120, 209, 89, 32);
		panel_1.add(btnIngresar);

		frame.setVisible(true);
	}

	private void attachListeners() {
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputPin = textField.getText().trim();

				if (inputPin.equals(pin)) {
					JOptionPane.showMessageDialog(frame, "PIN correcto. Acceso concedido.");
					 frame.dispose();
		                MainWindows MainWindows = new MainWindows();
		                MainWindows.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(frame, "PIN incorrecto. Por favor, inténtelo de nuevo.");
					textField.setText("");
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
}