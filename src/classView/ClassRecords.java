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

public class ClassRecords {

    private JFrame frame;
    private JTable table;
    private ConsultRecordsController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ClassRecords window = new ClassRecords();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClassRecords() {
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

        JLabel lblNewLabel = new JLabel("Registro de Clases");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(144, 45, 65 ));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(138, 31, 400, 40);
        panel_1.add(lblNewLabel);

        table = new JTable();
        table.setBounds(27, 80, 630, 350);
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
