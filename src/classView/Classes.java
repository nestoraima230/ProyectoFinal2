package classView;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTable;

public class Classes {

    private JFrame frame;
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private JButton btnCrearClase;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Classes window = new Classes();
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
    public Classes() {
        initialize();
    }
    
    public JButton getBtnCrearClase() {
        return btnCrearClase;
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
        panel.setBounds(0, 0, 684, 511);
        panel.setBackground(new Color(148, 121, 150));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(31, 78, 186, 355);
        panel.add(panel_1_1);
        panel_1_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Classes.class.getResource("/ImagenesGym/tipos-zumba_0 icono.jpg")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 166, 144);
        panel_1_1.add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("Detalles");
        btnNewButton_1.setBackground(new Color(144, 45, 65));
        btnNewButton_1.setOpaque(true);
        btnNewButton_1.setForeground(new Color(255, 255, 255 )); 
        btnNewButton_1.setBounds(48, 321, 89, 23);
        panel_1_1.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("Zumba");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setBackground(new Color(144, 45, 65));
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setForeground(new Color(255, 255, 255 ));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 155, 166, 31);
        panel_1_1.add(lblNewLabel_2);

        table = new JTable();
        table.setBounds(10, 185, 166, 125);
        panel_1_1.add(table);

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setBounds(248, 78, 186, 355);
        panel.add(panel_1_1_1);
        panel_1_1_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(new Color(0, 0, 0));
        lblNewLabel_1.setIcon(new ImageIcon(Classes.class.getResource("/ImagenesGym/crossfit icono.jpg")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 11, 166, 144);
        panel_1_1_1.add(lblNewLabel_1);
        
        JButton btnNewButton_1_1 = new JButton("Detalles");
        btnNewButton_1_1.setOpaque(true);
        btnNewButton_1_1.setForeground(Color.WHITE);
        btnNewButton_1_1.setBackground(new Color(144, 45, 65));
        btnNewButton_1_1.setBounds(48, 321, 89, 23);
        panel_1_1_1.add(btnNewButton_1_1);
        
        table_1 = new JTable();
        table_1.setBounds(10, 185, 166, 125);
        panel_1_1_1.add(table_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Cross Fit");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2_1.setOpaque(true);
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setBackground(new Color(144, 45, 65));
        lblNewLabel_2_1.setBounds(10, 155, 166, 31);
        panel_1_1_1.add(lblNewLabel_2_1);

        JPanel panel_1_1_1_1 = new JPanel();
        panel_1_1_1_1.setBounds(465, 78, 186, 355);
        panel.add(panel_1_1_1_1);
        panel_1_1_1_1.setLayout(null);

        JButton btnNewButton_3 = new JButton("Detalles");
        btnNewButton_3.setBackground(new Color(144, 45, 65));
        btnNewButton_3.setOpaque(true);
        btnNewButton_3.setForeground(new Color(255, 255, 255 ));
        panel_1_1_1_1.add(btnNewButton_3);

        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(Classes.class.getResource("/ImagenesGym/body-combat icono.jpg")));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(10, 11, 166, 144);
        panel_1_1_1_1.add(lblNewLabel_1_1);
        
        JButton btnNewButton_1_2 = new JButton("Detalles");
        btnNewButton_1_2.setOpaque(true);
        btnNewButton_1_2.setForeground(Color.WHITE);
        btnNewButton_1_2.setBackground(new Color(144, 45, 65));
        btnNewButton_1_2.setBounds(48, 321, 89, 23);
        panel_1_1_1_1.add(btnNewButton_1_2);
        
        table_2 = new JTable();
        table_2.setBounds(10, 185, 166, 125);
        panel_1_1_1_1.add(table_2);
        
        JLabel lblNewLabel_2_2 = new JLabel("Body Combat");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2_2.setOpaque(true);
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setBackground(new Color(144, 45, 65));
        lblNewLabel_2_2.setBounds(10, 155, 166, 31);
        panel_1_1_1_1.add(lblNewLabel_2_2);

        
            JButton btnNewButton = new JButton("Regresar");
            btnNewButton.setBounds(31, 463, 100, 32);
            panel.add(btnNewButton);
            
            JLabel lblNewLabel_2_3 = new JLabel("Clases");
            lblNewLabel_2_3.setOpaque(true);
            lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_2_3.setForeground(Color.WHITE);
            lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_2_3.setBackground(new Color(144, 45, 65));
            lblNewLabel_2_3.setBounds(0, 11, 684, 40);
            panel.add(lblNewLabel_2_3);
            
            btnCrearClase = new JButton("Crear Clase");
            btnCrearClase.setBounds(572, 463, 100, 32);
            panel.add(btnCrearClase);
        }

        public Window getFrame() {
            return frame;
        }
}