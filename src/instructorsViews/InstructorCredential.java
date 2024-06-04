package instructorsViews;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class InstructorCredential {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorCredential window = new InstructorCredential();
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
	public InstructorCredential() {
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
		panel.setBackground(new Color(148, 121, 150));
		panel.setBounds(0, 0, 684, 511);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144, 45, 65));
		panel_1.setBounds(60, 31, 252, 420);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(0, 32, 252, 74);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/LogoChikito2.png")));
		lblNewLabel_1.setBounds(78, 0, 94, 74);
		panel_2_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 160, 212, 180);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/entrenadoresChikitos.jpg")));
		lblNewLabel_2.setBounds(0, 0, 212, 180);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("[Ingresa el Nombre]");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(20, 364, 212, 32);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(144, 45, 65));
		panel_1_1.setBounds(372, 31, 252, 420);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 280, 252, 74);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/LogoChikito2.png")));
		lblNewLabel.setBounds(0, 0, 94, 74);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("612 345 1290");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(104, 11, 138, 52);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(65, 129, 122, 122);
		panel_1_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/QRchikito.jpg")));
		lblNewLabel_3.setBounds(0, 0, 122, 122);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(0, 29, 252, 74);
		panel_1_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/BarrasChikitas.png")));
		lblNewLabel_4.setBounds(0, 0, 252, 74);
		panel_2_1_1.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(60, 477, 95, 24);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	InstructorsDetails InstructorsDetails = new InstructorsDetails();
            	InstructorsDetails.getFrame().setVisible(true);
            }
        });
		
		JButton btnNewButton_1 = new JButton("Descargar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(529, 477, 95, 24);
		panel.add(btnNewButton_1);
	
	}
	
    public JFrame getFrame() {
        return frame;
    }

}
	