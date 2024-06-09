package instructorsViews;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import MainView.MainWindows;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InstructorPanel {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InstructorPanel window = new InstructorPanel();
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
    public InstructorPanel() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 684, 511);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(350, 11, 334, 489);
        panel_1.setBackground(new Color(148, 121, 150));
        panel.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton_3 = new JButton("Editar");
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(144, 45, 65));
        btnNewButton_3.setOpaque(true);
        btnNewButton_3.setBounds(85, 281, 164, 32);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	//InstructorEdit InstructorEdit = new InstructorEdit(null, 0);
            	//InstructorEdit.getFrame().setVisible(true);     
            }
        });
        panel_1.add(btnNewButton_3);

        JButton btnNewButton_3_1 = new JButton("Regresar");
        btnNewButton_3_1.setBackground(new Color(240, 238, 238));
        btnNewButton_3_1.setOpaque(true);
        btnNewButton_3_1.setBounds(122, 379, 89, 23);
        btnNewButton_3_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainWindows MainWindows = new MainWindows();
                MainWindows.setVisible(true);
            }
        });
        panel_1.add(btnNewButton_3_1);

        JButton btnNewButton_3_2 = new JButton("Crear");
        btnNewButton_3_2.setForeground(new Color(255, 255, 255));
        btnNewButton_3_2.setBackground(new Color(144, 45, 65));
        btnNewButton_3_2.setOpaque(true);
        btnNewButton_3_2.setBounds(85, 219, 164, 32);
        btnNewButton_3_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	InstructorCreate InstructorCreate = new InstructorCreate(null);
            	InstructorCreate.getFrame().setVisible(true);            
            	}
        });
        panel_1.add(btnNewButton_3_2);

        JButton btnNewButton_3_2_1 = new JButton("Instructores");
        btnNewButton_3_2_1.setForeground(new Color(255, 255, 255));
        btnNewButton_3_2_1.setBackground(new Color(144, 45, 65));
        btnNewButton_3_2_1.setOpaque(true);
        btnNewButton_3_2_1.setBounds(85, 159, 164, 32);
        btnNewButton_3_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	InstructorsDetails InstructorsDetails = new InstructorsDetails();
            	InstructorsDetails.getFrame().setVisible(true);
            }
        });
        panel_1.add(btnNewButton_3_2_1);

        JButton btnNewButton_3_2_1_1 = new JButton("Consultar Registro");
        btnNewButton_3_2_1_1.setForeground(new Color(255, 255, 255));
        btnNewButton_3_2_1_1.setBackground(new Color(144, 45, 65));
        btnNewButton_3_2_1_1.setOpaque(true);
        btnNewButton_3_2_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	ConsultRecords consultRecords = new ConsultRecords();
            	consultRecords.getFrame().setVisible(true);
            }
        });
        btnNewButton_3_2_1_1.setBounds(85, 96, 164, 32);
        panel_1.add(btnNewButton_3_2_1_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InstructorPanel.class.getResource("/ImagenesGym/panelinstructorChikito.jpg")));
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 340, 511);
        panel.add(lblNewLabel);
    }

    public JFrame getFrame() {
        return frame;
    }
}