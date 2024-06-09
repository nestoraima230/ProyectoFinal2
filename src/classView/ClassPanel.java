package classView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.EventObject;

import authControllers.classControllers;
import clientView.ClientEdit;
import clientView.ClientPanel;
import instructorsViews.InstructorEdit;

public class ClassPanel {

    private JFrame frame;
    private JTable table;
    private classControllers controller;

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
            model.addRow(new Object[]{clase.get(1)});
        }

        table.setModel(model);

        // Crear un renderizador de botones personalizado
        ButtonRenderer buttonRenderer = new ButtonRenderer();

        // Asignar el renderizador personalizado a la columna de botones
        table.getColumnModel().getColumn(1).setCellRenderer(buttonRenderer);

        // Crear un editor de botones personalizado
        ButtonEditor buttonEditor = new ButtonEditor();

        // Asignar el editor personalizado a la columna de botones
        table.getColumnModel().getColumn(1).setCellEditor(buttonEditor);

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

    private class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer() {
            setLayout(new GridLayout(1, 2, 10, 0));
            setBackground(Color.WHITE);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Crear botones nuevos para cada celda
            JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
            panel.setBackground(Color.WHITE);
            JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
            JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
            panel.add(btnEdit);
            panel.add(btnView);
            return panel;
        }
    }


    private class ButtonEditor extends javax.swing.AbstractCellEditor implements TableCellEditor, ActionListener {

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
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
      	  if (e.getSource() == btnEdit) {
  	        String nombreClase = (String) table.getModel().getValueAt(row, 0);
  	        int claseId = buscarIdClasePorNombre(nombreClase);
  	        if (claseId != -1) {
  	            frame.dispose();
  	            ClassEdit.main(new String[]{Integer.toString(claseId)});
  	        } else {
  	            JOptionPane.showMessageDialog(frame, "No se pudo encontrar el ID del cliente.");
  	        }
  	    } else if (e.getSource() == btnView) {
            }
            fireEditingStopped();
        }
        
        private int buscarIdClasePorNombre(String nombreClase) {
            List<List<String>> clases = controller.getAllClases();
            for (List<String> clase : clases) {
                String nombre = clase.get(1); 
                if (nombre.equals(nombreClase)) {
                    return Integer.parseInt(clase.get(0));
                }
            }
            return -1; 
        }
    }

}
