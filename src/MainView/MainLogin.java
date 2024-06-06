package MainView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mainControllers.MainLoginController;


import javax.swing.ImageIcon;

public class MainLogin {
    
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private MainLoginController mainLoginController;
    
    public MainLogin(MainLoginController mainLoginController2) {
        this.mainLoginController = mainLoginController2;
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainLoginController mainLoginController = new MainLoginController();
                    MainLogin window = new MainLogin(mainLoginController);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(148, 121, 150));
        panel.setBounds(0, 0, 700, 550);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel lblTitle = new JLabel("Iniciar sesión");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 53));
        lblTitle.setBounds(177, 46, 408, 50);
        panel.add(lblTitle);

        usernameField = new JTextField();
        usernameField.setBounds(237, 208, 300, 40);
        panel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUsername = new JLabel("Nombre");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(177, 165, 300, 20);
        panel.add(lblUsername);

        passwordField = new JPasswordField();
        passwordField.setBounds(237, 319, 300, 40);
        panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(177, 269, 300, 20);
        panel.add(lblPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogin.setBackground(new Color(100, 149, 237));
        btnLogin.setForeground(new Color(144, 45, 65));
        btnLogin.setBounds(317, 395, 160, 40);
        panel.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); // Use getPassword() for JPasswordField
                boolean loggedIn = mainLoginController.login(username, password);
                if (loggedIn) {
                    System.out.println("Login successful!");
                    frame.dispose();
                    MainWindows mainWindows = new MainWindows();
                    mainWindows.setVisible(true);
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
            }
        });

        JButton btnToMainPanel = new JButton("Salir");
        btnToMainPanel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnToMainPanel.setBounds(564, 485, 95, 35);
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

        JButton btnToRegister = new JButton("¿No tienes cuenta? Registrate");
        btnToRegister.setFont(new Font("Arial", Font.PLAIN, 14));
        btnToRegister.setOpaque(false);
        btnToRegister.setBounds(237, 445, 300, 30);
        panel.add(btnToRegister);

        btnToRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();               
                MainRegister.main(new String[0]);         
                }
        });
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(35, 0, 95, 550);
        panel_2.setBackground(new Color(144, 151, 192));
        panel.add(panel_2);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/IconoChikito1.png")));
        lblNewLabel.setBounds(177, 206, 61, 52);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/InocoChikito2.png")));
        lblNewLabel_1.setBounds(177, 319, 50, 40);
        panel.add(lblNewLabel_1);
    }
}