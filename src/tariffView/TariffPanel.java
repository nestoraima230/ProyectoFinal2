package tariffView;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import authControllers.tariffControllers;

public class TariffPanel {

    private JFrame frame;
    private JTable table;
    private tariffControllers controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TariffPanel window = new TariffPanel();
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
    public TariffPanel() {
        controller = new tariffControllers();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
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

        JLabel lblNewLabel = new JLabel("Tarifa");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        lblNewLabel.setBounds(305, 10, 158, 27);
        panel.add(lblNewLabel);

        JLabel img = new JLabel();
        img.setBounds(623, 10, 63, 85);
        // img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregar2.png")));
        panel.add(img);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(565, 467, 85, 21);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 75, 666, 331);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");

        table.setModel(model);

        List<List<String>> tariffs = controller.getAllTariffs();
        for (List<String> tariff : tariffs) {
            model.addRow(new Object[] {
                tariff.get(1),
                tariff.get(5),
                tariff.get(2),
                tariff.get(3),
                tariff.get(4),
                ""
            });
        }

        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor());

        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);

        JLabel lblNewLabel_1 = new JLabel("Cliente");
        lblNewLabel_1.setBounds(48, 62, 124, 13);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Membresia");
        lblNewLabel_2.setBounds(158, 62, 101, 13);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Fecha inicial");
        lblNewLabel_3.setBounds(268, 62, 95, 13);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Fecha final");
        lblNewLabel_4.setToolTipText("");
        lblNewLabel_4.setBounds(368, 62, 95, 13);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Precio");
        lblNewLabel_5.setBounds(482, 62, 45, 13);
        panel.add(lblNewLabel_5);
    }

    public void show() {
        frame.setVisible(true);
    }

    private class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer() {
            setLayout(new GridLayout(1, 2, 10, 0));
            setBackground(Color.WHITE);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
            JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
            removeAll();
            add(btnEdit);
            add(btnView);
            return this;
        }
    }

    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

        private JPanel panel;
        private JButton btnEdit;
        private JButton btnView;
        private int row;

        public ButtonEditor() {
            panel = new JPanel(new GridLayout(1, 2, 10, 0));
            btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
            btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
            btnEdit.addActionListener(this);
            btnView.addActionListener(this);
            panel.add(btnEdit);
            panel.add(btnView);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return "";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnEdit) {
                frame.dispose();
                TariffCreate.main(new String[0]); 
            } else if (e.getSource() == btnView) {
                frame.dispose();
                TariffDetail.main(new String[0]); 
            }
            fireEditingStopped();
        }
    }
}
