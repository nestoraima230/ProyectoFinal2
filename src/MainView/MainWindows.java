package MainView;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

import check.CheckPin;
import classView.ClassPanel;
import clientView.ClientPanel;
import instructorsViews.InstructorPanel;
import tariffView.TariffPanel;


public class MainWindows {
    private JFrame frame;

    public MainWindows() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(148, 121, 150));
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 325, 75);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenido(a)");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 31));
        lblNewLabel.setBounds(111, 22, 197, 29);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/LogoChikitp.png")));
        lblNewLabel_2.setBounds(10, 11, 91, 53);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        panel_1.setBackground(new Color(144, 151, 192 ));
        panel_1.setBounds(10, 96, 664, 370);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnClients = new JButton("Clientes");
        btnClients.setForeground(new Color(255, 255, 255));
        btnClients.setBackground(new Color(0, 0, 0));
        btnClients.setOpaque(true);
        btnClients.setBounds(24, 224, 105, 23);
        panel_1.add(btnClients);

        JButton btnRates = new JButton("Tarifas");
        btnRates.setForeground(new Color(255, 255, 255));
        btnRates.setBackground(new Color(0, 0, 0));
        btnRates.setOpaque(true);
        btnRates.setBounds(155, 224, 105, 23);
        panel_1.add(btnRates);

        JButton btnInstructors = new JButton("Instructores");
        btnInstructors.setForeground(new Color(255, 255, 255));
        btnInstructors.setBackground(new Color(0, 0, 0));
        btnInstructors.setOpaque(true);
        btnInstructors.setBounds(286, 224, 105, 23);
        panel_1.add(btnInstructors);


        JButton btnClasses = new JButton("Clases");
        btnClasses.setForeground(new Color(255, 255, 255));
        btnClasses.setBackground(new Color(0, 0, 0));
        btnClasses.setOpaque(true);
        btnClasses.setBounds(417, 224, 105, 23);
        panel_1.add(btnClasses);

        JButton btnCheckIn = new JButton("Checador");
        btnCheckIn.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnCheckIn.setForeground(new Color(255, 255, 255));
        btnCheckIn.setBackground(new Color(0, 0, 0));
        btnCheckIn.setOpaque(true);
        btnCheckIn.setBounds(548, 224, 105, 23);
        panel_1.add(btnCheckIn);
        
        btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                ClientPanel.main(new String[0]);
            }
        });

        btnRates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                TariffPanel.main(new String[0]);
            }
        });

        btnInstructors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                InstructorPanel.main(new String[0]);
            }
        });

        btnClasses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                ClassPanel.main(new String[0]);
            }
        });

        btnCheckIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                CheckPin checkPin = new CheckPin();
                checkPin.getFrame().setVisible(true);
            }
        });


        JPanel panel_2 = new JPanel();
        panel_2.setForeground(new Color(255, 255, 255));
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(24, 91, 105, 175);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/ClientesIcono.png")));
        lblNewLabel_3.setBounds(10, 11, 85, 113);
        panel_2.add(lblNewLabel_3);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBackground(new Color(255, 255, 255));
        panel_2_1.setBounds(155, 91, 105, 175);
        panel_1.add(panel_2_1);
        panel_2_1.setLayout(null);
        
        JLabel lblNewLabel_3_1 = new JLabel("");
        lblNewLabel_3_1.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/tarifasIcono.png")));
        lblNewLabel_3_1.setBounds(10, 11, 85, 113);
        panel_2_1.add(lblNewLabel_3_1);

        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setBackground(Color.WHITE);
        panel_2_1_1.setBounds(286, 91, 105, 175);
        panel_1.add(panel_2_1_1);
        panel_2_1_1.setLayout(null);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("");
        lblNewLabel_3_1_1.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/instructorIcono.png")));
        lblNewLabel_3_1_1.setBounds(10, 11, 85, 113);
        panel_2_1_1.add(lblNewLabel_3_1_1);

        JPanel panel_2_1_1_1 = new JPanel();
        panel_2_1_1_1.setBackground(Color.WHITE);
        panel_2_1_1_1.setBounds(417, 91, 105, 175);
        panel_1.add(panel_2_1_1_1);
        panel_2_1_1_1.setLayout(null);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("");
        lblNewLabel_3_1_1_1.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/clasesIcono.png")));
        lblNewLabel_3_1_1_1.setBounds(10, 11, 85, 113);
        panel_2_1_1_1.add(lblNewLabel_3_1_1_1);

        JPanel panel_2_1_1_1_1 = new JPanel();
        panel_2_1_1_1_1.setBackground(Color.WHITE);
        panel_2_1_1_1_1.setBounds(548, 91, 105, 175);
        panel_1.add(panel_2_1_1_1_1);
        panel_2_1_1_1_1.setLayout(null);
        
        JLabel lblNewLabel_3_1_1_1_1 = new JLabel("");
        lblNewLabel_3_1_1_1_1.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/checadorIcono.png")));
        lblNewLabel_3_1_1_1_1.setBounds(10, 11, 85, 113);
        panel_2_1_1_1_1.add(lblNewLabel_3_1_1_1_1);

        JButton btnLogout = new JButton("Cerrar Sesion");
        btnLogout.setForeground(new Color(255, 255, 255));
        btnLogout.setBounds(536, 327, 118, 33);
        btnLogout.setBackground(new Color(0, 0, 0));
        panel_1.add(btnLogout);

        btnLogout.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Sesión cerrada");
                frame.setVisible(false);

                MainPanel.main(new String[0]);

            }
        });
        
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBounds(349, 11, 325, 75);
        frame.getContentPane().add(panel_3);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(MainWindows.class.getResource("/ImagenesGym/ChicosChikitos.jpg")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(0, 0, 325, 75);
        panel_3.add(lblNewLabel_1);

        
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
        
    }
}
