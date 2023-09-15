package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import Services.ClientCRUD;
import Entities.Client;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Clients {

	public JFrame frame;
	private JTable table;
	public DefaultTableModel model;
	private JLabel lblNewLabel;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients window = new Clients();
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
	public Clients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 905, 762);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ClientCRUD clientcrud= new ClientCRUD();
		List<Client> liste=new ArrayList();
		liste= clientcrud.afficherClient();
		model = new DefaultTableModel();
		Object[] column = {"Nom","Prenom","CIN","Numéro de telephone","Email"};
		model.setColumnIdentifiers(column);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 88, 807, 507);
		frame.getContentPane().add(scrollPane);
		Object row[]=new Object[5];
		for(int i=0;i<liste.size();i++)
		{
			row[0]=liste.get(i).getNom();
			row[1]=liste.get(i).getPrenom();
			row[2]=liste.get(i).getCIN();
			row[3]=liste.get(i).getNumero_Telephone();
			row[4]=liste.get(i).getEmail();
			model.addRow(row);
		}
		table = new JTable();
		table.setModel(model);
		table.disable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Liste des clients");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 45));
		lblNewLabel.setBounds(263, 10, 368, 68);
		frame.getContentPane().add(lblNewLabel);
		
		btnAjouter = new JButton("Ajouter Client");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_client window_ajouter =new Ajouter_client();
				window_ajouter.frame.setVisible(true);
			}
		});
		btnAjouter.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnAjouter.setBounds(58, 637, 230, 35);
		frame.getContentPane().add(btnAjouter);
		
		btnModifier = new JButton("Modifier Client");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modifier_client window_modifier =new Modifier_client();
				window_modifier.frame.setVisible(true);
			}
		});
		btnModifier.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnModifier.setBounds(345, 637, 230, 35);
		frame.getContentPane().add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer Client");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_client window_supprimer =new Delete_client();
				window_supprimer.frame.setVisible(true);
			}
			
		});
		btnSupprimer.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		btnSupprimer.setBounds(617, 637, 220, 35);
		frame.getContentPane().add(btnSupprimer);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuApplication window=new MenuApplication();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(765, 694, 116, 21);
		frame.getContentPane().add(btnNewButton);
	}
}
