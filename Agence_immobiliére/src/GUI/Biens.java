package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import Services.AppartementCRUD;
import Services.BienCRUD;
import Services.GarageCRUD;
import Services.MaisonCRUD;
import Entities.Appartement;
import Entities.Bien;
import Entities.Garage;
import Entities.Maison;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Biens {

	public JFrame frame;
	private JTable tableb;
	private JTextField tfreference;
	private JTextField tfadresse;
	private JTextField tftarif;
	private JTextField tfdatedebutlocation;
	private JTextField tfsurfacetotal;
	private JTextField tfnbchambre;
	private JTextField tfnumetageappart;
	private JTextField tfsurfaceappart;
	private JTextField tfnumempgarage;
	private JTextField tfsurfacegarage;
	private JTextField tfnbetagemaison;
	private JTextField tfsurfacemaison;
	private JTable tablem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biens window = new Biens();
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
	public Biens() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBackground(new Color(192, 192, 192));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setToolTipText("");
		panel.setBounds(10, 10, 1530, 34);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setBounds(100, 100, 1747, 856);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		affiche();
		 /************************************/
	
		
		JLabel lblNewLabel = new JLabel("Reference ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 100, 169, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse.setBounds(10, 130, 169, 25);
		frame.getContentPane().add(lblAdresse);
		
		JLabel lblTarifTotal = new JLabel("Tarif ");
		lblTarifTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTarifTotal.setBounds(10, 165, 169, 25);
		frame.getContentPane().add(lblTarifTotal);
		
		JLabel lblEnLocation = new JLabel("En Location");
		lblEnLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnLocation.setBounds(10, 200, 169, 25);
		frame.getContentPane().add(lblEnLocation);
		
		JLabel lblDateDebutLocation = new JLabel("Date Debut Location");
		lblDateDebutLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateDebutLocation.setBounds(10, 235, 207, 25);
		frame.getContentPane().add(lblDateDebutLocation);
		
		JLabel lblAttributsAppartement = new JLabel("Attributs Appartement");
		lblAttributsAppartement.setForeground(new Color(64, 0, 64));
		lblAttributsAppartement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAttributsAppartement.setBounds(42, 317, 251, 25);
		frame.getContentPane().add(lblAttributsAppartement);
		
		JLabel lblMeuble = new JLabel("Meuble");
		lblMeuble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMeuble.setBounds(10, 352, 169, 25);
		frame.getContentPane().add(lblMeuble);
		
		JLabel lblBalcon = new JLabel("Balcon");
		lblBalcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBalcon.setBounds(10, 387, 169, 25);
		frame.getContentPane().add(lblBalcon);
		
		JLabel lblNombreDeChambre = new JLabel("Nombre de Chambre");
		lblNombreDeChambre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreDeChambre.setBounds(10, 422, 207, 25);
		frame.getContentPane().add(lblNombreDeChambre);
		
		JLabel lblNumeroEtage = new JLabel("Numero Etage");
		lblNumeroEtage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroEtage.setBounds(10, 457, 169, 25);
		frame.getContentPane().add(lblNumeroEtage);
		
		JLabel lblSurfaceAppartement = new JLabel("Surface Appartement");
		lblSurfaceAppartement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurfaceAppartement.setBounds(10, 492, 207, 25);
		frame.getContentPane().add(lblSurfaceAppartement);
		
		JLabel lblAttributsGarage = new JLabel("Attributs Garage");
		lblAttributsGarage.setForeground(new Color(64, 0, 64));
		lblAttributsGarage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAttributsGarage.setBounds(67, 527, 251, 25);
		frame.getContentPane().add(lblAttributsGarage);
		
		JLabel lblNumeroEmplacement = new JLabel("Numero Emplacement");
		lblNumeroEmplacement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroEmplacement.setBounds(10, 562, 207, 25);
		frame.getContentPane().add(lblNumeroEmplacement);
		
		JLabel lblSurfaceGarage = new JLabel("Surface Garage");
		lblSurfaceGarage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurfaceGarage.setBounds(10, 597, 207, 25);
		frame.getContentPane().add(lblSurfaceGarage);
		
		JLabel lblSurface = new JLabel("Surface Total ");
		lblSurface.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurface.setBounds(10, 270, 207, 25);
		frame.getContentPane().add(lblSurface);
		
		JLabel lblAttributsMaison = new JLabel("Attributs Maison");
		lblAttributsMaison.setForeground(new Color(64, 0, 64));
		lblAttributsMaison.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAttributsMaison.setBounds(67, 632, 251, 25);
		frame.getContentPane().add(lblAttributsMaison);
		
		JLabel lblNombreEtage = new JLabel("Nombre Etage");
		lblNombreEtage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreEtage.setBounds(10, 667, 207, 25);
		frame.getContentPane().add(lblNombreEtage);
		
		JLabel lblJardin = new JLabel("Jardin");
		lblJardin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJardin.setBounds(10, 702, 207, 25);
		frame.getContentPane().add(lblJardin);
		
		JLabel lblSurfaceMaison = new JLabel("Surface Maison");
		lblSurfaceMaison.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurfaceMaison.setBounds(10, 737, 207, 25);
		frame.getContentPane().add(lblSurfaceMaison);
		
		tfreference = new JTextField();
		tfreference.setBounds(224, 107, 96, 19);
		frame.getContentPane().add(tfreference);
		tfreference.setColumns(10);
		
		tfadresse = new JTextField();
		tfadresse.setColumns(10);
		tfadresse.setBounds(222, 137, 96, 19);
		frame.getContentPane().add(tfadresse);
		
		tftarif = new JTextField();
		tftarif.setColumns(10);
		tftarif.setBounds(222, 172, 96, 19);
		frame.getContentPane().add(tftarif);
		
		tfdatedebutlocation = new JTextField();
		tfdatedebutlocation.setColumns(10);
		tfdatedebutlocation.setBounds(222, 242, 96, 19);
		frame.getContentPane().add(tfdatedebutlocation);
		
		tfsurfacetotal = new JTextField();
		tfsurfacetotal.setColumns(10);
		tfsurfacetotal.setBounds(222, 270, 96, 19);
		frame.getContentPane().add(tfsurfacetotal);
		
		JCheckBox chenlocation = new JCheckBox("");
		chenlocation.setBounds(224, 206, 93, 21);
		frame.getContentPane().add(chenlocation);
		
		JCheckBox chmeuble = new JCheckBox("");
		chmeuble.setBounds(225, 356, 93, 21);
		frame.getContentPane().add(chmeuble);
		
		JCheckBox chbalcon = new JCheckBox("");
		chbalcon.setBounds(224, 387, 93, 21);
		frame.getContentPane().add(chbalcon);
		
		tfnbchambre = new JTextField();
		tfnbchambre.setColumns(10);
		tfnbchambre.setBounds(222, 429, 96, 19);
		frame.getContentPane().add(tfnbchambre);
		
		tfnumetageappart = new JTextField();
		tfnumetageappart.setColumns(10);
		tfnumetageappart.setBounds(222, 464, 96, 19);
		frame.getContentPane().add(tfnumetageappart);
		
		tfsurfaceappart = new JTextField();
		tfsurfaceappart.setColumns(10);
		tfsurfaceappart.setBounds(222, 499, 96, 19);
		frame.getContentPane().add(tfsurfaceappart);
		
		tfnumempgarage = new JTextField();
		tfnumempgarage.setColumns(10);
		tfnumempgarage.setBounds(222, 569, 96, 19);
		frame.getContentPane().add(tfnumempgarage);
		
		tfsurfacegarage = new JTextField();
		tfsurfacegarage.setColumns(10);
		tfsurfacegarage.setBounds(222, 604, 96, 19);
		frame.getContentPane().add(tfsurfacegarage);
		
		tfnbetagemaison = new JTextField();
		tfnbetagemaison.setColumns(10);
		tfnbetagemaison.setBounds(222, 667, 96, 19);
		frame.getContentPane().add(tfnbetagemaison);
		
		JCheckBox chjardin = new JCheckBox("");
		chjardin.setBounds(223, 708, 93, 21);
		frame.getContentPane().add(chjardin);
		
		tfsurfacemaison = new JTextField();
		tfsurfacemaison.setColumns(10);
		tfsurfacemaison.setBounds(222, 743, 96, 19);
		frame.getContentPane().add(tfsurfacemaison);
		
		JComboBox cbtype = new JComboBox();
		cbtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbtype.getSelectedIndex()==1) {tfsurfaceappart.show();tfnumetageappart.show();tfnbchambre.show();chmeuble.show();chbalcon.show();tfsurfacemaison.hide(); tfnbetagemaison.hide(); chjardin.hide(); tfsurfacegarage.hide();tfnumempgarage.hide();}
                if(cbtype.getSelectedIndex()==2) {tfsurfacegarage.show();tfnumempgarage.show();tfsurfacemaison.hide(); tfnbetagemaison.hide(); chjardin.hide(); tfsurfaceappart.hide();tfnumetageappart.hide();tfnbchambre.hide();chmeuble.hide();chbalcon.hide();}
                if(cbtype.getSelectedIndex()==3) {tfsurfacegarage.hide();tfnumempgarage.hide();tfsurfacemaison.show(); tfnbetagemaison.show(); chjardin.show(); tfsurfaceappart.hide();tfnumetageappart.hide();tfnbchambre.hide();chmeuble.hide();chbalcon.hide();}
			}
		});
		cbtype.setModel(new DefaultComboBoxModel(new String[] {"","Appartement", "Garage", "Maison"}));
		cbtype.setBounds(10, 69, 96, 21);
		frame.getContentPane().add(cbtype);
		
		JButton btnadd = new JButton("ADD ");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbtype.getSelectedIndex()==1) {
					// Ajout dun bien automatiquement dans ajout appartement
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					bn.ajouterBien(b);
					//Ajouter Un Appartement 
					AppartementCRUD ac = new AppartementCRUD();
					Appartement ap = new Appartement();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					if(chmeuble.isSelected()==true) {ap.setMeuble(1);}
					if(chmeuble.isSelected()==false) {ap.setMeuble(0);}
					if(chbalcon.isSelected()==true) {ap.setBalcon(1);}
					if(chbalcon.isSelected()==false) {ap.setBalcon(0);}
					ap.setNbChambre(Integer.parseInt(tfnbchambre.getText()));
					ap.setNumEtage(Integer.parseInt(tfnumetageappart.getText())); // tfsurfaceappart
					ap.setSurfaceTotalAppart(Float.parseFloat(tfsurfaceappart.getText()));
					ac.ajouterAppartement(ap);
					affiche();
				}
				if(cbtype.getSelectedIndex()==2) {
					// Ajout dun bien automatiquement dans ajout garage
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					bn.ajouterBien(b);
					//Ajouter Un garage 
					GarageCRUD ac = new GarageCRUD();
					Garage ap = new Garage();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					ap.setNumEmplacement(Integer.parseInt(tfnumempgarage.getText()));
					ap.setSurfaceGarage(Float.parseFloat(tfsurfacegarage.getText()));
					ac.ajouterGarage(ap);
					affiche();
				}
				if(cbtype.getSelectedIndex()==3) {
					// Ajout dun bien automatiquement dans ajout Maison
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					bn.ajouterBien(b);
					//Ajouter Une Maison 
					MaisonCRUD ac = new MaisonCRUD();
					Maison ap = new Maison();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					ap.setNbEtage(Integer.parseInt(tfnbetagemaison.getText()));
					if(chjardin.isSelected()==true) {ap.setJardin(1);}
					if(chjardin.isSelected()==false) {ap.setJardin(0);}
					ap.setSurfaceParEtage(Float.parseFloat(tfsurfacemaison.getText()));
					ac.ajouterMaison(ap);
					affiche();
				}
				
			}
		});
	
		btnadd.setBounds(10, 772, 85, 21);
		frame.getContentPane().add(btnadd);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbtype.getSelectedIndex()==1) {
					//supprimer bien automatiquement lors supression appartement
					BienCRUD bn =new BienCRUD();
					bn.supprimerBien(Integer.parseInt(tfreference.getText()));
					//supression appartement 
					AppartementCRUD ac = new AppartementCRUD();
					ac.supprimerAppartement(Integer.parseInt(tfreference.getText()));
					affiche();
				}
				if(cbtype.getSelectedIndex()==2) {
					// supprimer  bien automatiquement lors supression garage
					BienCRUD bn =new BienCRUD();
					bn.supprimerBien(Integer.parseInt(tfreference.getText()));
					//supression garage
					GarageCRUD ac = new GarageCRUD();
					ac.supprimerGarage(Integer.parseInt(tfreference.getText()));
					affiche();
				}
				if(cbtype.getSelectedIndex()==3) {
					// supprimer bien automatiquement lors supression Maison
					BienCRUD bn =new BienCRUD();
					bn.supprimerBien(Integer.parseInt(tfreference.getText()));
					//supression Maison
					MaisonCRUD ac = new MaisonCRUD();
					ac.supprimerMaison(Integer.parseInt(tfreference.getText()));
					affiche();
				}
				
			}
		});
		btndelete.setBounds(105, 772, 85, 21);
		frame.getContentPane().add(btndelete);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbtype.getSelectedIndex()==1) {
					//modifier bien automatiquement lors modification appartement
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					
					bn.modifierBien(b, (Integer.parseInt(tfreference.getText())));
					//modification appartement 
					AppartementCRUD ac = new AppartementCRUD();
					Appartement ap = new Appartement();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					if(chmeuble.isSelected()==true) {ap.setMeuble(1);}
					if(chmeuble.isSelected()==false) {ap.setMeuble(0);}
					if(chbalcon.isSelected()==true) {ap.setBalcon(1);}
					if(chbalcon.isSelected()==false) {ap.setBalcon(0);}
					ap.setNbChambre(Integer.parseInt(tfnbchambre.getText()));
					ap.setNumEtage(Integer.parseInt(tfnumetageappart.getText())); // tfsurfaceappart
					ap.setSurfaceTotalAppart(Float.parseFloat(tfsurfaceappart.getText()));
					
					ac.modifierBien(ap, (Integer.parseInt(tfreference.getText())));
					affiche();
				}
				if(cbtype.getSelectedIndex()==2) {
					//modifier bien automatiquement lors modification Garage
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					
					bn.modifierBien(b, (Integer.parseInt(tfreference.getText())));
					//modification Garage
					GarageCRUD ac = new GarageCRUD();
					Garage ap = new Garage();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					ap.setNumEmplacement(Integer.parseInt(tfnumempgarage.getText()));
					ap.setSurfaceGarage(Float.parseFloat(tfsurfacegarage.getText()));
					
					ac.modifierGarage(ap,  (Integer.parseInt(tfreference.getText())));
					affiche();
				}
				if(cbtype.getSelectedIndex()==3) {
					//modifier bien automatiquement lors modification Maison
					BienCRUD bn =new BienCRUD();
					Bien b = new Bien();
					b.setReference(Integer.parseInt(tfreference.getText()));
					b.setAdresse(tfadresse.getText());	
					b.setTarif_m(Float.parseFloat(tftarif.getText()));
					b.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					b.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {b.setEn_location(1);}
					if(chenlocation.isSelected()==false) {b.setEn_location(0);}
					
					bn.modifierBien(b, (Integer.parseInt(tfreference.getText())));
					//modification Maison
					MaisonCRUD ac = new MaisonCRUD();
					Maison ap = new Maison();
					ap.setReference(Integer.parseInt(tfreference.getText()));
					ap.setAdresse(tfadresse.getText());	
					ap.setTarif_m(Float.parseFloat(tftarif.getText()));
					ap.setDate_debut_location(Date.valueOf(tfdatedebutlocation.getText()));
					ap.setSurface(Float.parseFloat(tfsurfacetotal.getText()));
					if(chenlocation.isSelected()==true) {ap.setEn_location(1);}
					if(chenlocation.isSelected()==false) {ap.setEn_location(0);}
					ap.setNbEtage(Integer.parseInt(tfnbetagemaison.getText()));
					if(chjardin.isSelected()==true) {ap.setJardin(1);}
					if(chjardin.isSelected()==false) {ap.setJardin(0);}
					ap.setSurfaceParEtage(Float.parseFloat(tfsurfacemaison.getText()));
					
					ac.modifierBien(ap, Integer.parseInt(tfreference.getText()));
					affiche();
				}
			}
		});
		btnupdate.setBounds(200, 772, 85, 21);
		frame.getContentPane().add(btnupdate);
		
		JButton ButtonBienlouer = new JButton("Afficher Bien loué");
		ButtonBienlouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// lien vers classe BienLouer
				BienLouerVue windowBienLouerVue = new BienLouerVue();
				windowBienLouerVue.frameBienLouerVue.setLocationRelativeTo(null);
				windowBienLouerVue.frameBienLouerVue.setTitle("Bien loué");
				windowBienLouerVue.frameBienLouerVue.setSize(800,400);
				windowBienLouerVue.frameBienLouerVue.setVisible(true);
				
						}
		});
		ButtonBienlouer.setBounds(328, 72, 159, 21);
		frame.getContentPane().add(ButtonBienlouer);
		
		JButton btnAfficherBienNon = new JButton("Afficher Bien Non loué");
		btnAfficherBienNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// lien vers classe Bien non Louer
				BienNonLouerVue windowBienNonLouerVue = new BienNonLouerVue();
				windowBienNonLouerVue.frameBienNonLouerVue.setLocationRelativeTo(null);
				windowBienNonLouerVue.frameBienNonLouerVue.setTitle("Bien Non loué");
				windowBienNonLouerVue.frameBienNonLouerVue.setSize(800,400);
				windowBienNonLouerVue.frameBienNonLouerVue.setVisible(true);
				
			}
			
		});
		btnAfficherBienNon.setBounds(497, 72, 159, 21);
		frame.getContentPane().add(btnAfficherBienNon);
		
		JButton btnAffichersurf = new JButton("Afficher Bien Par Surface");
		btnAffichersurf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// lien vers classe Bien par surface
				SurfaceView  windowbienparsurfacevue =new SurfaceView();
				windowbienparsurfacevue.frameVueSurface.setLocationRelativeTo(null);
				windowbienparsurfacevue.frameVueSurface.setTitle("Bien Par Surface");
				windowbienparsurfacevue.frameVueSurface.setSize(800,400);
				windowbienparsurfacevue.frameVueSurface.setVisible(true);
				
				
			}
		});
		btnAffichersurf.setBounds(666, 72, 159, 21);
		frame.getContentPane().add(btnAffichersurf);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuApplication window=new MenuApplication();
				window.frame.setVisible(true);
				
				
			}
		});
		btnRetour.setBounds(1350, 780, 159, 21);
		frame.getContentPane().add(btnRetour);

	}

	void affiche()
    {	 /* Affichage tout les  biens */
	String columns[] ={
			"TYPE","Reference", "Adresse", "Tarif", "Surface Total", "En_location", "Date Debut", "Meuble", "Balcon", "Nbr Chambre", "NumEtage", "SurfaceAppart", "SurfaceGarage", "NumEmplacement", "NbEtage", "Jardin", "SurfaceEtage"
		};
	String data[][] = new String[50][17];
	int x = 0;
	/*Bien*/
	/*BienCRUD ps= new BienCRUD();
    List<Bien> list = ps.afficherBien();
	for(Bien i:list){
	int Reference = i.getReference();
	String Adresse = i.getAdresse();
    Float tarif = i.getTarif_m();
    Float st = i.getSurface();
    int enl =i.getEn_location();
    Date ddb = (Date) i.getDate_debut_location();
    data[(int) x][0] = "BIEN";
	data[(int) x][1] = Reference + "";
	data[(int) x][2] = Adresse;
	data[(int) x][3] = tarif.toString();
	data[(int) x][4] = st.toString();
	data[(int) x][5] = enl+"";
	data[(int) x][6] = ddb.toString();
	x ++ ;
	}*/
	/*APPARTEMENT*/
	AppartementCRUD p= new AppartementCRUD();
    List<Appartement> lista = p.afficherAppartement();
	for(Appartement i:lista){
	int Reference = i.getReference();
	String Adresse = i.getAdresse();
    Float tarif = i.getTarif_m();
    Float st = i.getSurface();
    int enl =i.getEn_location();
    Date ddb = (Date) i.getDate_debut_location();
    int mbl = i.getMeuble();
    int balcon = i.getBalcon();
    int nbrchambre = i.getNbChambre();
    int numetage = i.getNumEtage();
    float surfaceappart = i.getSurfaceTotalAppart();
    data[(int) x][0] = "APPARTEMENT";
	data[(int) x][1] = Reference + "";
	data[(int) x][2] = Adresse;
	data[(int) x][3] = tarif.toString();
	data[(int) x][4] = st.toString();
	data[(int) x][5] = enl+"";
	data[(int) x][6] = ddb.toString();
	data[(int) x][7] = mbl+"";
	data[(int) x][8] = balcon+"";
	data[(int) x][9] = nbrchambre+"";
	data[(int) x][10] = numetage+"";
	data[(int) x][11] = surfaceappart+"";
	x ++ ;
	}
	/*GARAGE*/
	GarageCRUD pg= new GarageCRUD();
    List<Garage> listg = pg.afficherGarage();
	for(Garage i:listg){
	int Reference = i.getReference();
	String Adresse = i.getAdresse();
    Float tarif = i.getTarif_m();
    Float st = i.getSurface();
    int enl =i.getEn_location();
    Date ddb = (Date) i.getDate_debut_location();
    Float surfgarage = i.getSurfaceGarage();
    int numemplacement = i.getNumEmplacement();
    data[(int) x][0] = "GARAGE";
	data[(int) x][1] = Reference + "";
	data[(int) x][2] = Adresse;
	data[(int) x][3] = tarif.toString();
	data[(int) x][4] = st.toString();
	data[(int) x][5] = enl+"";
	data[(int) x][6] = ddb.toString();
	data[(int) x][12] = surfgarage+"";
	data[(int) x][13] = numemplacement+"";
	x ++ ;
	}
	/*MAISON*/
	MaisonCRUD pm= new MaisonCRUD();
    List<Maison> listm = pm.afficherMaison();
	for(Maison i:listm){
	int Reference = i.getReference();
	String Adresse = i.getAdresse();
    Float tarif = i.getTarif_m();
    Float st = i.getSurface();
    int enl =i.getEn_location();
    Date ddb = (Date) i.getDate_debut_location();
    int nbetage = i.getNbEtage();
    int jardin = i.getJardin();
    Float surfaceetage = i.getSurfaceParEtage();
    data[(int) x][0] = "MAISON";
	data[(int) x][1] = Reference + "";
	data[(int) x][2] = Adresse;
	data[(int) x][3] = tarif.toString();
	data[(int) x][4] = st.toString();
	data[(int) x][5] = enl+"";
	data[(int) x][6] = ddb.toString();
	data[(int) x][14] = nbetage+"";
	data[(int) x][15] = jardin+"";
	data[(int) x][16] = surfaceetage+"";
	x ++ ;
	}
	
	DefaultTableModel modelB = new DefaultTableModel(data, columns);
	tablem = new JTable(modelB);
	tablem.disable();
	tablem.setShowGrid(true);
	tablem.setShowVerticalLines(true);
	JScrollPane scrollPane1 = new JScrollPane(tablem);
	scrollPane1.setBounds(328, 103, 1212, 662);
	frame.getContentPane().add(scrollPane1);
}
}
