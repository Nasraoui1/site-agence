package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Garage;
import Utils.MyConnection;

public class GarageCRUD {
	 Connection cnx;
		

	    public GarageCRUD() {
	        cnx = MyConnection.getInstance().getCnx();
	    }
	public void ajouterGarage(Garage t) {

     String req = "INSERT INTO Garage (Reference,Adresse,Tarif_m,Surface,En_location,Date_debut_location,SurfaceGarage,NumEmplacement) VALUES (?,?,?,?,?,?,?,?)";
     PreparedStatement pst;
     try {
         pst = cnx.prepareStatement(req);
         pst.setInt(1, t.getReference());
         pst.setString(2, t.getAdresse());
         pst.setFloat(3, t.getTarif_m());
         pst.setFloat(4, t.getSurface());
         pst.setInt(5, t.getEn_location());
         pst.setDate(6,(java.sql.Date)t.getDate_debut_location());
         pst.setFloat(7, t.getSurfaceGarage());
         pst.setInt(8, t.getNumEmplacement());

         pst.executeUpdate();
     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }

 }
	
	 public List<Garage> afficherGarage() {

	        List<Garage> myList = new ArrayList<Garage>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Garage";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Garage per = new Garage();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                per.setSurfaceGarage(rs.getFloat("SurfaceGarage"));
	                per.setNumEmplacement(rs.getInt("NumEmplacement"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }

	  public void supprimerGarage(int Ref) {
	        String req = "DELETE FROM Garage WHERE Reference='" + Ref + "' ";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Garage supprimé avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }

	    public void modifierGarage(Garage ts, int Reference) {
	        String req = "UPDATE Garage SET Adresse ='" + ts.getAdresse() + "',Tarif_m ='" + ts.getTarif_m()+ "',Surface ='" + ts.getSurface() + "',En_location ='" + ts.getEn_location() + "',Date_debut_location ='" + ts.getDate_debut_location()+"',SurfaceGarage ='" + ts.getSurfaceGarage()+"',NumEmplacement ='" + ts.getNumEmplacement()+"' WHERE Reference = '" + Reference + "'";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Garage modifié avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }
	    public int getGarage(String adresse) {
	    	int reference=0;
			try {
				Statement st = cnx.createStatement();
				String req = "SELECT * FROM garage WHERE Adresse ='" + adresse + "' ";
				ResultSet rs;
				rs = st.executeQuery(req);
				while (rs.next()) {
					reference=rs.getInt(1);
					
				}
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
			return reference;
		}

}
