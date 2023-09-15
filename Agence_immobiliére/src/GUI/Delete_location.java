package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entities.Bien;
import Entities.Client;
import Entities.Location;
import Services.BienCRUD;
import Services.ClientCRUD;
import Services.LocationCRUD;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete_location {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_location window = new Delete_location();
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
	public Delete_location() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 756, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supprimer Location");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 45));
		lblNewLabel.setBounds(158, 61, 432, 66);
		frame.getContentPane().add(lblNewLabel);
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		btnNewButton.setBounds(226, 369, 282, 44);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		comboBox.setBounds(109, 228, 512, 44);
frame.getContentPane().add(comboBox);
JButton btnNewButton_1 = new JButton("Retour");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Locations window=new Locations();
		window.frame.setVisible(true);
	}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
btnNewButton_1.setBounds(609, 448, 107, 21);
frame.getContentPane().add(btnNewButton_1);
		
		ClientCRUD clientcrud= new ClientCRUD();
		BienCRUD biencrud= new BienCRUD();
		LocationCRUD locationcrud= new LocationCRUD();
		List<Location> liste=new ArrayList();
		liste= locationcrud.afficherLocation();
		for(int i=0 ; i<liste.size();i++) {
			Client client=clientcrud.getClientByCIN(liste.get(i).getCIN_Client());
			Bien bien=biencrud.geBienByReference(liste.get(i).getReference_Bien());
			Object Item = client.getNom()+" "+client.getPrenom()+"("+bien.getAdresse()+")";
			comboBox.addItem(Item);
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loc=comboBox.getSelectedItem().toString();
				int pos=loc.indexOf(" ");
				int pos1=loc.indexOf("(");
				
				String nom=loc.substring(0,pos);
				String prenom=loc.substring(pos+1,pos1);
				
				
				Client client_by_name= clientcrud.getClient(nom,prenom);
				LocationCRUD locationcrud= new LocationCRUD();
				System.out.println(client_by_name.getCIN());
				int id=locationcrud.getLocation(client_by_name.getCIN()).getId_Location();
				System.out.println(id);
				locationcrud.supprimerLocation(id);
				Locations window=new Locations();
				window.frame.setVisible(true);
			}
		});
		
		
	}

}
