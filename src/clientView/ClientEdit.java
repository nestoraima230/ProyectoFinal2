package clientView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import authControllers.clientControllers;

public class ClientEdit {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_idCliente;
    private JLabel lblNewLabel_6;

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
            lblNewLabel_6.setText(clienteDetails.get(5)); 
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
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

        textField = new JTextField();
        textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField.setBounds(59, 82, 296, 28);
        textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_1.setColumns(10);
        textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        textField_1.setBounds(59, 157, 296, 28);
        panel.add(textField_1);

        textField_idCliente = new JTextField();
        textField_idCliente.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_idCliente.setBounds(286, 300, 71, 28);
        textField_idCliente.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_idCliente);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_2.setBackground(new Color(255, 255, 255));
        textField_2.setColumns(10);
        textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        textField_2.setBounds(59, 297, 200, 28);
        panel.add(textField_2);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_5.setBounds(59, 228, 131, 28);
        textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

        panel.add(textField_5);

        lblNewLabel_6 = new JLabel("$");
        lblNewLabel_6.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
        lblNewLabel_6.setBounds(135, 361, 85, 13);
        panel.add(lblNewLabel_6);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(39, 32, 597, 425);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_7 = new JLabel("Editar cliente");
        lblNewLabel_7.setBounds(209, 0, 223, 37);
        lblNewLabel_7.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
        panel_1.add(lblNewLabel_7);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBackground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(419, 35, 143, 207);
        panel_1.add(lblNewLabel_5);
        lblNewLabel_5.setIcon(new ImageIcon(ClientEdit.class.getResource("/ImagenesGym/mujerFoto.png")));
        lblNewLabel_5.setOpaque(true);

        JButton btnNewButton_1 = new JButton("Guardar");
        btnNewButton_1.setBounds(453, 387, 105, 28);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setBounds(312, 387, 119, 28);
        panel_1.add(btnNewButton);
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));

        JLabel lblNewLabel_3_1 = new JLabel("ID");
        lblNewLabel_3_1.setBounds(247, 239, 179, 13);
        panel_1.add(lblNewLabel_3_1);
        lblNewLabel_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

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

        btnNewButton_1.addActionListener(e -> {
            String nombre = textField.getText();
            String apellidos = textField_1.getText();
            String fechaNacimiento = textField_5.getText();
            String telefono = textField_2.getText();
            int clientId = Integer.parseInt(textField_idCliente.getText());

            boolean actualizado = controller.updateClient(clientId,
                    List.of(nombre, apellidos, fechaNacimiento, telefono));

            if (actualizado) {
                System.out.println("Cliente actualizado exitosamente.");
                JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");
                 frame.dispose();
                 ClientPanel.main(new String[0]);
            } else {
                System.out.println("No se pudo actualizar el cliente.");
                JOptionPane.showMessageDialog(null,"No se pudo actualizar el cliente.");
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
