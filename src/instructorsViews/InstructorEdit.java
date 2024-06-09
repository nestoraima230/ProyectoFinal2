package instructorsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import authControllers.instructorControllers;
import clientView.ClientEdit;

import javax.swing.border.MatteBorder;

public class InstructorEdit extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField especialidad;
    private JTextField email;
    private instructorControllers controller;
    private int instructorId;
    private JTextField textField;

   
    public static void main(String[] args) {
        if (args.length > 0) {
            int instructorId = Integer.parseInt(args[0]);
            EventQueue.invokeLater(() -> {
                try {
                    InstructorEdit window = new InstructorEdit(instructorId); 
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

	public InstructorEdit(int instructorId) {
        controller = new instructorControllers(); 
        initialize();
        cargarInformacionInstructor(instructorId);
	}
	
	private void cargarInformacionInstructor(int instructorId) {
	    List<String> instructorDetails = controller.getInstructorDetails(instructorId);
	    if (instructorDetails.size() >= 5) { // Verifica que la lista tenga al menos 5 elementos
	        nombre.setText(instructorDetails.get(0)); 
	        apellido.setText(instructorDetails.get(2));
	        especialidad.setText(instructorDetails.get(3));
	        email.setText(instructorDetails.get(4));
	        textField.setText(instructorDetails.get(1));
	        


	    }
	}

	
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 684, 511);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBounds(0, 0, 684, 511);
        panel_1.setBackground(new Color(148, 121, 150));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_2.setBounds(155, 27, 409, 454);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setBounds(29, 56, 70, 25);
        panel_2.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        nombre = new JTextField();
        nombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        nombre.setBackground(new Color(255, 255, 255));
        nombre.setBounds(29, 91, 338, 32);
        nombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(nombre);
        nombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
        lblNewLabel_1_1.setBounds(29, 133, 250, 32);
        panel_2.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        apellido = new JTextField();
        apellido.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        apellido.setBounds(29, 175, 338, 32);
        panel_2.add(apellido);
        apellido.setColumns(10);
        apellido.setOpaque(true);
        apellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        
        apellido.setPreferredSize(new Dimension(100, 20));

        especialidad = new JTextField();
        especialidad.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        especialidad.setBounds(29, 259, 338, 32);
        especialidad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(especialidad);
        especialidad.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Especialidad");
        lblNewLabel_1_1_1.setBounds(29, 217, 250, 32);
        panel_2.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo electronico");
        lblNewLabel_1_1_1_1.setBounds(29, 301, 250, 32);
        panel_2.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        email = new JTextField();
        email.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        email.setBounds(29, 334, 338, 32);
        email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(email);
        email.setColumns(10);

        JLabel lblNewLabel = new JLabel("Editar instructor");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        lblNewLabel.setBounds(111, 10, 256, 25);
        panel_2.add(lblNewLabel);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(new Color(255, 255, 255));
        btnGuardar.setBackground(new Color(0, 0, 0));
        btnGuardar.setBounds(267, 398, 100, 32);
        panel_2.add(btnGuardar);
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        
                JButton btnEliminar = new JButton("Eliminar");
                btnEliminar.setForeground(new Color(255, 255, 255));
                btnEliminar.setBackground(new Color(0, 0, 0));
                btnEliminar.setBounds(29, 399, 100, 32);
                panel_2.add(btnEliminar);
                btnEliminar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
                
                textField = new JTextField();
                textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
                textField.setColumns(10);
                textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
                textField.setBounds(126, 373, 143, 25);
                panel_2.add(textField);
                
                
                btnEliminar.addActionListener(e -> {
                	
                	instructorId = obtenerIdInstructor();
                    try {
                        boolean success = controller.deleteInstructor(instructorId);
                        if (success) {
                            JOptionPane.showMessageDialog(frame, "Instructor eliminado exitosamente!");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Error al eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Exception occurred while deleting instructor.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

                btnGuardar.addActionListener(e -> {
                    String nombreText = nombre.getText();
                    String apellidoText = apellido.getText();
                    String especialidadText = especialidad.getText();
                    String emailText = email.getText();
                    String instructorIdText = textField.getText();

                    if (nombreText.isEmpty() || apellidoText.isEmpty() || especialidadText.isEmpty() || emailText.isEmpty() || instructorIdText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (nombreText.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(frame, "El nombre no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (apellidoText.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(frame, "El apellido no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (especialidadText.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(frame, "La especialidad no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int instructorId;
                    try {
                        instructorId = Integer.parseInt(instructorIdText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "El ID del instructor debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean success = controller.updateInstructor(instructorId, nombreText, apellidoText, especialidadText, emailText);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "¡Instructor actualizado exitosamente!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error al actualizar el instructor.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

    }

	private int obtenerIdInstructor() {
		
		return Integer.parseInt(textField.getText());
	}
	
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public JFrame getFrame() {
        return frame;
    }
}