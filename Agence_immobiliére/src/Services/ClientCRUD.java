package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Client;
import Utils.MyConnection;

public class ClientCRUD {
	Connection cnx;

	public ClientCRUD() {
		cnx = MyConnection.getInstance().getCnx();
	}

	public void ajouterClient(Client client) {

		String req = "INSERT INTO client (Nom_client,Prenom_client,CIN_client,Numero_Telephone_client,Email_client) VALUES (?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = cnx.prepareStatement(req);
			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setInt(3, client.getCIN());
			pst.setLong(4, client.getNumero_Telephone());
			pst.setString(5, client.getEmail());
			pst.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void supprimerClient(int cin) {

		String req = "Delete FROM client WHERE CIN_client = ?";
		PreparedStatement pst;
		try {
			pst = cnx.prepareStatement(req);
			pst.setInt(1, cin);
			pst.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void modifierClient(int cin, Client client) {

		String req = "UPDATE client set nom_client=?,prenom_client=?,numero_telephone_client=?,email_client=?  WHERE cin_client = ?";
		PreparedStatement pst;
		try {
			pst = cnx.prepareStatement(req);
			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setLong(3, client.getNumero_Telephone());
			pst.setString(4, client.getEmail());
			pst.setInt(5, cin);
			pst.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public List<Client> afficherClient() {
		List<Client> myList = new ArrayList();
		try {
			Statement st = cnx.createStatement();
			String req = "SELECT * FROM client order by nom_client ";
			ResultSet rs;
			rs = st.executeQuery(req);
			while (rs.next()) {
				Client client = new Client();
				client.setCIN(rs.getInt(1));
				client.setNom(rs.getString(2));
				client.setPrenom(rs.getString(3));
				client.setNumero_Telephone(rs.getLong(4));
				client.setEmail(rs.getNString(5));
				myList.add(client);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return myList;
	}

	public Client getClient(String nom,String prenom) {
		Client client = new Client();
		try {
			Statement st = cnx.createStatement();
			String req = "SELECT * FROM client WHERE nom_client ='" + nom + "'AND prenom_client='" + prenom + "' ";
			ResultSet rs;
			rs = st.executeQuery(req);
			while (rs.next()) {
				client.setCIN(rs.getInt(1));
				client.setNom(rs.getString(2));
				client.setPrenom(rs.getString(3));
				client.setNumero_Telephone(rs.getLong(4));
				client.setEmail(rs.getNString(5));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return client;
	}
	public Client getClientByCIN(long cin) {
		Client client = new Client();
		try {
			Statement st = cnx.createStatement();
			String req = "SELECT * FROM client WHERE CIN_client ='" + cin + "' ";
			ResultSet rs;
			rs = st.executeQuery(req);
			while (rs.next()) {
				client.setCIN(rs.getInt(1));
				client.setNom(rs.getString(2));
				client.setPrenom(rs.getString(3));
				client.setNumero_Telephone(rs.getLong(4));
				client.setEmail(rs.getNString(5));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return client;
	}
}
