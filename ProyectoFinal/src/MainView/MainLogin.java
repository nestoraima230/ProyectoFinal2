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
import javax.swing.ImageIcon;

public class MainLogin extends JFrame {
	
	private JFrame frame;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin frame = new MainLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MainLogin() {
		initialize();
	}
	 public void initialize() {
		 
		 	frame = new JFrame();
			frame.setVisible(true);
			frame.setBounds(100, 100, 700, 550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(148, 121, 150));
	        panel.setBounds(100, 100, 700, 550);
	        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
	      
	        panel.setLayout(null);

	        JLabel lblTitle = new JLabel("Iniciar sesión");
	        lblTitle.setForeground(new Color(255, 255, 255));
	        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	        lblTitle.setFont(new Font("Arial", Font.BOLD, 53));
	        lblTitle.setBounds(177, 46, 408, 50);
	        panel.add(lblTitle);

	        JTextField usernameField = new JTextField();
	        usernameField.setBounds(237, 208, 300, 40);
	        panel.add(usernameField);
	        usernameField.setColumns(10);

	        JLabel lblUsername = new JLabel("Nombre");
	        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lblUsername.setForeground(new Color(255, 255, 255));
	        lblUsername.setBounds(177, 165, 300, 20);
	        panel.add(lblUsername);

	        JTextField passwordField = new JTextField();
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
	        
	        JButton btnToMainPanel = new JButton("Salir");
	        btnToMainPanel.setFont(new Font("Arial", Font.PLAIN, 12));
	        btnToMainPanel.setBounds(564, 485, 95, 35);
	        btnToMainPanel.setBackground(new Color(100, 149, 237));
	        btnToMainPanel.setForeground(new Color(144, 45, 65));
	       
	        panel.add(btnToMainPanel);
	    
	       

	        JButton btnToRegister = new JButton("¿No tienes cuenta? Registrate");
	        btnToRegister.setFont(new Font("Arial", Font.PLAIN, 14));
	        btnToRegister.setOpaque(false);
	        btnToRegister.setBounds(237, 445, 300, 30);
	       
	        panel.add(btnToRegister);
	        
	        JPanel panel_2 = new JPanel();
			panel_2.setBounds(35, 0, 95, 550);
			panel_2.setBackground(new Color (144, 151, 192));
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

