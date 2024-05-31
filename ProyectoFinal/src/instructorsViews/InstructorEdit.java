package instructorsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import instructorsControllers.EditInstructorController;

public class InstructorEdit extends JPanel {

    private static final long serialVersionUID = 1L;

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private EditInstructorController controller;
    private int instructorId; 

    public static void main(String[] args) {
        int instructorId = 2; 

        if (args.length > 0) {
            try {
                instructorId = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid instructor ID. Using default ID 2.");  //SOLO RECIBE IDs
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
        panel_1.setBounds(251, 0, 433, 511);
        panel_1.setBackground(new Color(148, 121, 150));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(24, 39, 250, 32);
        panel_1.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(24, 81, 250, 32);
        panel_1.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(24, 158, 250, 32);
        textField_1.setOpaque(true);
        textField_1.setBorder(new EmptyBorder(0, 5, 0, 2));
        textField_1.setPreferredSize(new Dimension(100, 20));
        panel_1.add(textField_1);

        JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(24, 116, 250, 32);
        panel_1.add(lblNewLabel_1_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(24, 241, 250, 32);
        panel_1.add(textField_2);

        JLabel lblNewLabel_1_1_1 = new JLabel("Especialidad");
        lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(24, 200, 250, 32);
        panel_1.add(lblNewLabel_1_1_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(24, 325, 250, 32);
        panel_1.add(textField_4);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo electronico");
        lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(24, 283, 250, 32);
        panel_1.add(lblNewLabel_1_1_1_1);

        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InstructorPanel instructorPanel = new InstructorPanel();
				instructorPanel.getFrame().setVisible(true);          
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(26, 460, 100, 32);
        panel_1.add(btnNewButton);

        JButton btnCrear = new JButton("Guardar");
        btnCrear.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCrear.setBounds(295, 460, 100, 32);
        panel_1.add(btnCrear);

        btnCrear.addActionListener(e -> {
            try {
                String nombre = textField.getText();
                String apellidos = textField_1.getText();
                String especialidad = textField_2.getText();
                String email = textField_4.getText();

                boolean success = controller.updateInstructor(instructorId, nombre, apellidos, especialidad, email);
                if (success) {
                    System.out.println("Instructor actualizado exitosamente!");
                } else {
                    System.out.println("Error al actualizar usuario.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Exception occurred while updating instructor.");
            }
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEliminar.setBounds(157, 460, 100, 32);
        btnEliminar.addActionListener(e -> {
            try {
                boolean success = controller.deleteInstructor(instructorId);
                if (success) {
                    System.out.println("Instructor eliminado exitosamente !");
                } else {
                    System.out.println("Error al eliminar.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Exception");
            }
        });
        panel_1.add(btnEliminar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InstructorEdit.class.getResource("/ImagenesGym/instructorGymChikito.jpg")));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 252, 511);
        panel.add(lblNewLabel);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
