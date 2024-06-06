package classView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import authControllers.classControllers;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JTable;

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
                new Object()     
            });
        }


        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
                panel.setBackground(table.getBackground());

                JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
                JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));

                btnEdit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //int rowIndex = table.convertRowIndexToModel(row);
                        
                        //String claseSeleccionada = (String) table.getModel().getValueAt(rowIndex, 0);
                        

                        ClassEdit editWindow = new ClassEdit();
                        editWindow.setVisible(true);
                    }
                });

                btnView.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rowIndex = table.convertRowIndexToModel(row);
                        
                        String claseSeleccionada = (String) table.getModel().getValueAt(rowIndex, 0);
                        

                        //classDetails detailsWindow = new classDetails(claseSeleccionada);
                      //  detailsWindow.setVisible(true);
                    }
                });

                panel.add(btnEdit);
                panel.add(btnView);

                return panel;
            }
        });


        table.setRowHeight(50);

        btnMostrarDetalle = new JButton("Mostrar Detalle");
        btnMostrarDetalle.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnMostrarDetalle.setBounds(28, 457, 130, 24);
        panel_1.add(btnMostrarDetalle);

        JButton btnNewButton = new JButton("Salir");
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

    public JFrame getFrame() {
        return frame;
    }
}
