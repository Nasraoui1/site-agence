package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Services.ClientCRUD;
import Entities.Client;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class Modifier_client {

	public JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNum;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modifier_client window = new Modifier_client();
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
	public Modifier_client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 776, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ClientCRUD client_modifier= new ClientCRUD();
		
		
		JComboBox comboBox = new JComboBox();
		List<Client> liste= new ArrayList();
		liste=client_modifier.afficherClient();
		for(int i=0 ; i<liste.size();i++) {
			
			Object Item = liste.get(i).getNom()+" "+liste.get(i).getPrenom();
			comboBox.addItem(Item);
		}
		
		
		
		comboBox.setBounds(240, 115, 333, 21);
		frame.getContentPane().add(comboBox);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(335, 172, 173, 19);
		frame.getContentPane().add(txtNom);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblNewLabel.setBounds(101, 178, 83, 13);
		frame.getContentPane().add(lblNewLabel);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(335, 214, 173, 19);
		frame.getContentPane().add(txtPrenom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblPrenom.setBounds(101, 220, 83, 13);
		frame.getContentPane().add(lblPrenom);
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(335, 251, 173, 19);
		frame.getContentPane().add(txtNum);
		
		JLabel lblNumroDeTlphone = new JLabel("Numéro de téléphone :");
		lblNumroDeTlphone.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblNumroDeTlphone.setBounds(101, 257, 196, 13);
		frame.getContentPane().add(lblNumroDeTlphone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(335, 290, 173, 19);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		lblEmail.setBounds(101, 296, 83, 13);
		frame.getContentPane().add(lblEmail);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_prenom=comboBox.getSelectedItem().toString();
				int pos=nom_prenom.indexOf(" ");
				
				String nom=nom_prenom.substring(0,pos);
				String prenom=nom_prenom.substring(pos+1);
				
				
				Client client_by_name= client_modifier.getClient(nom,prenom);
				Client client=new Client(txtNom.getText(),txtPrenom.getText(),Long.parseLong(txtNum.getText()),txtEmail.getText());
				client_modifier.modifierClient(client_by_name.getCIN(),client);
				Clients window=new Clients();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 18));
		btnNewButton.setBounds(335, 449, 179, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier Client");
		lblNewLabel_1.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 28));
		lblNewLabel_1.setBounds(292, 47, 293, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clients window=new Clients();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(633, 538, 104, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
