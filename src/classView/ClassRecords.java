package classView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import MainView.MainRegister;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JOptionPane;

import authControllers.classControllers;
import clientView.ClientDetail;
import clientView.ClientEdit;
import clientView.ClientPanel;

public class ClassRecords {

    private JFrame frame;
    private JTable table;
    private classControllers controller;
    private JButton btnMostrarDetalle;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClassRecords window = new ClassRecords();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClassRecords() {
        controller = new classControllers();
        initialize();
    }

    public JButton getBtnMostrarDetalle() {
        return btnMostrarDetalle;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 684, 511);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(148, 121, 150));
        panel_1.setBounds(0, 0, 684, 511);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Registro de Clases");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(144, 45, 65));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(139, 20, 400, 40);
        panel_1.add(lblNewLabel);

        JLabel img = new JLabel();
        img.setBounds(621, 36, 63, 85);
        img.setIcon(new ImageIcon(ClassRecords.class.getResource("/ImagenesGym/agregarUsuario.png")));
        panel_1.add(img);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 97, 630, 350);
        panel_1.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Clase");
        model.addColumn("Duracion");
        model.addColumn("Instructor");
        model.addColumn("Capacidad");
        model.addColumn("Horario");
        model.addColumn("");
        table.setModel(model);

        List<List<String>> clases = controller.getAllClases();
        for (List<String> clase : clases) {
            model.addRow(new Object[]{
                clase.get(1),    
                clase.get(3),    
                clase.get(4),    
                clase.get(5),    
                clase.get(2),    
                ""  

            });
        }

        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor());

        table.setRowHeight(50);

        btnMostrarDetalle = new JButton("Mostrar Detalle");
        btnMostrarDetalle.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnMostrarDetalle.setBounds(28, 457, 130, 24);
        panel_1.add(btnMostrarDetalle);

        JButton btnNewButton = new JButton("Salir");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		ClassPanel.main(new String[0]);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(168, 457, 100, 24);
        panel_1.add(btnNewButton);

        JButton btnNewButton1 = new JButton("Ok");
        btnNewButton1.setBackground(new Color(0, 0, 0));
        btnNewButton1.setForeground(new Color(255, 255, 255));
        btnNewButton1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnNewButton1.setBounds(558, 457, 100, 24);
        panel_1.add(btnNewButton1);
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
  	        String nombreClase = (String) table.getModel().getValueAt(row, 0);
  	        int claseId = buscarIdClasePorNombre(nombreClase);
  	        if (claseId != -1) {
  	            frame.dispose();
  	            ClassEdit.main(new String[]{Integer.toString(claseId)});
  	        } else {
                System.out.println("");

  	        }
  	    } else if (e.getSource() == btnView) {
            String claseNombre = (String) table.getModel().getValueAt(row, 0);
            int claseId = buscarIdClasePorNombre(claseNombre);
            if (claseId != -1) {
                frame.dispose();
                ClassDetail.main(new String[]{Integer.toString(claseId)});
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró la clase seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            }                                
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

    public JFrame getFrame() {
        return frame;
    }
}
