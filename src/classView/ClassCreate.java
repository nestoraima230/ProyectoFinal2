package classView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import authControllers.classControllers;

import javax.swing.JTextField;
import java.awt.Font;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
import java.awt.Window;
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ClassCreate {

    private JFrame frame;
<<<<<<< HEAD
    private JTextField textFieldNombre;
    private JTextField textFieldHorario;
    private JTextField textFieldDuracion;
    private JTextField textFieldInstructorId;
    private JTextField textFieldCapacidadMaxima;
    private classControllers controller;

=======
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
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

<<<<<<< HEAD
    public ClassCreate() {
        controller = new classControllers(); 
        initialize();
    }

=======
    /**
     * Create the application.
     */
    public ClassCreate() {
        initialize();
    }
 

    /**
     * Initialize the contents of the frame.
     */
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
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
        panel_1.setBounds(197, 0, 487, 511);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Clase");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 41, 250, 32);
        panel_1.add(lblNewLabel_1);
        
<<<<<<< HEAD
        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(10, 73, 250, 32);
        panel_1.add(textFieldNombre);
        textFieldNombre.setColumns(10);
        
        textFieldHorario = new JTextField();
        textFieldHorario.setColumns(10);
        textFieldHorario.setBounds(10, 148, 250, 32);
        panel_1.add(textFieldHorario);
        
        JLabel lblNewLabel_1_1 = new JLabel("Horario");
=======
        textField = new JTextField();
        textField.setBounds(10, 73, 250, 32);
        panel_1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 148, 250, 32);
        panel_1.add(textField_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Duracion");
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(10, 116, 250, 32);
        panel_1.add(lblNewLabel_1_1);
        
<<<<<<< HEAD
        textFieldDuracion = new JTextField();
        textFieldDuracion.setColumns(10);
        textFieldDuracion.setBounds(10, 227, 250, 32);
        panel_1.add(textFieldDuracion);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Duracion");
=======
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 227, 250, 32);
        panel_1.add(textField_2);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Instructor");
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(10, 195, 250, 32);
        panel_1.add(lblNewLabel_1_1_1);
        
<<<<<<< HEAD
        textFieldInstructorId = new JTextField();
        textFieldInstructorId.setColumns(10);
        textFieldInstructorId.setBounds(10, 302, 250, 32);
        panel_1.add(textFieldInstructorId);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Instructor ID");
=======
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(10, 302, 250, 32);
        panel_1.add(textField_4);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Capacidad");
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(10, 270, 250, 32);
        panel_1.add(lblNewLabel_1_1_1_1);
        
<<<<<<< HEAD
        textFieldCapacidadMaxima = new JTextField();
        textFieldCapacidadMaxima.setColumns(10);
        textFieldCapacidadMaxima.setBounds(10, 370, 250, 32);
        panel_1.add(textFieldCapacidadMaxima);
        
        JLabel lblNewLabel_1_2 = new JLabel("Capacidad Maxima");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(10, 338, 250, 32);
        panel_1.add(lblNewLabel_1_2);
        
=======
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(10, 460, 100, 32);
        panel_1.add(btnNewButton);
        
        JButton btnCrear = new JButton("Guardar");
        btnCrear.setBounds(360, 460, 100, 32);
        panel_1.add(btnCrear);
        
<<<<<<< HEAD
        JLabel lblNewLabel = new JLabel("");
=======
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(10, 370, 250, 32);
        panel_1.add(textField_3);
        
        JLabel lblNewLabel_1_2 = new JLabel("Horario");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(10, 338, 250, 32);
        panel_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ClassCreate.class.getResource("/ImagenesGym/gymteacher Icono.png")));
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 193, 511);
        panel.add(lblNewLabel);
<<<<<<< HEAD
        
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String fechaHora = textFieldHorario.getText();
                String duracion = textFieldDuracion.getText();
                String instructorId = textFieldInstructorId.getText();
                String capacidadMaxima = textFieldCapacidadMaxima.getText();

                if (fechaHora.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        java.util.Date parsedFechaHora = sdf.parse(fechaHora);
                        Timestamp fechaHoraTimestamp = new Timestamp(parsedFechaHora.getTime());

                        boolean saved = controller.addClase(nombre, fechaHoraTimestamp, Time.valueOf(duracion), Integer.parseInt(instructorId), Integer.parseInt(capacidadMaxima));
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



        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // Agregar la acción para regresar a la vista anterior
            }
        });
=======
    }

    public static Window getFrame() {
        return null;
    }

    public JButton getBtnGuardar() {
        return null;
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
    }
}
