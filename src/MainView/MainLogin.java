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
import javax.swing.border.MatteBorder;

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
        frame.setLocationRelativeTo(null); 
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(148, 121, 150));
        panel.setBounds(0, 0, 700, 550);
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel lblTitle = new JLabel("Iniciar sesión");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tw Cen MT", Font.BOLD, 82));
        lblTitle.setBounds(91, 88, 517, 62);
        panel.add(lblTitle);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        usernameField.setBounds(193, 234, 378, 40);
        usernameField.setBackground(new Color(148, 121, 150));
		usernameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        panel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUsername = new JLabel("Nombre");
        lblUsername.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(123, 192, 300, 20);
        panel.add(lblUsername);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
        passwordField.setBounds(193, 340, 378, 40);
        passwordField.setBackground(new Color(148, 121, 150));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(123, 310, 300, 20);
        panel.add(lblPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBounds(286, 410, 160, 40);
        panel.add(btnLogin);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); 
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

  

        JButton btnToRegister = new JButton("¿No tienes cuenta? Registrate");
        btnToRegister.setFont(new Font("Arial", Font.ITALIC, 16));
        btnToRegister.setFocusPainted(false);
        btnToRegister.setBorderPainted(false);
        btnToRegister.setContentAreaFilled(false);
        btnToRegister.setBounds(208, 448, 300, 30);
        panel.add(btnToRegister);
        btnToRegister.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainRegister.main(new String[0]);
                }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/IconoChikito1.png")));
        lblNewLabel.setBounds(133, 222, 61, 52);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/InocoChikito2.png")));
        lblNewLabel_1.setBounds(133, 340, 50, 40);
        panel.add(lblNewLabel_1);
    }
}