package MainView;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
//import controllers.AuthController;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class MainPanel {

    private JFrame frame;
    //private AuthController authController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainPanel window = new MainPanel();
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainPanel() {
        //authController = new AuthController();
        initialize();
    }

    /**
     * Show the application.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    
    
    //principal

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel.setBackground(new Color(148, 121, 150));
        panel.setBounds(338, -12, 549, 550);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnLogin = new JButton("Iniciar Sesion");
        btnLogin.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setOpaque(true);
        btnLogin.setBounds(102, 195, 128, 48);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainLogin.main(new String[0]);
            }
        });
        panel.add(btnLogin);

        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnRegister.setForeground(new Color(255, 255, 255));
        btnRegister.setBackground(new Color(0, 0, 0));
        btnRegister.setOpaque(true); 
        btnRegister.setBounds(102, 312, 128, 48);
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainRegister.main(new String[0]);
            }
        });
        panel.add(btnRegister);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(144, 151, 192));
        panel_1.setBounds(-13, 0, 352, 511);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MainPanel.class.getResource("/ImagenesGym/LogoFinal.png")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(81, 140, 235, 209);
        panel_1.add(lblNewLabel_1);
    }



    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }


}
