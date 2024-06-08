package instructorsViews;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import clientView.ClientPanel;
import instructorsControllers.ConsultRecordsController;

public class ConsultRecords {

    private JFrame frame;
    private JTable table;
    private ConsultRecordsController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ConsultRecords window = new ConsultRecords();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ConsultRecords() {
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

        JLabel lblNewLabel = new JLabel("Instructores");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(27, 58, 630, 52);
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 109, 630, 323);
        panel_1.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Especialidad");
        model.addColumn("Email");
        model.addColumn("editar         ver detalle");
        table.setModel(model);

        table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
                panel.setBackground(table.getBackground());

                JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
                btnEdit.setBackground(Color.white);
               
                JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
                btnView.setBackground(Color.white);
                btnEdit.setPreferredSize(new Dimension(50, 50));
                
                btnView.setPreferredSize(new Dimension(50, 50));

               

                panel.add(btnEdit);
              
                panel.add(btnView);

                return panel;
            }
        });

        table.setRowHeight(50);
        
        JLabel img= new JLabel ();
		img.setBounds(621,0,63,85);
		img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
		panel_1.add(img);

        JButton btnOk = new JButton("OK");
        btnOk.setForeground(new Color(255, 255, 255));
        btnOk.setBackground(new Color(0, 0, 0));
        btnOk.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnOk.setBounds(546, 455, 111, 32);
        panel_1.add(btnOk);
    }

    private void displayInstructors() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<List<String>> allInstructors = controller.getAllInstructors();
        model.setRowCount(0);

        for (List<String> instructorDetails : allInstructors) {
            String[] instructorArray = new String[4];
            instructorDetails.toArray(instructorArray);

            Object[] row = new Object[]{instructorArray[0], instructorArray[1], instructorArray[2], instructorArray[3], new Object()};
            model.addRow(row);
        }
    }

   
    public JFrame getFrame() {
        return frame;
    }
}