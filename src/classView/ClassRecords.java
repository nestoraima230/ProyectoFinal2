package classView;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.itextpdf.awt.geom.Dimension;

import clientView.ClientPanel;
import instructorsControllers.ConsultRecordsController;
import java.awt.Font;
import java.awt.GridLayout;

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
    private ConsultRecordsController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ClassRecords window = new ClassRecords();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClassRecords() {
        initialize();
        controller = new ConsultRecordsController();
        
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
          lblNewLabel.setBackground(new Color(0, 0, 0));
          lblNewLabel.setOpaque(true);
          lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
          lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
          lblNewLabel.setBounds(28, 60, 630, 40);
          panel_1.add(lblNewLabel);

          JLabel img = new JLabel();
          img.setBounds(621, 0, 63, 85);
          img.setIcon(new ImageIcon(ClientPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
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
          model.addColumn("editar   ver detalles");
          table.setModel(model);
          
          model.addRow(new Object[]{"Yoga", "1 hora", "Juan Perez", "20", "Lunes 18:00", new Object()});

          table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
              @Override
              public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                  JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
                  panel.setBackground(table.getBackground());

                  JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
                  btnEdit.setBackground(Color.WHITE);
                 
                  JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));
                  btnView.setBackground(Color.WHITE);

                  panel.add(btnEdit);
                
                  panel.add(btnView);
                 

               

                  return panel;
              }
          });

          table.setRowHeight(50);

          JButton btnNewButton = new JButton("Ok");
          btnNewButton.setBackground(new Color(0, 0, 0));
          btnNewButton.setForeground(new Color(255, 255, 255));
          btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
          btnNewButton.setBounds(558, 457, 100, 24);
          panel_1.add(btnNewButton);
      }

      
    public JFrame getFrame() {
        return frame;
    }
}
