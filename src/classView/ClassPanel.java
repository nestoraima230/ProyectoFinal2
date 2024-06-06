package classView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import authControllers.classControllers;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;

public class ClassPanel {

    private JFrame frame;
    private JTable table;
    private classControllers controller;
    private JButton btnMostrarClasses;
    private JButton btnMostrarRecords;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClassPanel window = new ClassPanel();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClassPanel() {
        controller = new classControllers();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Clases");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(303, 14, 169, 30);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 75, 666, 331);
        panel.add(scrollPane);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Acciones");

        List<List<String>> clases = controller.getAllClases();
        for (List<String> clase : clases) {
            model.addRow(new Object[]{clase.get(1), new ImageIcon[]{
                    new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")), 
                    new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png"))}});
        }

        table.setModel(model);
        table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
                panel.setBackground(table.getBackground());

                ImageIcon[] icons = (ImageIcon[]) value;
                for (ImageIcon icon : icons) {
                    JLabel label = new JLabel(icon);
                    label.setPreferredSize(new Dimension(50, 50));
                    panel.add(label);
                }

                return panel;
            }
        });

        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(300);

        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(565, 467, 85, 21);
        panel.add(btnNewButton);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getBtnMostrarClasses() {
        return btnMostrarClasses;
    }

    public JButton getBtnMostrarRecords() {
        return btnMostrarRecords;
    }
}