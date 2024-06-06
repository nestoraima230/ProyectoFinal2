package clientView;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import instructorsViews.InstructorCredential;
import instructorsViews.InstructorsDetails;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credential {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credential window = new Credential();
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
	public Credential() {
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Credential.class.getResource("/ImagenesGym/Credential.png")));
		lblNewLabel.setBounds(126, 28, 425, 376);
		panel.add(lblNewLabel);
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
		
		JLabel lblNewLabel_6 = new JLabel("[Nombre]");
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
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 316, 252, 74);
		panel_1_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/BarrasChikitas.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 32, 252, 74);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(InstructorCredential.class.getResource("/ImagenesGym/LogoChikito2.png")));
		lblNewLabel1.setBounds(78, 0, 94, 74);
		panel_2.add(lblNewLabel1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(0, 316, 252, 74);
		panel_1_1.add(panel_2_1_1);
		
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

	public void show() {
		// TODO Auto-generated method stub
		
	}

}