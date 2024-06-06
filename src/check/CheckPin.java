package check;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPin {
    private JFrame frame;
    private JTextField textField;
    private JButton btnIngresar;
    private String pin = "1234";

    public CheckPin() {
        initialize();
        attachListeners();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 684, 511);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(292, 239, 100, 32);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(31, 462, 100, 32);
        panel.add(btnRegresar);

        JLabel lblNewLabel = new JLabel("Ingrese su PIN");
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(240, 196, 205, 32);
        panel.add(lblNewLabel);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(292, 295, 100, 32);
        panel.add(btnIngresar);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(CheckPin.class.getResource("/ImagenesGym/chicoenGymIcono.jpg")));
        lblNewLabel_1.setBounds(0, 0, 684, 511);
        panel.add(lblNewLabel_1);

        frame.setVisible(true);
    }

    private void attachListeners() {
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputPin = textField.getText().trim();

                if (inputPin.equals(pin)) {
                    JOptionPane.showMessageDialog(frame, "PIN correcto. Acceso concedido.");
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "PIN incorrecto. Por favor, inténtelo de nuevo.");
                    textField.setText("");
                }
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}

