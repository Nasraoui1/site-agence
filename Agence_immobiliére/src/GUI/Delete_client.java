package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Entities.Client;
import Services.ClientCRUD;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Delete_client {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_client window = new Delete_client();
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
	public Delete_client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.getContentPane().setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		frame.setBounds(100, 100, 1007, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(347, 162, 296, 39);
		frame.getContentPane().add(comboBox);
		ClientCRUD client_supprimer= new ClientCRUD();
		List<Client> liste= new ArrayList();
		liste=client_supprimer.afficherClient();
		for(int i=0 ; i<liste.size();i++) {
			
			Object Item = liste.get(i).getNom()+" "+liste.get(i).getPrenom();
			comboBox.addItem(Item);
		}
		
		JLabel lblNewLabel = new JLabel("Supprimer Client");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 45));
		lblNewLabel.setBounds(297, 36, 375, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnButton = new JButton("Confirmer");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_prenom=comboBox.getSelectedItem().toString();
				int pos=nom_prenom.indexOf(" ");
				
				String nom=nom_prenom.substring(0,pos);
				String prenom=nom_prenom.substring(pos+1);
				
				
				Client client_by_name= client_supprimer.getClient(nom,prenom);
				client_supprimer.supprimerClient(client_by_name.getCIN());
				Clients window=new Clients();
				window.frame.setVisible(true);
			}
		});
		btnButton.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 28));
		btnButton.setBounds(360, 299, 283, 47);
		frame.getContentPane().add(btnButton);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients window=new Clients();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(856, 421, 111, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
