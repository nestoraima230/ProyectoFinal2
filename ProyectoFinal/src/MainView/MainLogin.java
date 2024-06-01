package MainView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mainControllers.MainRegisterController;

public class MainLogin extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private mainControllers.MainLoginController mainLoginController;
    private JPanel contentPane;

    public MainLogin(mainControllers.MainLoginController mainLoginController2) {
        this.mainLoginController = mainLoginController2;
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainControllers.MainLoginController mainLoginController = new mainControllers.MainLoginController();
                    MainLogin frame = new MainLogin(mainLoginController);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(148, 121, 150));
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Iniciar sesión");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 53));
        lblTitle.setBounds(177, 46, 408, 50);
        contentPane.add(lblTitle);

        usernameField = new JTextField();
        usernameField.setBounds(237, 208, 300, 40);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUsername = new JLabel("Nombre");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUsername.setForeground(new Color(255, 255, 255));
        lblUsername.setBounds(177, 165, 300, 20);
        contentPane.add(lblUsername);

        passwordField = new JPasswordField();
        passwordField.setBounds(237, 319, 300, 40);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(177, 269, 300, 20);
        contentPane.add(lblPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogin.setBackground(new Color(100, 149, 237));
        btnLogin.setForeground(new Color(144, 45, 65));
        btnLogin.setBounds(317, 395, 160, 40);
        contentPane.add(btnLogin);

        JButton btnToMainPanel = new JButton("Salir");
        btnToMainPanel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnToMainPanel.setBounds(564, 485, 95, 35);
        btnToMainPanel.setBackground(new Color(100, 149, 237));
        btnToMainPanel.setForeground(new Color(144, 45, 65));
        contentPane.add(btnToMainPanel);

        JButton btnToRegister = new JButton("¿No tienes cuenta? Registrate");
        btnToRegister.setFont(new Font("Arial", Font.PLAIN, 14));
        btnToRegister.setOpaque(false);
        btnToRegister.setBounds(237, 445, 300, 30);
        contentPane.add(btnToRegister);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(35, 0, 95, 550);
        panel_2.setBackground(new Color(144, 151, 192));
        contentPane.add(panel_2);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/IconoChikito1.png")));
        lblNewLabel.setBounds(177, 206, 61, 52);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MainLogin.class.getResource("/ImagenesGym/InocoChikito2.png")));
        lblNewLabel_1.setBounds(177, 319, 50, 40);
        contentPane.add(lblNewLabel_1);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword()); // Use getPassword() for JPasswordField
                boolean loggedIn = MainRegisterController.login(username, password);
                if (loggedIn) {
                    System.out.println("Login successful!");
                    dispose();
                    MainWindows mainWindows = new MainWindows();
                    mainWindows.setVisible(true);
                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
            }
        });

        btnToMainPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnToRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción para abrir la ventana de registro
            }
        });
    }
}
