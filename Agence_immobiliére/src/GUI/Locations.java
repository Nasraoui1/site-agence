package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entities.Bien;
import Entities.Client;
import Entities.Location;
import Services.BienCRUD;
import Services.ClientCRUD;
import Services.LocationCRUD;

public class Locations {

	public JFrame frame;
	private JTable table;
	public DefaultTableModel model;
	private JLabel lblNewLabel;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnSupprimerLocation;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locations window = new Locations();
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
	public Locations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 985, 749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LocationCRUD locationcrud= new LocationCRUD();
		ClientCRUD clientcrud= new ClientCRUD();
		BienCRUD biencrud= new BienCRUD();
		List<Location> liste=new ArrayList();
		liste= locationcrud.afficherLocation();
		model = new DefaultTableModel();
		Object[] column = {"Id_location","Nom client","Adresse Bien","Tarif"};
		model.setColumnIdentifiers(column);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 88, 807, 507);
		frame.getContentPane().add(scrollPane);
		Object row[]=new Object[4];
		for(int i=0;i<liste.size();i++)
		{Client client=clientcrud.getClientByCIN(liste.get(i).getCIN_Client());
		Bien bien=biencrud.geBienByReference(liste.get(i).getReference_Bien());
			row[0]=liste.get(i).getId_Location();
			row[1]=client.getNom();
			row[2]=bien.getAdresse();
			row[3]=bien.getTarif_m();
			
			model.addRow(row);
		}
		table = new JTable();
		table.setModel(model);
		table.disable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Liste des locations ");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 45));
		lblNewLabel.setBounds(263, 10, 500, 68);
		frame.getContentPane().add(lblNewLabel);
		
		btnAjouter = new JButton("Ajouter location");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_Location window_ajouter =new Ajouter_Location();
				window_ajouter.frame.setVisible(true);
			}
		});
		btnAjouter.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnAjouter.setBounds(58, 637, 230, 35);
		frame.getContentPane().add(btnAjouter);
		
		btnSupprimerLocation = new JButton("Supprimer location");
		btnSupprimerLocation.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnSupprimerLocation.setBounds(580, 637, 230, 35);
		frame.getContentPane().add(btnSupprimerLocation);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuApplication window=new MenuApplication();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(847, 668, 102, 21);
		frame.getContentPane().add(btnNewButton);
		
	}

}
