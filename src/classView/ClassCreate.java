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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ClassCreate {

    private JFrame frame;
    private JTextField textFieldNombre;
    private JTextField textFieldHorario;
    private JTextField textFieldDuracion;
    private JTextField textFieldInstructorId;
    private JTextField textFieldCapacidadMaxima;
    private classControllers controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClassCreate window = new ClassCreate();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClassCreate() {
        controller = new classControllers(); 
        initialize();
    }

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
        
        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(10, 73, 250, 32);
        panel_1.add(textFieldNombre);
        textFieldNombre.setColumns(10);
        
        textFieldHorario = new JTextField();
        textFieldHorario.setColumns(10);
        textFieldHorario.setBounds(10, 148, 250, 32);
        panel_1.add(textFieldHorario);
        
        JLabel lblNewLabel_1_1 = new JLabel("Horario");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(10, 116, 250, 32);
        panel_1.add(lblNewLabel_1_1);
        
        textFieldDuracion = new JTextField();
        textFieldDuracion.setColumns(10);
        textFieldDuracion.setBounds(10, 227, 250, 32);
        panel_1.add(textFieldDuracion);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Duracion");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(10, 195, 250, 32);
        panel_1.add(lblNewLabel_1_1_1);
        
        textFieldInstructorId = new JTextField();
        textFieldInstructorId.setColumns(10);
        textFieldInstructorId.setBounds(10, 302, 250, 32);
        panel_1.add(textFieldInstructorId);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Instructor ID");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(10, 270, 250, 32);
        panel_1.add(lblNewLabel_1_1_1_1);
        
        textFieldCapacidadMaxima = new JTextField();
        textFieldCapacidadMaxima.setColumns(10);
        textFieldCapacidadMaxima.setBounds(10, 370, 250, 32);
        panel_1.add(textFieldCapacidadMaxima);
        
        JLabel lblNewLabel_1_2 = new JLabel("Capacidad Maxima");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(10, 338, 250, 32);
        panel_1.add(lblNewLabel_1_2);
        
        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(10, 460, 100, 32);
        panel_1.add(btnNewButton);
        
        JButton btnCrear = new JButton("Guardar");
        btnCrear.setBounds(360, 460, 100, 32);
        panel_1.add(btnCrear);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 193, 511);
        panel.add(lblNewLabel);
        
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
    }
}
