package tariffView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TariffDetail {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TariffDetail window = new TariffDetail();
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
    public TariffDetail() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
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
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(589, 460, 87, 27);
        panel.add(btnNewButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 54, 654, 386);
        panel.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Plan power", " x", "", "", ""," x" },
                {"Plan black", "", " x", " x", " x", " x"},
                {"Plan fit", " x", "", " x", ""," x"}
            },
            new String[] {
                "", "Sillones de masaje", "entrenamiento personalizado","Acceso a todas areas","Clases grupales","Entrena con 3 amigos"
            }
        ));

        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
                panel.setBackground(table.getBackground());
                
    
                
                return panel;
            }
        });

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        
        
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.setRowHeight(60);
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(21, 17, 655, 38);
        panel.add(panel_1);
        
        JLabel lblNewLabel = new JLabel("Detalle de tarifas");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        panel_1.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
    }

}
