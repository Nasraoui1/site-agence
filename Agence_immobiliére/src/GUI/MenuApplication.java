package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuApplication {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuApplication window = new MenuApplication();
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
	public MenuApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1015, 718);
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agence Immobiliére");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 65));
		lblNewLabel.setBounds(209, 42, 632, 114);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnClient = new JButton("Client");
		btnClient.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients window = new Clients();
				window.frame.setVisible(true);
			}
		});
		btnClient.setBounds(311, 225, 416, 48);
		frame.getContentPane().add(btnClient);
		
		JButton btnBiens = new JButton("Biens");
		btnBiens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Biens window = new Biens();
				window.frame.setVisible(true);
			}
		});
		btnBiens.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		btnBiens.setBounds(311, 327, 416, 48);
		frame.getContentPane().add(btnBiens);
		
		JButton btnLocation = new JButton("Location");
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locations window=new Locations();
				window.frame.setVisible(true);
			}
		});
		btnLocation.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		btnLocation.setBounds(311, 438, 416, 48);
		frame.getContentPane().add(btnLocation);
	}
}
