package clientView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import authControllers.clientControllers;

public class ClientEdit {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_idCliente;
    private final String placeholderNombre = "Nombre";
    private final String placeholderApellidos = "Apellidos";
    private final String placeholderFechaNacimiento = "YYYY-MM-DD";
    private final String placeholderTelefono = "Telefono";
    private final String placeholderID = "ID";
    private final Color placeholderColor = Color.GRAY;

    private clientControllers controller;

    public static void main(String[] args) {
        if (args.length > 0) {
            int clientId = Integer.parseInt(args[0]);
            EventQueue.invokeLater(() -> {
                try {
                    ClientEdit window = new ClientEdit(clientId); 
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public ClientEdit(int clientId) {
        initialize();
        controller = new clientControllers();
        cargarInformacionCliente(clientId); 
    }
    
    private void cargarInformacionCliente(int clientId) {
        List<String> clienteDetails = controller.getClientDetails(clientId);
        if (!clienteDetails.isEmpty()) {
            textField.setText(clienteDetails.get(0)); 
            textField_1.setText(clienteDetails.get(1));
            textField_idCliente.setText(clienteDetails.get(2));
            textField_2.setText(clienteDetails.get(3));
            textField_5.setText(clienteDetails.get(4));
        }
    }

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
        setPlaceholder(textField, placeholderNombre);
        textField.setBounds(59, 82, 296, 28);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        setPlaceholder(textField_1, placeholderApellidos);
        textField_1.setColumns(10);
        textField_1.setBounds(59, 157, 296, 28);
        panel.add(textField_1);
        
        textField_idCliente = new JTextField();
        setPlaceholder(textField_idCliente, placeholderID);
        textField_idCliente.setBounds(400, 300, 150, 28);
        panel.add(textField_idCliente);

        textField_2 = new JTextField();
        setPlaceholder(textField_2, placeholderTelefono);
        textField_2.setColumns(10);
        textField_2.setBounds(59, 297, 296, 28);
        panel.add(textField_2);


        textField_5 = new JTextField();
        setPlaceholder(textField_5, placeholderFechaNacimiento);
        textField_5.setBounds(105, 228, 85, 28);
        panel.add(textField_5);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setBounds(59, 431, 85, 21);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(e -> {
            int clientId = obtenerIdClienteSeleccionado();

            if (clientId != -1) {
                List<String> detallesCliente = controller.getClientDetails(clientId);
                if (detallesCliente != null && !detallesCliente.isEmpty()) {
                    textField.setText(detallesCliente.get(0)); 
                    textField_1.setText(detallesCliente.get(1)); 
                    textField_5.setText(detallesCliente.get(2)); 
                    textField_2.setText(detallesCliente.get(3)); 
                } else {
                    System.out.println("No se encontraron detalles para el cliente con ID " + clientId);
                }
            } else {
                System.out.println("No se ha seleccionado ningún cliente para cargar.");
            }
        });

        JButton btnNewButton_1 = new JButton("OK");
        btnNewButton_1.setBounds(270, 431, 85, 21);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("$");
        lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
        lblNewLabel_6.setBounds(135, 361, 85, 13);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_3_1 = new JLabel("ID");
        lblNewLabel_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNewLabel_3_1.setBounds(436, 274, 179, 13);
        panel.add(lblNewLabel_3_1);

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

    public void setPlaceholder(JTextField textField, String placeholderText) {
        textField.setText(placeholderText);
        textField.setForeground(placeholderColor);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setForeground(placeholderColor);
                }
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
