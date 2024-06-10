package classView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import authControllers.classControllers;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassDetail {

    private JFrame frame;
    private JTable table;
    private classControllers controller;

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
        controller = new classControllers();
        displayClassesWithInstructors(); 
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
        
        
        JLabel lblNewLabel = new JLabel("Detalles de Clases");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(144, 45, 65 ));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(138, 31, 400, 40);
        panel_1.add(lblNewLabel);
        
        
        JScrollPane scrollPane = new JScrollPane((Component) null);
        scrollPane.setBounds(27, 112, 630, 317);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setBounds(27, 112, 630, 315);
        panel_1.add(table);

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        
        JButton btnNewButton = new JButton("Salir");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClassRecords.main(new String[0]);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(28, 457, 100, 24);
        panel_1.add(btnNewButton);
    }

    private void displayClassesWithInstructors() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new String[]{"Clase", "Instructor"}); 

        List<List<String>> allClasses = controller.getAllClases();

        for (List<String> classDetails : allClasses) {
            int classId = Integer.parseInt(classDetails.get(0));
            List<List<String>> instructorsForClass = controller.getInstructorsForClass(classId); 

            for (List<String> instructor : instructorsForClass) {
                model.addRow(new Object[]{classDetails.get(1), instructor.get(0) + " " + instructor.get(1)});
            }
        }
    }




    
    public JFrame getFrame() {
        return frame;
    }
}
