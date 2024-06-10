package tariffView;

import authModels.tariffModels;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TariffDetail {

    private JFrame frame;
    private JTable table;
    private tariffModels model;

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
        model = new tariffModels();
        populateTable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Detalle de tarifas");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
        lblNewLabel.setBounds(252, 17, 243, 27);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
                 TariffPanel.main(new String[0]);
        	}
        	
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(591, 467, 85, 21);
        panel.add(btnNewButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 54, 654, 403);
        panel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Nombre de Tarifa", "Sillones de masaje", "entrenamiento personalizado","Acceso a todas areas","Clases grupales","Entrena con 3 amigos"
            }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.setRowHeight(60);
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(22, 17, 654, 39);
        panel.add(panel_1);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		TariffPanel.main(new String[0]);
        	}
        });
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setBounds(32, 467, 85, 21);
        panel.add(btnSalir);
    }

    public void populateTable() {
        List<List<String>> allTariffs = model.getAllTariffs();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (List<String> tariffDetails : allTariffs) {
            model.addRow(new Object[]{tariffDetails.get(5), "x", "", "x", "", "x"});
            
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
