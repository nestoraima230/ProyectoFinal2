package instructorsViews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
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
    private JLabel lblNewLabel_5;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JPanel panel_4;
    private JLabel lblImagenInstructor;
    private JPanel panel_5;
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private JLabel lblImagenInstructor_1;
    private InstructorDetailsController controller;

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

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(128, 128, 192));
        panel_1.setBounds(477, 11, 181, 437);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InstructorsDetails.class.getResource("/ImagenesGym/javierChikito.jpg")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(36, 11, 108, 165);
        panel_1.add(lblNewLabel);

        table_2 = new JTable();
        table_2.setBounds(0, 209, 181, 225);
        panel_1.add(table_2);

        lblImagenInstructor_1 = new JLabel("Especialidad: " + getInstructorSpecialty(1)); 
        lblImagenInstructor_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagenInstructor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblImagenInstructor_1.setBounds(0, 176, 181, 34);
        panel_1.add(lblImagenInstructor_1);

        panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBackground(new Color(128, 128, 192));
        panel_4.setBounds(251, 11, 181, 446);
        panel.add(panel_4);

        lblImagenInstructor = new JLabel("");
        lblImagenInstructor.setIcon(new ImageIcon(InstructorsDetails.class.getResource("/ImagenesGym/rubenChikito.jpg")));
        lblImagenInstructor.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagenInstructor.setBounds(36, 11, 108, 165);
        panel_4.add(lblImagenInstructor);

        table_1 = new JTable();
        table_1.setBounds(0, 209, 181, 236);
        panel_4.add(table_1);

        JLabel lblNewLabel_5_1 = new JLabel("Especialidad: " + getInstructorSpecialty(2)); 
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5_1.setBounds(0, 176, 181, 34);
        panel_4.add(lblNewLabel_5_1);

        panel_5 = new JPanel();
        panel_5.setLayout(null);
        panel_5.setBackground(new Color(128, 128, 192));
        panel_5.setBounds(35, 11, 181, 446);
        panel.add(panel_5);

        lblNewLabel_5 = new JLabel("Especialidad: " + getInstructorSpecialty(3)); 
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(0, 176, 181, 34);
        panel_5.add(lblNewLabel_5);

        table = new JTable();
        table.setBounds(0, 209, 181, 237);
        panel_5.add(table);

        lblImagenInstructor_1 = new JLabel("");
        lblImagenInstructor_1.setIcon(new ImageIcon(InstructorsDetails.class.getResource("/ImagenesGym/hanniachikita.jpg")));
        lblImagenInstructor_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagenInstructor_1.setBounds(35, 11, 108, 165);
        panel_5.add(lblImagenInstructor_1);

        btnNewButton = new JButton("Regresar");
        btnNewButton.setBounds(80, 468, 89, 23);
        panel.add(btnNewButton);

        btnNewButton_1 = new JButton("Credencial");
        btnNewButton_1.setBounds(298, 468, 89, 23);
        panel.add(btnNewButton_1);

        btnNewButton_2 = new JButton("Reporte");
        btnNewButton_2.setBounds(527, 468, 89, 23);
        panel.add(btnNewButton_2);
    }

    private String getInstructorSpecialty(int instructorId) {
        List<String> specialties = controller.getInstructorSpecialties();
        return specialties.get(instructorId - 1);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
