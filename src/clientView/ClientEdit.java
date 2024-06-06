package clientView;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import authControllers.clientControllers;

public class ClientEdit {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_idCliente;

    private clientControllers controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientEdit window = new ClientEdit();
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
    public ClientEdit() {
        initialize();
        controller = new clientControllers();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel.setBounds(59, 59, 105, 13);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Apellidos");
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setBounds(59, 134, 105, 13);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento");
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_2.setBounds(59, 205, 200, 13);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Telefono");
        lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_3.setBounds(59, 274, 179, 13);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Total");
        lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_4.setBounds(59, 359, 45, 13);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(ClientEdit.class.getResource("/ImagenesGym/mujerFoto.png")));
        lblNewLabel_5.setBounds(493, 80, 143, 207);
        lblNewLabel_5.setOpaque(true);
        panel.add(lblNewLabel_5);

        textField = new JTextField();
        textField.setBounds(59, 82, 296, 28);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(59, 157, 296, 28);
        panel.add(textField_1);
        
        textField_idCliente  = new JTextField();
        textField_idCliente.setBounds(400, 300, 150, 28); 
        panel.add(textField_idCliente);


        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(59, 297, 296, 28);
        panel.add(textField_2);

        //textField_3 = new JTextField();
        //textField_3.setColumns(10);
        //textField_3.setBounds(200, 228, 59, 28);
        //panel.add(textField_3);

        //textField_4 = new JTextField();
        //textField_4.setColumns(10);
        //textField_4.setBounds(296, 228, 59, 28);
        //panel.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(105, 228, 59, 28);
        panel.add(textField_5);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setBounds(59, 431, 85, 21);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(e -> {
            int clientId = obtenerIdClienteSeleccionado();

            if (clientId != -1) {
                boolean eliminado = controller.deleteClient(clientId);
                if (eliminado) {
                    System.out.println("Cliente eliminado exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar al cliente.");
                }
            } else {
                System.out.println("No se ha seleccionado ningún cliente para eliminar.");
            }
        });

        
        JButton btnNewButton_1 = new JButton("OK");
        btnNewButton_1.setBounds(270, 431, 85, 21);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("$");
        lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
        lblNewLabel_6.setBounds(135, 361, 85, 13);
        panel.add(lblNewLabel_6);

        btnNewButton_1.addActionListener(e -> {
            String nombre = textField.getText();
            String apellidos = textField_1.getText();
            String fechaNacimiento = textField_5.getText();
            String telefono = textField_2.getText();
            int clientId = Integer.parseInt(textField_idCliente.getText());


            boolean actualizado = controller.updateClient(clientId, List.of(nombre, apellidos, fechaNacimiento, telefono));
            
            if (actualizado) {
                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el cliente.");
            }
        });

    }
    
    
    public int obtenerIdClienteSeleccionado() {
        String idClienteStr = textField_idCliente.getText();
        
        try {
            int idCliente = Integer.parseInt(idClienteStr);
            return idCliente;
        } catch (NumberFormatException e) {
            System.out.println("Error al obtener el ID del cliente seleccionado: " + e.getMessage());
            return -1; 
        }
    }

}
