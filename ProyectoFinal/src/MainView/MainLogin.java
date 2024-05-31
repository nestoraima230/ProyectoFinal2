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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import instructorsViews.InstructorReportcard;
import mainControllers.MainLoginController;

public class MainLogin extends JFrame {
	
    private JTextField usernameField;
    private JTextField passwordField;
    private MainLoginController MainLoginController;
    
    public MainLogin(MainLoginController MainLoginController) {
        this.MainLoginController = MainLoginController;
        initialize();
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainLoginController mainLoginController = new MainLoginController();
                    MainLogin frame = new MainLogin(mainLoginController);;
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Login");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 100, 25);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(160, 50, 200, 25);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 25);
        contentPane.add(lblPassword);

        passwordField = new JTextField();
        passwordField.setBounds(160, 100, 200, 25);
        contentPane.add(passwordField);
        passwordField.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                boolean loggedIn = MainLoginController.login(username, password);
                if (loggedIn) {
                    System.out.println("Login successful!");
                    dispose();
                    MainWindows MainWindows = new MainWindows();
                    MainWindows.setVisible(true);

                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
                

            }
        });
        btnLogin.setBounds(160, 150, 100, 25);
        contentPane.add(btnLogin);
    }
    

}
