package classView;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
<<<<<<< HEAD

import authControllers.classControllers;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.util.List;

=======
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Window;
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
import javax.swing.JButton;

public class ClassPanel {

	private JFrame frame;
	private JTable table;
    private classControllers controller;

<<<<<<< HEAD

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassPanel window = new ClassPanel();
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
	public ClassPanel() {
        controller = new classControllers();
		initialize();
	}
=======
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClassPanel window = new ClassPanel();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClassPanel() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784

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

		JLabel lblNewLabel = new JLabel("Clases");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(303, 14, 169, 30);
		panel.add(lblNewLabel);

		  JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(10, 75, 666, 331);
	        panel.add(scrollPane);

<<<<<<< HEAD
	       
	        table = new JTable();

	   
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Nombre");
	        model.addColumn("");
	        
	        List<List<String>> clases = controller.getAllClases();
	        for (List<String> clase : clases) {
	            model.addRow(new Object[]{clase.get(1)});
	        }

	        

	       
	        table.setModel(model);

	        table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
	                panel.setBackground(table.getBackground());

	                JButton btnEdit = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/boton-editar.png")));
	                JButton btnView = new JButton(new ImageIcon(getClass().getResource("/ImagenesGym/ver-detalles.png")));

	                panel.add(btnEdit);
	                panel.add(btnView);

	                return panel;
	            }
	        });

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
}
=======
        JLabel img= new JLabel ();
        img.setBounds(613,-13,63,85);
        img.setIcon(new ImageIcon(ClassPanel.class.getResource("/ImagenesGym/agregarUsuario.png")));
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
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(565, 467, 85, 21);
        panel.add(btnNewButton);
    }

    public Window getFrame() {
        return frame;
    }

    public JButton getBtnMostrarClasses() {
        return btnMostrarClasses;
    }

    public JButton getBtnMostrarRecords() {
        return btnMostrarRecords;
    }

    private JButton btnMostrarClasses;
    private JButton btnMostrarRecords;
}
>>>>>>> 0b42efe94cc4f697257abe3050ef315e3be7c784
