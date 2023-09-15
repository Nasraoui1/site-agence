package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entities.Appartement;
import Entities.Client;
import Entities.Garage;
import Entities.Location;
import Entities.Maison;
import Services.AppartementCRUD;
import Services.ClientCRUD;
import Services.GarageCRUD;
import Services.LocationCRUD;
import Services.MaisonCRUD;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Ajouter_Location {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_Location window = new Ajouter_Location();
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
	public Ajouter_Location() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 934, 679);
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter Location");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 45));
		lblNewLabel.setBounds(254, 42, 396, 112);
		frame.getContentPane().add(lblNewLabel);
		JComboBox comboBox_Bien = new JComboBox();
		comboBox_Bien.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		comboBox_Bien.setBounds(275, 266, 329, 58);
		frame.getContentPane().add(comboBox_Bien);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type_bien=comboBox.getSelectedItem().toString();
				
				if(type_bien=="Appartement")
				{
					List<Appartement> liste= new ArrayList();
					AppartementCRUD appartement= new AppartementCRUD();
					liste=appartement.afficherAppartement();
					for(int i=0 ; i<liste.size();i++) {
						
						Object Item = liste.get(i).getAdresse();
						comboBox_Bien.addItem(Item);
					}
				} 
				else if(type_bien=="Maison")
				{
					List<Maison> liste= new ArrayList();
					MaisonCRUD maison= new MaisonCRUD();
					liste=maison.afficherMaison();
					for(int i=0 ; i<liste.size();i++) {
						
						Object Item = liste.get(i).getAdresse();
						comboBox_Bien.addItem(Item);
					}
				}else if(type_bien=="Garage")
				{
					List<Garage> liste= new ArrayList();
					GarageCRUD garage= new GarageCRUD();
					liste=garage.afficherGarage();
					for(int i=0 ; i<liste.size();i++) {
						
						Object Item = liste.get(i).getAdresse();
						comboBox_Bien.addItem(Item);
					}
				}
			}
		});
		comboBox.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Appartement", "Maison", "Garage"}));
		comboBox.setBounds(275, 181, 329, 58);
		frame.getContentPane().add(comboBox);
		
		
		
		JComboBox comboBox_Client = new JComboBox();
	
				
				ClientCRUD clientcrud=new ClientCRUD();
				List<Client> liste= new ArrayList();
				liste=clientcrud.afficherClient();
				for(int i=0 ; i<liste.size();i++) {
					
					Object Item = liste.get(i).getNom()+" "+liste.get(i).getPrenom();
					comboBox_Client.addItem(Item);
				}
			
		
		comboBox_Client.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		comboBox_Client.setBounds(275, 373, 329, 58);
		frame.getContentPane().add(comboBox_Client);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type_bien=comboBox.getSelectedItem().toString();
				int reference=0;
				if(type_bien=="Appartement")
				{
					AppartementCRUD appratementcrud=new AppartementCRUD();
					 reference = appratementcrud.getApparatement(comboBox_Bien.getSelectedItem().toString());
					 System.out.println(reference);
				}
				else if(type_bien=="Maison")
				{
					MaisonCRUD maisoncrud=new MaisonCRUD();
					 reference = maisoncrud.getMaisont(comboBox_Bien.getSelectedItem().toString());
					 System.out.println(reference);
				}
				else if(type_bien=="Garage")
				{
					GarageCRUD garagecrud=new GarageCRUD();
					 reference = garagecrud.getGarage(comboBox_Bien.getSelectedItem().toString());
					 System.out.println(reference);
				} 		
				String nom_prenom=comboBox_Client.getSelectedItem().toString();
				int pos=nom_prenom.indexOf(" ");
				
				String nom=nom_prenom.substring(0,pos);
				String prenom=nom_prenom.substring(pos+1);
				ClientCRUD client=new ClientCRUD();
				Client client_by_name= client.getClient(nom,prenom);
				LocationCRUD locationcrud=new LocationCRUD();
				if(reference!=0) {
				Location location=new Location(reference,client_by_name.getCIN());
				locationcrud.ajouterLocation(location);
				Locations window_ajouter =new Locations();
				window_ajouter.frame.setVisible(true);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 35));
		btnNewButton.setBounds(303, 511, 275, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locations window=new Locations();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(745, 590, 111, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
