package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Client;
import Entities.Location;
import Utils.MyConnection;

public class LocationCRUD {
	Connection cnx;

	public LocationCRUD() {
		cnx = MyConnection.getInstance().getCnx();
	}
	
	public void ajouterLocation(Location location) {

		String req = "INSERT INTO location (reference_bien,CIN_client) VALUES (?,?)";
		PreparedStatement pst;
		try {
			pst = cnx.prepareStatement(req);
		
			pst.setInt(1, location.getReference_Bien());
			pst.setLong(2, location.getCIN_Client());
			
			pst.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public void supprimerLocation(int id) {

		String req = "Delete FROM location WHERE Id_location = ?";
		PreparedStatement pst;
		try {
			pst = cnx.prepareStatement(req);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	public List<Location> afficherLocation() {
		List<Location> myList = new ArrayList();
		try {
			Statement st = cnx.createStatement();
			String req = "SELECT * FROM location ";
			ResultSet rs;
			rs = st.executeQuery(req);
			while (rs.next()) {
				Location location = new Location();
				location.setId_Location(rs.getInt(1));
				location.setReference_Bien(rs.getInt(2));
				location.setCIN_Client(rs.getLong(3));
				myList.add(location);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return myList;
	}
	public Location getLocation(long cin) {
		Location location = new Location();
		try {
			Statement st = cnx.createStatement();
			String req = "SELECT * FROM location WHERE CIN_client ='" + cin + "' ";
			ResultSet rs;
			rs = st.executeQuery(req);
			while (rs.next()) {
				
				location.setId_Location(rs.getInt(1));
				location.setReference_Bien(rs.getInt(2));
				location.setCIN_Client(rs.getLong(3));
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return location;
	}

}
