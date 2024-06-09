package tariffView;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import MainView.MainWindows;
import authControllers.tariffControllers;
import classView.ClassRecords;
import clientView.ClientEdit;
import clientView.ClientPanel;
import clientView.NewClient;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

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
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel img1 = new JLabel();
        img1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		  frame.dispose();
                  TariffCreate.main(new String[0]);
        	}
        });
        
        	
        img1.setBounds(635, -22, 63, 85);
        img1.setIcon(new ImageIcon(ClassRecords.class.getResource("/ImagenesGym/agregarUsuario.png")));
        panel.add(img1);
        
        JLabel img = new JLabel();
        img.setBounds(623, 10, 63, 85);
        // img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregar2.png")));
        panel.add(img);

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 frame.dispose();
	                MainWindows MainWindows = new MainWindows();
	                MainWindows.setVisible(true);
        	}
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setBounds(587, 452, 89, 25);
        panel.add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 75, 666, 356);
        panel.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cliente");
        model.addColumn("Membresia");
        model.addColumn("Fecha inicial");
        model.addColumn("Fecha final");
        model.addColumn("Precio");
        model.addColumn("editar      ver detalles");

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
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(10, 39, 666, 39);
        panel.add(panel_1);
        
                JLabel lblNewLabel = new JLabel("Tarifa");
                panel_1.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);

      
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
            btnEdit.setBackground(Color.WHITE);

            JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
            btnView.setBackground(Color.WHITE);

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
  	        String nombreTarifa = (String) table.getModel().getValueAt(row, 1);
  	        int tarifaId = buscarIdTarifaPorNombre(nombreTarifa);
  	        if (tarifaId != -1) {
  	            frame.dispose();
  	            TariffEdit.main(new String[]{Integer.toString(tarifaId)});
  	        } else {
  	            JOptionPane.showMessageDialog(frame, "No se pudo encontrar el ID del cliente.");
  	        }
  	    } else if (e.getSource() == btnView) {
                frame.dispose();
                TariffDetail.main(new String[0]); 
            }
            fireEditingStopped();
        }
        
        private int buscarIdTarifaPorNombre(String nombreTarifa) {
            List<List<String>> tarifas = controller.getAllTariffs();
            for (List<String> tarifa : tarifas) {
                String nombre = tarifa.get(5); 
                if (nombre.equals(nombreTarifa)) {
                    return Integer.parseInt(tarifa.get(0));
                }
            }
            return -1; 
        }
    }

	public Window getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
