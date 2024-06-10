package clientView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
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
    private clientControllers controller;
    private JLabel lblDollar;

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
        controller = new clientControllers();
        initialize();
        cargarInformacionCliente(clientId);
    }

    private void cargarInformacionCliente(int clientId) {
        List<String> clienteDetails = controller.getClientDetails(clientId);
        if (!clienteDetails.isEmpty()) {
            textField.setText(clienteDetails.get(0));
            textField_1.setText(clienteDetails.get(1));
            textField_idCliente.setText(String.valueOf(clientId)); 
            textField_5.setText(clienteDetails.get(3));
            textField_2.setText(clienteDetails.get(4));
            
            // Verificar si el monto se recupera correctamente
            String monto = clienteDetails.get(5);
            System.out.println("Monto recuperado de la base de datos: " + monto);

            // Convertir el monto a double y formatearlo
            try {
                double montoDouble = Double.parseDouble(monto);
                DecimalFormat df = new DecimalFormat("#.##");
                String montoFormateado = df.format(montoDouble);
                lblDollar.setText("$" + montoFormateado);
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el monto a double: " + e.getMessage());
                lblDollar.setText("$0.00");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron detalles para el cliente con ID " + clientId);
            lblDollar.setText("$0.00");
        }
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblNombre.setBounds(59, 59, 105, 13);
        panel.add(lblNombre);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblApellidos.setBounds(59, 134, 105, 13);
        panel.add(lblApellidos);

        JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
        lblFechaNacimiento.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblFechaNacimiento.setBounds(59, 205, 200, 13);
        panel.add(lblFechaNacimiento);

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblTelefono.setBounds(59, 274, 179, 13);
        panel.add(lblTelefono);

        JLabel lblTotal = new JLabel("Total");
        lblTotal.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblTotal.setBounds(59, 359, 45, 13);
        panel.add(lblTotal);

        textField = new JTextField();
        textField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField.setBounds(59, 82, 296, 28);
        textField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_1.setBounds(59, 157, 296, 28);
        textField_1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_5.setBounds(59, 228, 131, 28);
        textField_5.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        panel.add(textField_5);
        textField_5.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_2.setBounds(59, 297, 200, 28);
        textField_2.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_idCliente = new JTextField();
        textField_idCliente.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        textField_idCliente.setBounds(286, 300, 71, 28);
        textField_idCliente.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        panel.add(textField_idCliente);


        JPanel panelInner = new JPanel();
        panelInner.setBorder(new MatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
        panelInner.setBackground(new Color(255, 255, 255));
        panelInner.setBounds(39, 32, 597, 425);
        panel.add(panelInner);
        panelInner.setLayout(null);

        JLabel lblEditarCliente = new JLabel("Editar cliente");
        lblEditarCliente.setBounds(209, 0, 223, 37);
        lblEditarCliente.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
        panelInner.add(lblEditarCliente);

        JLabel lblFoto = new JLabel("");
        lblFoto.setBackground(new Color(255, 255, 255));
        lblFoto.setBounds(419, 35, 143, 207);
        lblFoto.setIcon(new ImageIcon(ClientEdit.class.getResource("/ImagenesGym/mujerFoto.png")));
        lblFoto.setOpaque(true);
        panelInner.add(lblFoto);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(453, 387, 105, 28);
        panelInner.add(btnGuardar);
        btnGuardar.setForeground(new Color(255, 255, 255));
        btnGuardar.setBackground(new Color(0, 0, 0));
        btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        
        lblDollar = new JLabel("$");
        lblDollar.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
        lblDollar.setBounds(135, 361, 85, 13);
        panel.add(lblDollar);


        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(312, 387, 119, 28);
        panelInner.add(btnEliminar);
        btnEliminar.setForeground(new Color(255, 255, 255));
        btnEliminar.setBackground(new Color(0, 0, 0));
        btnEliminar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(247, 239, 179, 13);
        lblId.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        panelInner.add(lblId);

        btnGuardar.addActionListener(e -> guardarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());
    }

    private void guardarCliente() {
        String nombre = textField.getText();
        String apellidos = textField_1.getText();
        String fechaNacimiento = textField_5.getText();
        String telefono = textField_2.getText();

        int clientId = obtenerIdClienteSeleccionado();
        if (clientId == -1) {
            JOptionPane.showMessageDialog(null, "ID del cliente inválido.");
            return;
        }

        boolean actualizado = controller.updateClient(clientId, List.of(nombre, apellidos, fechaNacimiento, telefono));
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");
            frame.dispose();
            ClientPanel.main(new String[0]);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el cliente.");
        }
    }

    private void eliminarCliente() {
        int clientId = obtenerIdClienteSeleccionado();
        if (clientId == -1) {
            JOptionPane.showMessageDialog(null, "ID del cliente inválido.");
            return;
        }

        boolean eliminado = controller.deleteClient(clientId);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
            frame.dispose();
            ClientPanel.main(new String[0]);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente.");
        }
    }

    public int obtenerIdClienteSeleccionado() {
        String idClienteStr = textField_idCliente.getText().trim();
        System.out.println("ID del cliente en campo de texto: " + idClienteStr); 

        if (idClienteStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de ID del cliente está vacío.");
            return -1;
        }

        try {
            return Integer.parseInt(idClienteStr);
        } catch (NumberFormatException e) {
            System.out.println("Error al obtener el ID del cliente seleccionado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "ID del cliente inválido.");
            return -1;
        }
    }
}
