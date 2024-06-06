package classView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ClassCreate {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_3;

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
        panel_1.setBounds(197, 0, 487, 511);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Clase");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 41, 250, 32);
        panel_1.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(10, 73, 250, 32);
        panel_1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 148, 250, 32);
        panel_1.add(textField_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Duracion");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(10, 116, 250, 32);
        panel_1.add(lblNewLabel_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 227, 250, 32);
        panel_1.add(textField_2);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Instructor");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(10, 195, 250, 32);
        panel_1.add(lblNewLabel_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(10, 302, 250, 32);
        panel_1.add(textField_4);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Capacidad");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(10, 270, 250, 32);
        panel_1.add(lblNewLabel_1_1_1_1);
        
        JButton btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(10, 460, 100, 32);
        panel_1.add(btnNewButton);
        
        JButton btnCrear = new JButton("Guardar");
        btnCrear.setBounds(360, 460, 100, 32);
        panel_1.add(btnCrear);
        
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
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 193, 511);
        panel.add(lblNewLabel);
    }

    public static Window getFrame() {
        return null;
    }

    public JButton getBtnGuardar() {
        return null;
    }
}
