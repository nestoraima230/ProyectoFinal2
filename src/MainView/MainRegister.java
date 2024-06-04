package MainView;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mainControllers.MainRegisterController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRegister extends JFrame {

    private JFrame frame;
    private JTextField textField;
    private JTextField emailField;
    private JTextField passwordField;

    private MainRegisterController registerController;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MainRegister window = new MainRegister();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainRegister() {
        initialize();
        registerController = new MainRegisterController();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(148, 121, 150));
        panel.setBounds(100, 100, 700, 550);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(null);

        emailField = new JTextField();
        emailField.setBounds(229, 269, 300, 40);
        panel.add(emailField);
        emailField.setColumns(10);

        JLabel lblEmail = new JLabel("Correo electrónico");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblEmail.setBounds(175, 239, 300, 20);
        lblEmail.setForeground(new Color(255, 255, 255));
        panel.add(lblEmail);

        passwordField = new JTextField();
        passwordField.setBounds(229, 372, 300, 40);
        panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setBounds(175, 343, 300, 20);
        lblPassword.setForeground(new Color(255, 255, 255));
        panel.add(lblPassword);

        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setBounds(307, 445, 153, 40);
        btnRegister.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegister.setBackground(new Color(100, 149, 237));
        btnRegister.setForeground(new Color(144, 45, 65));
        panel.add(btnRegister);

        JButton btnToMainPanel = new JButton("Salir");
        btnToMainPanel.setBounds(575, 491, 95, 35);
        btnToMainPanel.setFont(new Font("Arial", Font.BOLD, 18));
        btnToMainPanel.setBackground(new Color(100, 149, 237));
        btnToMainPanel.setForeground(new Color(144, 45, 65));
        panel.add(btnToMainPanel);

        btnToMainPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();               
                MainPanel mainPanel = new MainPanel(); 
                mainPanel.setVisible(true); 
            }
        });
        
        JLabel lblTitle = new JLabel("Registrarse");
        lblTitle.setBounds(151, 33, 373, 80);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 56));
        lblTitle.setForeground(new Color (144, 45, 65));
        lblTitle.setBackground(new Color (17, 75, 95));
        panel.add(lblTitle);

        JLabel lblNewLabel = new JLabel("Unete a nuestra comunidad");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(325, 104, 217, 13);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(198, 110, 125, 4);
        panel.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(181, 146, 142, 20);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(229, 176, 300, 40);
        panel.add(textField);
        textField.setColumns(10);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(35, 0, 95, 550);
        panel_2.setBackground(new Color (144, 151, 192));
        panel.add(panel_2);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(MainRegister.class.getResource("/ImagenesGym/IconoChikito1.png")));
        lblNewLabel_2.setBounds(171, 177, 50, 51);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon(MainRegister.class.getResource("/ImagenesGym/InocoChikito2.png")));
        lblNewLabel_2_1.setBounds(175, 270, 46, 39);
        panel.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setIcon(new ImageIcon(MainRegister.class.getResource("/ImagenesGym/LogoChikito3.png")));
        lblNewLabel_2_1_1.setBounds(173, 373, 46, 39);
        panel.add(lblNewLabel_2_1_1);

        frame.getContentPane().add(panel);

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = passwordField.getText();
                String email = emailField.getText();
                
                boolean registered = registerController.registerUser(username, password, email);
                if (registered) {
                    JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
                    dispose();
                    MainWindows MainWindows = new MainWindows();
                    MainWindows.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    
    
    
}
