package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import authControllers.clientControllers;
import classView.ClassDetail;

import javax.swing.border.MatteBorder;

public class NewClient {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private clientControllers controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewClient window = new NewClient();
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
    public NewClient() {
        controller = new clientControllers();
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
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField.setBounds(176, 82, 216, 28);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBounds(176, 157, 216, 28);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(176, 297, 216, 28);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(245, 228, 68, 28);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(323, 228, 69, 28);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(176, 228, 59, 28);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_5);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(145, 21, 399, 458);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBackground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(261, 48, 128, 156);
        panel_1.add(lblNewLabel_5);
        lblNewLabel_5.setIcon(new ImageIcon(NewClient.class.getResource("/ImagenesGym/mujerFoto.png")));
        lblNewLabel_5.setOpaque(true);
        
        JLabel lblNewLabel_7 = new JLabel("Nuevo cliente");
        lblNewLabel_7.setFont(new Font("Tw Cen MT", Font.BOLD, 32));
        lblNewLabel_7.setBounds(110, 0, 206, 47);
        panel_1.add(lblNewLabel_7);
        
        JLabel lblNewLabel_6 = new JLabel("$");
        lblNewLabel_6.setBounds(82, 325, 85, 13);
        panel_1.add(lblNewLabel_6);
        lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
        
        JLabel lblNewLabel_4 = new JLabel("Total");
        lblNewLabel_4.setBounds(27, 325, 45, 13);
        panel_1.add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        
        JLabel lblNewLabel_3 = new JLabel("Telefono");
        lblNewLabel_3.setBounds(27, 242, 179, 13);
        panel_1.add(lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        
        JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
        lblNewLabel_2.setBounds(29, 173, 200, 13);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        
        JLabel lblNewLabel_1 = new JLabel("Apellidos");
        lblNewLabel_1.setBounds(29, 108, 105, 13);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(29, 34, 105, 13);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        
        JButton btnNewButton_1 = new JButton("Guardar");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setBounds(304, 411, 85, 37);
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Subir foto");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(180, 411, 105, 37);
        panel_1.add(btnNewButton);
        btnNewButton_1.addActionListener(e -> {
            String nombre = textField.getText();
            String apellidos = textField_1.getText();
            String fechaNacimiento = textField_5.getText() + "-" + textField_3.getText() + "-" + textField_4.getText();
            String telefono = textField_2.getText();

            boolean clienteAgregado = controller.addClient(List.of(nombre, apellidos, fechaNacimiento, telefono));
            if (clienteAgregado) {
                System.out.println("Cliente agregado exitosamente.");
                JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente");
                frame.dispose();
                ClientPanel.main(new String[0]);
            } else {
                System.out.println("No se pudo agregar el cliente.");
                JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente");

            }
        });
    }
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
