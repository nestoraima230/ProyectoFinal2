package tariffView;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import clientView.ClientPanel;

import java.awt.Font;
import java.awt.GridLayout;

public class TariffPanel {

    private JFrame frame;
    private JTable table;

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

    public TariffPanel() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(558, 461, 107, 27);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 112, 640, 331);
        panel.add(scrollPane);

       
        table = new JTable();

   
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cliente ID");
        model.addColumn("Cuota");
        model.addColumn("Fecha inicial");
        model.addColumn("Fecha final");
        model.addColumn(""); 
        table.setModel(model);

        table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
                panel.setBackground(table.getBackground());

                JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
                btnEdit.setBackground(Color.white);
                JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
                btnView.setBackground(Color.white);
                panel.add(btnEdit);
                panel.add(btnView);

                return panel;
            }
        });

        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        
        JLabel img= new JLabel ();
		img.setBounds(623,-12,63,85);
		img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
		panel.add(img);


        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(25, 49, 640, 65);
        panel.add(panel_1);
        
                JLabel lblNewLabel = new JLabel("Tarifa");
                panel_1.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 39));

        frame.setVisible(true);
    }
}
