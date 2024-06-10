package instructorsViews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import authControllers.instructorControllers;
import classView.ClassRecords;

import java.util.List;

public class InstructorsDetails {

    private JFrame frame;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private instructorControllers controller;
    private JTable table;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JButton btnNewButton_4;

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
        controller = new instructorControllers();
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

        JLabel lblNewLabel = new JLabel("Historial del instructor");
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
        btnNewButton_1.setBounds(326, 478, 112, 23);
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
        btnNewButton_2.setBounds(450, 478, 112, 23);
        panel.add(btnNewButton_2);
        
        table = new JTable();
        table.setBounds(35, 85, 622, 371);
        panel.add(table);
        
        List<List<String>> allInstructorsClassHistory = controller.getAllInstructorsClassHistory();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre del Instructor");
        model.addColumn("Fecha");
        model.addColumn("Nombre de la Clase");
        
        for (List<String> instructorClassHistory : allInstructorsClassHistory) {
            String instructorName = instructorClassHistory.get(0);
            for (int i = 1; i < instructorClassHistory.size(); i += 2) {
                String date = instructorClassHistory.get(i);
                String className = instructorClassHistory.get(i + 1);
                model.addRow(new Object[]{instructorName, date, className});
            }
        }
        
        table.setModel(model);
        
        lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNewLabel_1.setBounds(35, 70, 128, 13);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Historial");
        lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNewLabel_2.setBounds(256, 70, 112, 13);
        panel.add(lblNewLabel_2);
        
        JButton btnNewButton_3 = new JButton("Ok");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 frame.dispose();
                 ClassRecords.main(new String[0]);
        	}
        });
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(0, 0, 0));
        btnNewButton_3.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton_3.setBounds(572, 478, 85, 23);
        panel.add(btnNewButton_3);
        
        JLabel lblNewLabel_3 = new JLabel("Clase");
        lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        lblNewLabel_3.setBounds(467, 70, 45, 13);
        panel.add(lblNewLabel_3);
        
        btnNewButton_4 = new JButton("Salir");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		InstructorPanel.main(new String[0]);
        	}
        });
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setBounds(31, 479, 91, 23);
        panel.add(btnNewButton_4);
        
        btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InstructorReportcard InstructorReportcard = new InstructorReportcard();
				InstructorReportcard.getFrame().setVisible(true);
			}
		});
    }

    public JFrame getFrame() {
        return frame;
    }
}