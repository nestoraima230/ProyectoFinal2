package classView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import authControllers.classControllers;


public class ClassCreate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField txtYyyymmddHhmmss;
    private classControllers controller;


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
        controller = new classControllers(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 121, 150));
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(182, 10, 369, 472);
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Instructor (ID)");
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
		lblNewLabel_1_2.setBounds(173, 324, 146, 32);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		
		txtYyyymmddHhmmss = new JTextField();
		txtYyyymmddHhmmss.setText("yyyy-MM-dd HH:mm:ss");
		txtYyyymmddHhmmss.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		txtYyyymmddHhmmss.setBounds(164, 361, 135, 32);
		panel_2.add(txtYyyymmddHhmmss);
		txtYyyymmddHhmmss.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBounds(194, 418, 93, 32);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Crea una clase");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
		lblNewLabel.setBounds(61, 21, 226, 25);
		panel_2.add(lblNewLabel);
		
		JButton btnRegresar = new JButton("Salir");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClassRecords.main(new String[0]);
			}
		});
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnRegresar.setBackground(Color.BLACK);
		btnRegresar.setBounds(37, 418, 93, 32);
		panel_2.add(btnRegresar);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                String fechaHora = txtYyyymmddHhmmss.getText();
                String duracion = textField_1.getText();
                String instructorId = textField_2.getText();
                String capacidadMaxima = textField_4.getText();

                if (fechaHora.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.util.Date parsedFechaHora = sdf.parse(fechaHora);
                        Timestamp fechaHoraTimestamp = new Timestamp(parsedFechaHora.getTime());

                        boolean saved = controller.addClase(nombre, fechaHoraTimestamp, Time.valueOf(duracion), Integer.parseInt(instructorId), Integer.parseInt(capacidadMaxima));
                        if (saved) {
                            JOptionPane.showMessageDialog(frame, "¡La clase se ha guardado exitosamente!");
                            frame.dispose();
                            ClassRecords.main(new String[0]);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Error al guardar la clase. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al convertir la fecha y hora a formato de Timestamp. Por favor, introduzca ambos en el formato correcto (yyyy-MM-dd HH:mm:ss).", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al convertir instructorId o capacidadMaxima a entero. Por favor, asegúrese de introducir números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "El formato de la fecha y hora es incorrecto. Por favor, introduzca ambos en el formato correcto (yyyy-MM-dd HH:mm:ss).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
	}
}
