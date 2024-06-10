package instructorsViews;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import MainView.MainWindows;
import authControllers.instructorControllers;
import clientView.ClientPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultRecords {

    private JFrame frame;
    private JTable table;
    private instructorControllers controller;

    public static void main(String[] args) {
    	EventQueue.invokeLater(() -> {
    	    ConsultRecords window = new ConsultRecords();
    	    window.frame.setVisible(true);
    	    window.table.repaint();
    	});


    }

    public ConsultRecords() {
        initialize();
        controller = new instructorControllers();
        displayInstructors();
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

        JLabel lblNewLabel = new JLabel("Instructores");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel.setBounds(27, 58, 630, 52);
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 109, 630, 323);
        panel_1.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Especialidad");
        model.addColumn("Email");
        model.addColumn("editar         ver detalle");
        table.setModel(model);

        ButtonRenderer buttonRenderer = new ButtonRenderer();

        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);

        ButtonEditor buttonEditor = new ButtonEditor();

        table.getColumnModel().getColumn(5).setCellEditor(buttonEditor);

        table.setRowHeight(50);
        
        table.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && table.isShowing()) {
                SwingUtilities.invokeLater(() -> {
                    table.editCellAt(0, 0);
                    Component editor = table.getEditorComponent();
                    if (editor != null) {
                        editor.requestFocusInWindow();
                    }
                });
            }
        });


        JLabel img = new JLabel();
        img.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 frame.dispose();
                 InstructorCreate.main(new String[0]);
        	}
        });
        img.setBounds(621, 0, 63, 85);
        img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
        panel_1.add(img);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
                MainWindows MainWindows = new MainWindows();
                MainWindows.setVisible(true);
        	}
        });
        btnOk.setForeground(new Color(255, 255, 255));
        btnOk.setBackground(new Color(0, 0, 0));
        btnOk.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnOk.setBounds(546, 455, 111, 32);
        panel_1.add(btnOk);
        
        JButton btnSalir = new JButton("SALIR");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		InstructorPanel.main(new String[0]);
        	}
        });
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setBounds(56, 455, 111, 32);
        panel_1.add(btnSalir);
    }

    private void displayInstructors() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<List<String>> allInstructors = controller.getAllInstructors();
        model.setRowCount(0);

        for (List<String> instructorDetails : allInstructors) {

            model.addRow(new Object[]{instructorDetails.get(0), instructorDetails.get(1), instructorDetails.get(2), instructorDetails.get(3), instructorDetails.get(4), ""});
        }
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
  	        String nombreInstructor = (String) table.getModel().getValueAt(row, 1);
  	        int instructorId = buscarIdInstructorPorNombre(nombreInstructor);
  	        if (instructorId != -1) {
  	            frame.dispose();
  	            InstructorEdit.main(new String[]{Integer.toString(instructorId)});
  	        } else {
  	            JOptionPane.showMessageDialog(frame, "No se pudo encontrar el ID del instructor.");
  	        }
  	    } else if (e.getSource() == btnView) {
                frame.dispose();
                InstructorsDetails.main(new String[0]);
            }
            fireEditingStopped();
        }
    }
    
    private int buscarIdInstructorPorNombre(String nombreInstructor) {
        List<List<String>> instructores = controller.getAllInstructors();
        for (List<String> instructor : instructores) {
            String nombre = instructor.get(1); 
            if (nombre.equals(nombreInstructor)) {
                return Integer.parseInt(instructor.get(0));
            }
        }
        return -1; 
    }
}
