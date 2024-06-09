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

import instructorsControllers.AddInstructorController;
import javax.swing.border.MatteBorder;

import classView.ClassRecords;

import javax.swing.border.BevelBorder;

public class InstructorCreate extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField especialidad;
    private JTextField email;
    private AddInstructorController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddInstructorController controller = new AddInstructorController();
                InstructorCreate window = controller.getView();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public InstructorCreate(AddInstructorController controller) {
        this.controller = controller;
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
        lblNewLabel_1.setBounds(29, 56, 117, 25);
        panel_2.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));

        nombre = new JTextField();
        nombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        nombre.setBackground(new Color(255, 255, 255));
        nombre.setBounds(29, 91, 327, 32);
        nombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(nombre);
        nombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
        lblNewLabel_1_1.setBounds(29, 133, 250, 32);
        panel_2.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));

        apellido = new JTextField();
        apellido.setBackground(new Color(255, 255, 255));
        apellido.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        apellido.setBounds(29, 175, 327, 32);
        panel_2.add(apellido);
        apellido.setColumns(10);
        apellido.setOpaque(true);
        apellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        apellido.setPreferredSize(new Dimension(100, 20));

        especialidad = new JTextField();
        especialidad.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        especialidad.setBounds(29, 259, 327, 32);
        especialidad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(especialidad);
        especialidad.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Especialidad");
        lblNewLabel_1_1_1.setBounds(29, 217, 250, 32);
        panel_2.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo electronico");
        lblNewLabel_1_1_1_1.setBounds(29, 301, 250, 32);
        panel_2.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));

        email = new JTextField();
        email.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        email.setBounds(29, 334, 327, 32);
        email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_2.add(email);
        email.setColumns(10);

        JLabel lblNewLabel = new JLabel("Crear instructor");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
        lblNewLabel.setBounds(91, 10, 256, 25);
        panel_2.add(lblNewLabel);

        JButton btnCrear = new JButton("Guardar");
        btnCrear.setForeground(new Color(255, 255, 255));
        btnCrear.setBackground(new Color(0, 0, 0));
        btnCrear.setBounds(261, 400, 100, 32);
        panel_2.add(btnCrear);
        btnCrear.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnCrear.addActionListener(e -> {
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

            boolean success = controller.addInstructor(nombreText, apellidoText, especialidadText, emailText);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Instructor agregado exitosamente!");
                frame.dispose();
                ConsultRecords.main(new String[0]);
            } else {
                JOptionPane.showMessageDialog(frame, "Error al agregar instructor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}