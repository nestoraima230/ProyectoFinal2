package tariffView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import authControllers.tariffControllers;
import clientView.ClientEdit;

public class TariffEdit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
    private tariffControllers controller;


	/**
	 * Launch the application.
	 */
	
    public static void main(String[] args) {
        if (args.length > 0) {
            int tariffId = Integer.parseInt(args[0]);
            EventQueue.invokeLater(() -> {
                try {
                	TariffEdit window = new TariffEdit(tariffId); 
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public TariffEdit(int tariffId) {
		controller = new tariffControllers();
		initialize();
		cargarInformacionTarifa(tariffId);
	}


    private void cargarInformacionTarifa(int tariffId) {
        List<String> clienteDetails = controller.getTariff(tariffId);
        if (!clienteDetails.isEmpty()) {
        	textField_5.setText(clienteDetails.get(0)); 
        	textField.setText(clienteDetails.get(1));
        	textField_3.setText(clienteDetails.get(2));
        	textField_1.setText(clienteDetails.get(3));
            textField_2.setText(clienteDetails.get(4));
            textField_4.setText(clienteDetails.get(5));
            

        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 686, 513);
		panel.setBackground(new Color(148, 121, 150));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(97, 45, 524, 397);
		panel.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField.setBounds(77, 80, 147, 28);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cliente ID");
		lblNewLabel.setBounds(77, 59, 155, 13);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));

		JLabel lblNewLabel_1 = new JLabel("Cuota mensual");
		lblNewLabel_1.setBounds(77, 145, 155, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_2.setBounds(77, 168, 147, 28);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fecha inicial");
		lblNewLabel_2.setBounds(77, 240, 147, 13);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("Fecha final");
		lblNewLabel_3.setBounds(257, 241, 149, 13);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_3.setBounds(77, 276, 141, 28);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		textField_1.setBounds(257, 276, 185, 28);
		panel_1.add(textField_1);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(365, 359, 96, 28);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));

		JLabel lblNewLabel_4 = new JLabel("Editar tarifa de gimnasio");
		lblNewLabel_4.setBounds(118, 10, 384, 36);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 33));

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());

				boolean success = controller.deleteTariff(id);
				if (success) {
					JOptionPane.showMessageDialog(frame, "Tarifa eliminada correctamente.");
					
				} else {
					JOptionPane.showMessageDialog(frame, "Error al eliminar la tarifa. Por favor, inténtelo de nuevo.");
				}
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(242, 359, 96, 28);
		panel_1.add(btnEliminar);

		JLabel lblNewLabel_1_1 = new JLabel("Nombre de la tarifa");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(257, 59, 204, 13);
		panel_1.add(lblNewLabel_1_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBounds(257, 80, 185, 28);
		panel_1.add(textField_4);

		JLabel lblNewLabel_1_2 = new JLabel("Tarifa ID");
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(257, 146, 204, 13);
		panel_1.add(lblNewLabel_1_2);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBounds(257, 172, 185, 28);
		panel_1.add(textField_5);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField_5.getText());
				int clienteId = Integer.parseInt(textField.getText());
				Date fechaInicial = java.sql.Date.valueOf(textField_3.getText());
				Date fechaFinal = java.sql.Date.valueOf(textField_1.getText());
				double costo = Double.parseDouble(textField_2.getText());
				String nombre = textField_4.getText();

				boolean success = controller.updateTariff(id, clienteId, fechaInicial, fechaFinal, costo, nombre);
				if (success) {
					JOptionPane.showMessageDialog(frame, "Tarifa actualizada correctamente.");
					frame.dispose();
	                 TariffPanel.main(new String[0]);
				} else {
					JOptionPane.showMessageDialog(frame,
							"Error al actualizar la tarifa. Por favor, inténtelo de nuevo.");
				}
			}
		});
	}

}