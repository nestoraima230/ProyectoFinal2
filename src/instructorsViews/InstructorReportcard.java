package instructorsViews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import classView.ClassRecords;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InstructorReportcard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorReportcard window = new InstructorReportcard();
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
	public InstructorReportcard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frame.dispose();
                 ClassRecords.main(new String[0]);
			}
		});
		btnNewButton_1.setBounds(528, 437, 128, 32);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setOpaque(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(193, 28, 280, 451);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carta de Reporte");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(144, 45, 65));
		lblNewLabel.setBounds(24, 35, 230, 40);
		panel_2.add(lblNewLabel);
		
		JTextPane txtpnInstruc = new JTextPane();
		txtpnInstruc.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnInstruc.setText("Instructores especializados en tecnicas de Gimnasio y Musculatura");
		txtpnInstruc.setBounds(10, 106, 260, 53);
		panel_2.add(txtpnInstruc);
		
		JTextPane txtpnCapacidadParaLa = new JTextPane();
		txtpnCapacidadParaLa.setBackground(new Color(148, 121, 150));
		txtpnCapacidadParaLa.setText("Capacidad para la guia y motivacion de los clientes");
		txtpnCapacidadParaLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnCapacidadParaLa.setBounds(10, 181, 260, 53);
		panel_2.add(txtpnCapacidadParaLa);
		
		JTextPane txtpnInstruc_1_1 = new JTextPane();
		txtpnInstruc_1_1.setBackground(new Color(148, 121, 150));
		txtpnInstruc_1_1.setText("Certificacion en reanimacion y primeros auxilios");
		txtpnInstruc_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnInstruc_1_1.setBounds(10, 263, 260, 53);
		panel_2.add(txtpnInstruc_1_1);
		
		JTextPane txtpnInstruc_1_1_1 = new JTextPane();
		txtpnInstruc_1_1_1.setBackground(new Color(148, 121, 150));
		txtpnInstruc_1_1_1.setText("Diseño de rutinas confiables y efectivas");
		txtpnInstruc_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnInstruc_1_1_1.setBounds(10, 344, 260, 53);
		panel_2.add(txtpnInstruc_1_1_1);
		
		JButton btnNewButton = new JButton("Descargar ");
		btnNewButton.setBounds(154, 407, 116, 28);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 121, 150));
		panel_1.setBounds(690, 0, 0, 511);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InstructorReportcard.class.getResource("/ImagenesGym/PesasChikitas.jpg")));
		lblNewLabel_1.setBounds(0, 0, 705, 511);
		panel.add(lblNewLabel_1);
		
		
	}
	
    public JFrame getFrame() {
        return frame;
    }
}