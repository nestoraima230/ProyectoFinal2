package instructorsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import instructorsControllers.EditInstructorController;
import javax.swing.ImageIcon;

public class InstructorEdit extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField especialidad;
    private JTextField email;
    private EditInstructorController controller;
    private int instructorId;

    public static void main(String[] args) {
        int instructorId = 2;

        if (args.length > 0) {
            try {
                instructorId = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid instructor ID. Using default ID 2."); // SOLO RECIBE IDs
            }
        }

        final int finalInstructorId = instructorId;
        EventQueue.invokeLater(() -> {
            try {
                EditInstructorController controller = new EditInstructorController();
                controller.showView(finalInstructorId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public InstructorEdit(EditInstructorController controller, int id) {
        this.controller = controller;
        this.instructorId = id;
        initialize();
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
        panel_1.setBounds(0, 0, 684, 511);
        panel_1.setBackground(new Color(148, 121, 150));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(155, 27, 409, 454);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setBounds(29, 56, 70, 25);
        panel_2.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        nombre = new JTextField();
        nombre.setBackground(new Color(255, 255, 255));
        nombre.setBounds(29, 91, 338, 32);
        panel_2.add(nombre);
        nombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
        lblNewLabel_1_1.setBounds(29, 133, 250, 32);
        panel_2.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        apellido = new JTextField();
        apellido.setBounds(29, 175, 338, 32);
        panel_2.add(apellido);
        apellido.setColumns(10);
        apellido.setOpaque(true);
        apellido.setBorder(new EmptyBorder(0, 5, 0, 2));
        apellido.setPreferredSize(new Dimension(100, 20));

        especialidad = new JTextField();
        especialidad.setBounds(29, 259, 338, 32);
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
        email.setBounds(29, 334, 338, 32);
        panel_2.add(email);
        email.setColumns(10);

        JLabel lblNewLabel = new JLabel("Editar instructor");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
        lblNewLabel.setBounds(111, 10, 256, 25);
        panel_2.add(lblNewLabel);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setForeground(new Color(255, 255, 255));
        btnGuardar.setBackground(new Color(0, 0, 0));
        btnGuardar.setBounds(265, 412, 100, 32);
        panel_2.add(btnGuardar);
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        
                JButton btnEliminar = new JButton("Eliminar");
                btnEliminar.setForeground(new Color(255, 255, 255));
                btnEliminar.setBackground(new Color(0, 0, 0));
                btnEliminar.setBounds(29, 412, 100, 32);
                panel_2.add(btnEliminar);
                btnEliminar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
                btnEliminar.addActionListener(e -> {
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

            if (nombreText.isEmpty() || apellidoText.isEmpty() || especialidadText.isEmpty() || emailText.isEmpty()) {
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

            boolean success = controller.updateInstructor(instructorId, nombreText, apellidoText, especialidadText, emailText);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Instructor actualizado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(frame, "Error al actualizar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public JFrame getFrame() {
        return frame;
    }
}
