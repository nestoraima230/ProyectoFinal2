package clientView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import MainView.MainWindows;

import javax.swing.table.TableCellEditor;

import authControllers.clientControllers;
import classView.ClassRecords;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.AbstractCellEditor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientPanel {

    private JFrame frame;
    private JTable table;
    private clientControllers controller;

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
        controller = new clientControllers();
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 99, 666, 331);
        panel.add(scrollPane);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("editar                      ver detalle");

        List<List<String>> clientes = controller.getAllClients();
        for (List<String> cliente : clientes) {
            model.addRow(new Object[]{cliente.get(0),cliente.get(2), ""});
        }

        table.setModel(model);

        table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor());

        table.setRowHeight(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);

        scrollPane.setViewportView(table);

        frame.setVisible(true);
        
        JLabel img1 = new JLabel();
        img1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 frame.dispose();
                 NewClient.main(new String[0]);
        	}
        });
        img1.setBounds(638, -11, 63, 85);
        img1.setIcon(new ImageIcon(ClassRecords.class.getResource("/ImagenesGym/agregarUsuario.png")));
        panel.add(img1);
        
        
        JButton btnNewButton = new JButton("Salir");
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
        btnNewButton.setBounds(585, 451, 91, 25);
        panel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(10, 55, 666, 45);
        panel.add(panel_1);
        
                JLabel lblNewLabel = new JLabel("Clientes");
                panel_1.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
    }

    public void show() {
                frame.setVisible(true);
    }

        private class ButtonRenderer extends JPanel implements TableCellRenderer {

        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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

        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
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
        	        String nombreCliente = (String) table.getModel().getValueAt(row, 0);
        	        int clienteId = buscarIdClientePorNombre(nombreCliente);
        	        if (clienteId != -1) {
        	            frame.dispose();
        	            ClientEdit.main(new String[]{Integer.toString(clienteId)});
        	        } else {
        	            JOptionPane.showMessageDialog(frame, "No se pudo encontrar el ID del cliente.");
        	        }
        	    } else if (e.getSource() == btnView) {
        	        String nombreCliente = (String) table.getModel().getValueAt(row, 0);
        	        int clienteId = buscarIdClientePorNombre(nombreCliente);
        	        if (clienteId != -1) {
        	            frame.dispose();
        	            ClientDetail.main(new String[]{Integer.toString(clienteId)});
        	        } else {
        	            JOptionPane.showMessageDialog(frame, "No se pudo encontrar el ID del cliente.");
        	        }
            }
            fireEditingStopped();
        }
        
        private int buscarIdClientePorNombre(String nombreCliente) {
            List<List<String>> clientes = controller.getAllClients();
            for (List<String> cliente : clientes) {
                String nombre = cliente.get(0); 
                if (nombre.equals(nombreCliente)) {
                    return Integer.parseInt(cliente.get(1));
                }
            }
            return -1; 
        }



    }

		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}


	
}