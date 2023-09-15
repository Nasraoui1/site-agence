package Principale;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import Entities.Client;
import Entities.Location;
import GUI.Ajouter_client;
import GUI.MenuApplication;
import Services.ClientCRUD;
import Services.LocationCRUD;
import Utils.MyConnection;
public class MainClass extends JFrame{
 
	private static final long serialVersionUID = -4939544011287453046L; 
	public MainClass() {
		
	}
public static void main(String[] args){
	MainClass mywindow= new MainClass  ();
	MyConnection mc =  MyConnection.getInstance();
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
	//ClientCRUD clientcrud= new ClientCRUD();
	//LocationCRUD locationcrud= new LocationCRUD();
	//Client client1 = new Client("Fourat","Halaoau",87542125,99626324,"fourat.halaoua@esprit.tn");
	//Client client2 = new Client("Assyl","Kriaa",96581234,658432158,"assyl.kriaa@esprit.tn");
	/*clientcrud.ajouterClient(client2);
	clientcrud.ajouterClient(client1);*/
	//List<Client> liste = new ArrayList<>();
	//liste=clientcrud.afficherClient();
	//for(int i=0 ; i<liste.size();i++) {
	//System.out.println(liste.get(i).getCIN()+" "+liste.get(i).getNom()+" "+liste.get(i).getPrenom());
//	}
	/*Client client3 = new Client("Assyl","Kriaa",658432,"assyl22.kriaa@esprit.tn");
    clientcrud.modifierClient(96581234, client3);*/
	//clientcrud.supprimerClient(96581234);
	//Location location1 = new Location (125,12566,87542125);
	//Location location2 = new Location (127,12566,872125);
	//Location location3 = new Location (129,126,87542125);
	//locationcrud.ajouterLocation(location1);
	//locationcrud.ajouterLocation(location2);
	//locationcrud.ajouterLocation(location3);
	//locationcrud.supprimerLocation(125);
}

}