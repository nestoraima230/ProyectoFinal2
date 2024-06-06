package classView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import authControllers.classControllers;

public class ClassEdit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private classControllers controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassEdit window = new ClassEdit();
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
	public ClassEdit() {
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
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 121, 150));
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 121, 150));
		panel_1.setBounds(488, 29, 487, 511);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCrear = new JButton("Guardar");
		btnCrear.setBounds(360, 460, 100, 32);
		panel_1.add(btnCrear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(146, 29, 371, 472);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clase");
		lblNewLabel_1.setBounds(10, 34, 135, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setBounds(10, 69, 250, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duracion");
		lblNewLabel_1_1.setBounds(10, 111, 250, 32);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 153, 250, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Instructor");
		lblNewLabel_1_1_1.setBounds(10, 195, 250, 32);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 237, 250, 32);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Capacidad");
		lblNewLabel_1_1_1_1.setBounds(10, 279, 250, 32);
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 321, 250, 32);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Horario");
		lblNewLabel_1_2.setBounds(10, 353, 250, 32);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 395, 250, 32);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBounds(234, 437, 93, 32);
		panel_2.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textField.getText();
                String duracion = textField_1.getText();
                String instructorId = textField_2.getText();
                String capacidadMaxima = textField_4.getText();
                String fechaHora = textField_3.getText();
                
                if (fechaHora.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.util.Date parsedFechaHora = sdf.parse(fechaHora);
                        Timestamp fechaHoraTimestamp = new Timestamp(parsedFechaHora.getTime());

                        boolean saved = controller.updateClase(nombre, fechaHoraTimestamp, Time.valueOf(duracion), Integer.parseInt(instructorId), Integer.parseInt(capacidadMaxima), fechaHoraTimestamp);
                        if (saved) {
                            JOptionPane.showMessageDialog(frame, "¡La clase se ha guardado exitosamente!");
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(117, 437, 93, 32);
		panel_2.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int confirmacion = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que deseas eliminar esta clase?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		        
		        if (confirmacion == JOptionPane.YES_OPTION) {
		            int idClase = obtenerIdClase(); 
		            
		            boolean eliminada = controller.deleteClase(idClase);
		            
		            if (eliminada) {
		                JOptionPane.showMessageDialog(frame, "La clase ha sido eliminada exitosamente.");
		                limpiarCampos(); 
		            } else {
		                JOptionPane.showMessageDialog(frame, "Error al eliminar la clase. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});
		
		

	}
	
	private int obtenerIdClase() {
	
		return Integer.parseInt(textField_2.getText());
	}
	
    private void limpiarCampos() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
    }

	public void setVisible(boolean b) {
        frame.setVisible(true);
		
	}

}