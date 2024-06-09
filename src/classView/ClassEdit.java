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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import authControllers.classControllers;
import clientView.ClientDetail;


public class ClassEdit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private classControllers controller;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        if (args.length > 0) {
            int classId = Integer.parseInt(args[0]);
            EventQueue.invokeLater(() -> {
                try {
                	ClassEdit window = new ClassEdit(classId);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }


	/**
	 * Create the application.
	 */
	public ClassEdit(int classId) {
        initialize();
        controller = new classControllers(); 
        cargarInformacionClase(classId);

	}
	
	private void cargarInformacionClase(int classId) {
	    List<String> classDetails = controller.getDetallesClase(classId);
	    if (!classDetails.isEmpty()) {
	        textField.setText(classDetails.get(1));
	        textField_1.setText(classDetails.get(2));
	        textField_2.setText(controller.getNombreInstructor(Integer.parseInt(classDetails.get(5))));
	        textField_3.setText(classDetails.get(3));
	        textField_4.setText(classDetails.get(4));
	        textField_5.setText(classDetails.get(0));
	        
	        String fechaHora = classDetails.get(3);
	        if (fechaHora != null && fechaHora.contains(".")) {
	            fechaHora = fechaHora.substring(0, fechaHora.indexOf('.'));
	        }
	        textField_3.setText(fechaHora);
	    }
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
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(148, 121, 150));
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(135, 29, 436, 453);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clase");
		lblNewLabel_1.setBounds(25, 104, 135, 25);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setBounds(25, 139, 172, 32);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Duración");
		lblNewLabel_1_1.setBounds(223, 97, 250, 32);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 139, 172, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Instructor");
		lblNewLabel_1_1_1.setBounds(25, 181, 250, 32);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 221, 172, 32);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Capacidad");
		lblNewLabel_1_1_1_1.setBounds(223, 181, 250, 32);
		panel_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_4 = new JTextField();
		textField_4.setBounds(223, 221, 172, 32);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Horario");
		lblNewLabel_1_2.setBounds(25, 279, 250, 32);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_3 = new JTextField();
		textField_3.setBounds(22, 321, 373, 32);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBounds(302, 400, 93, 32);
		panel_2.add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setBounds(190, 275, 52, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textField.getText();
                String duracion = textField_1.getText();
                String instructorId = textField_2.getText();
                String capacidadMaxima = textField_4.getText();
                String fechaHora = textField_3.getText();
                String claseId = textField_5.getText(); 
                
                if (fechaHora.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.util.Date parsedFechaHora = sdf.parse(fechaHora);
                        Timestamp fechaHoraTimestamp = new Timestamp(parsedFechaHora.getTime());
                        
                        fechaHoraTimestamp.setNanos(0);


                        boolean saved = controller.updateClase(nombre, fechaHoraTimestamp, Time.valueOf(duracion), Integer.parseInt(instructorId), Integer.parseInt(capacidadMaxima), Integer.parseInt(claseId));
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
		btnEliminar.setBounds(163, 400, 93, 32);
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
				
		JLabel lblNewLabel = new JLabel("Editar clase");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 34));
		lblNewLabel.setBounds(134, 10, 233, 48);
		panel_2.add(lblNewLabel);
		



	}
	
	private int obtenerIdClase() {
		
		return Integer.parseInt(textField_5.getText());
	}
	
    private void limpiarCampos() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
    }


}