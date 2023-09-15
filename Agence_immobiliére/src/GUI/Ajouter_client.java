package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

import Entities.Client;
import Services.ClientCRUD;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Ajouter_client {

	public JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JLabel lblPrenom;
	private JTextField txtCIN;
	private JLabel lblCin;
	private JTextField txtNum;
	private JLabel lblNumroDeTlphone;
	private JTextField txtEmail;
	private JLabel lblEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_client window = new Ajouter_client();
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
	public Ajouter_client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 750, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setBounds(275, 94, 173, 19);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 100, 83, 13);
		frame.getContentPane().add(lblNewLabel);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(275, 136, 173, 19);
		frame.getContentPane().add(txtPrenom);
		
		lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblPrenom.setBounds(41, 142, 83, 13);
		frame.getContentPane().add(lblPrenom);
		
		txtCIN = new JTextField();
		txtCIN.setColumns(10);
		txtCIN.setBounds(275, 181, 173, 19);
		frame.getContentPane().add(txtCIN);
		
		lblCin = new JLabel("CIN :");
		lblCin.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblCin.setBounds(41, 187, 83, 13);
		frame.getContentPane().add(lblCin);
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(275, 229, 173, 19);
		frame.getContentPane().add(txtNum);
		
		lblNumroDeTlphone = new JLabel("Numéro de téléphone :");
		lblNumroDeTlphone.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblNumroDeTlphone.setBounds(41, 235, 196, 13);
		frame.getContentPane().add(lblNumroDeTlphone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(275, 268, 173, 19);
		frame.getContentPane().add(txtEmail);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblEmail.setBounds(41, 274, 83, 13);
		frame.getContentPane().add(lblEmail);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client= new Client(txtNom.getText(),txtPrenom.getText(),Integer.parseInt(txtCIN.getText()),Long.parseLong(txtNum.getText()),txtEmail.getText());
				ClientCRUD client_ajouter= new ClientCRUD();
				client_ajouter.ajouterClient(client);
				Clients window=new Clients();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		btnNewButton.setBounds(275, 371, 179, 33);
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter Client");
		lblNewLabel_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 28));
		lblNewLabel_1.setBounds(240, 27, 196, 45);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
