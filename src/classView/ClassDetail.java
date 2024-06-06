package classView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import instructorsControllers.ConsultRecordsController;
import java.awt.Font;


import javax.swing.JButton;
import java.util.List;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;

public class ClassDetail {

    private JFrame frame;
    private JTable table;
    private ConsultRecordsController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ClassDetail window = new ClassDetail();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClassDetail() {
        initialize();
        controller = new ConsultRecordsController();
        displayInstructors(); 
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 684, 511);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(148, 121, 150));
        panel_1.setBounds(0, 0, 684, 511);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("Zumba");
        lblNewLabel_4.setOpaque(true);
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel_4.setBackground(Color.BLACK);
        lblNewLabel_4.setBounds(27, 82, 200, 30);
        panel_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Cross Fit");
        lblNewLabel_5.setOpaque(true);
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel_5.setBackground(Color.BLACK);
        lblNewLabel_5.setBounds(242, 82, 200, 30);
        panel_1.add(lblNewLabel_5);
        
                JLabel lblNewLabel = new JLabel("Detalles de Clases");
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setBackground(new Color(144, 45, 65 ));
                lblNewLabel.setOpaque(true);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
                lblNewLabel.setBounds(138, 31, 400, 40);
                panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_6 = new JLabel("Body Combat");
        lblNewLabel_6.setOpaque(true);
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewLabel_6.setBackground(Color.BLACK);
        lblNewLabel_6.setBounds(457, 82, 200, 30);
        panel_1.add(lblNewLabel_6);
        
        JScrollPane scrollPane = new JScrollPane((Component) null);
        scrollPane.setBounds(27, 112, 630, 317);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setBounds(27, 112, 630, 315);
        panel_1.add(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Especialidad");
        model.addColumn("Email");
        table.setModel(model);
        
        JButton btnNewButton = new JButton("Salir");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(28, 457, 100, 24);
        panel_1.add(btnNewButton);
    }

    private void displayInstructors() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<List<String>> allInstructors = controller.getAllInstructors();
        model.setRowCount(0);

        for (List<String> instructorDetails : allInstructors) {
            model.addRow(instructorDetails.toArray());
        }
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
