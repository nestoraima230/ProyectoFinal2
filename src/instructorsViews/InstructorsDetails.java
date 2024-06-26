package instructorsViews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import instructorsControllers.InstructorDetailsController;
import java.util.List;

//INCOMPLETO
public class InstructorsDetails {

    private JFrame frame;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JLabel lblImagenInstructor_1;
    private InstructorDetailsController controller;
    private JTable table;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InstructorsDetails window = new InstructorsDetails();
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
    public InstructorsDetails() {
        controller = new InstructorDetailsController();
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
        panel.setBackground(new Color(148, 121, 150));
        panel.setBounds(0, 0, 684, 511);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\tHistorial de clases");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(35, 10, 622, 40);
        panel.add(lblNewLabel);

        btnNewButton_1 = new JButton("Credencial");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton_1.setBounds(400, 478, 112, 23);
        panel.add(btnNewButton_1);
        
        btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InstructorCredential InstructorCredential = new InstructorCredential();
				InstructorCredential.getFrame().setVisible(true);
			}
		});

        
        btnNewButton_2 = new JButton("Reporte");
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBackground(new Color(0, 0, 0));
        btnNewButton_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton_2.setBounds(545, 478, 112, 23);
        panel.add(btnNewButton_2);
        
        table = new JTable();
        table.setBounds(35, 85, 622, 371);
        panel.add(table);
        
        lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNewLabel_1.setBounds(35, 70, 128, 13);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Historial");
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNewLabel_2.setBounds(351, 71, 112, 13);
        panel.add(lblNewLabel_2);
        
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InstructorReportcard InstructorReportcard = new InstructorReportcard();
				InstructorReportcard.getFrame().setVisible(true);
			}
		});
    }

    private String getInstructorSpecialty(int instructorId) {
        List<String> specialties = controller.getInstructorSpecialties();
        return specialties.get(instructorId - 1);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
