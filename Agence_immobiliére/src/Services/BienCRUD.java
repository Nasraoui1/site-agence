package Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Bien;
import Entities.Client;
import Utils.MyConnection;

public class BienCRUD {
	 Connection cnx;

	    public BienCRUD() {
	        cnx = MyConnection.getInstance().getCnx();
	    }
	public void ajouterBien(Bien t) {

        String req = "INSERT INTO Bien (Reference,Adresse,Tarif_m,Surface,En_location,Date_debut_location) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getReference());
            pst.setString(2, t.getAdresse());
            pst.setFloat(3, t.getTarif_m());
            pst.setFloat(4, t.getSurface());
            pst.setInt(5, t.getEn_location());
            pst.setDate(6,(java.sql.Date)t.getDate_debut_location());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
	
	 public List<Bien> afficherBien() {

	        List<Bien> myList = new ArrayList<Bien>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Bien";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Bien per = new Bien();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }

	  public void supprimerBien(int Ref) {
	        String req = "DELETE FROM Bien WHERE Reference='" + Ref + "' ";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Bien supprimé avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }

	    public void modifierBien(Bien ts, int Reference) {
	        String req = "UPDATE Bien SET Adresse ='" + ts.getAdresse() + "',Tarif_m ='" + ts.getTarif_m()+ "',Surface ='" + ts.getSurface() + "',En_location ='" + ts.getEn_location() + "',Date_debut_location ='" + ts.getDate_debut_location()+"' WHERE Reference = '" + Reference + "'";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Bien modifié avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }
	    
	    public List<Bien> afficherBienSurface(float surface) {

	        List<Bien> myList = new ArrayList<Bien>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Bien WHERE Surface = '" + surface + "'";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Bien per = new Bien();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }
	    
	    public List<Bien> afficherBienloues() {

	        List<Bien> myList = new ArrayList<Bien>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Bien WHERE En_location = 1 ";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Bien per = new Bien();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }
	    
	    public List<Bien> afficherBiennonloues() {

	        List<Bien> myList = new ArrayList<Bien>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Bien WHERE En_location = 0 ";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Bien per = new Bien();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }
	    
	    public Bien geBienByReference(int reference) {
	    	Bien bien = new Bien();
	    	 List<Bien> myList = new ArrayList<Bien>();
			try {
				Statement st = cnx.createStatement();
				String req = "SELECT * FROM bien WHERE Reference ='" + reference + "' ";
				ResultSet rs;
				rs = st.executeQuery(req);
				while (rs.next()) {
					bien.setReference(rs.getInt("Reference"));
					bien.setAdresse(rs.getString("Adresse"));
					bien.setTarif_m(rs.getFloat("Tarif_m"));
					bien.setSurface(rs.getFloat("Surface"));
					bien.setEn_location(rs.getInt("En_location"));
					bien.setDate_debut_location(rs.getDate("Date_debut_location"));
					
				}
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
			return bien;
		}


}
