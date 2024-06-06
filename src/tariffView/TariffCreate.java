package tariffView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import authControllers.tariffControllers;

public class TariffCreate {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_1;
    private tariffControllers controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TariffCreate window = new TariffCreate();
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
    public TariffCreate() {
        controller = new tariffControllers(); 
        initialize();
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

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(141, 45, 414, 397);
        panel.add(panel_1);
        panel_1.setLayout(null);

        textField = new JTextField();
        textField.setBounds(87, 82, 240, 28);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Cliente ID");
        lblNewLabel.setBounds(85, 59, 155, 13);
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        JLabel lblNewLabel_1 = new JLabel("Cuota mensual");
        lblNewLabel_1.setBounds(87, 149, 155, 13);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        textField_2 = new JTextField();
        textField_2.setBounds(87, 179, 240, 28);
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Fecha inicial");
        lblNewLabel_2.setBounds(87, 240, 147, 13);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));

        JLabel lblNewLabel_3 = new JLabel("Fecha final");
        lblNewLabel_3.setBounds(231, 241, 135, 13);
        panel_1.add(lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 19));

        textField_3 = new JTextField();
        textField_3.setBounds(87, 276, 96, 28);
        panel_1.add(textField_3);
        textField_3.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(231, 276, 96, 28);
        panel_1.add(textField_1);

        JButton btnNewButton = new JButton("Guardar");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBounds(308, 349, 96, 21);
        panel_1.add(btnNewButton);
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int clienteID = Integer.parseInt(textField.getText());
                double cuotaMensual = Double.parseDouble(textField_2.getText());
                Date fechaInicio = Date.valueOf(textField_3.getText().trim());
                Date fechaFin = Date.valueOf(textField_1.getText().trim()); 
                
                boolean tarifaGuardada = controller.addTariff(clienteID, fechaInicio,fechaFin, cuotaMensual);


                if (tarifaGuardada) {
                    JOptionPane.showMessageDialog(frame, "Tarifa guardada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error al guardar la tarifa. Por favor, inténtelo de nuevo.");
                }

            }
        });

        JLabel lblNewLabel_4 = new JLabel("Editar tarifa de gimnasio");
        lblNewLabel_4.setBounds(103, 10, 268, 28);
        panel_1.add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
    }

    public void show() {
        frame.setVisible(true);
    }
}
