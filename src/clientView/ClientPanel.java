package clientView;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;

public class ClientPanel {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientPanel window = new ClientPanel();
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
    public ClientPanel() {
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 95, 628, 349);
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Juan Martinez", new ImageIcon[] {
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/boton-editar.png")),
                    
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/ver-detalles.png"))
                }},
                {"Maria Muñoz", new ImageIcon[] {
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/boton-editar.png")),
                    
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/ver-detalles.png"))
                }},
                {"Carlos Hernandez", new ImageIcon[] {
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/boton-editar.png")),
                   
                    new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/ver-detalles.png"))
                }}
            },
            new String[] {
                "Nombre","editar                               ver detalle"
            }
        ));

        JLabel img= new JLabel ();
		img.setBounds(613,0,63,85);
		img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
		panel.add(img);
		
        
        table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 4, 10, 0));
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

        table.getColumnModel().getColumn(1).setPreferredWidth(30); 
        table.setRowHeight(50);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("OK");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(565, 467, 85, 21);
        panel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(22, 58, 628, 44);
        panel.add(panel_1);
        
                JLabel lblNewLabel = new JLabel("Clientes");
                lblNewLabel.setForeground(new Color(255, 255, 255));
                panel_1.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    
    }
}