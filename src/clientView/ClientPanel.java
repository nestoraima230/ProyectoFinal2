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
import javax.swing.table.TableCellEditor;

import authControllers.clientControllers;
import instructorsViews.InstructorPanel;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.AbstractCellEditor;

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
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 686, 513);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Clientes");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(303, 14, 169, 30);
        panel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 75, 666, 331);
        panel.add(scrollPane);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Acciones");

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
        
        JButton btnNewButton = new JButton("OK");
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(565, 467, 85, 21);
        panel.add(btnNewButton);
    }

    public void show() {
        // Make the frame visible
        frame.setVisible(true);
    }

    // Custom renderer for buttons in the table
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

    // Custom editor for buttons in the table
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
        	            ClientDetail clientDetail = new ClientDetail(clienteId);
        	            clientDetail.show();
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
}