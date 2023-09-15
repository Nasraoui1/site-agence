package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Maison;
import Utils.MyConnection;

public class MaisonCRUD {
	 Connection cnx;
		
	    public MaisonCRUD() {
			cnx = MyConnection.getInstance().getCnx();

	        
	    }
	public void ajouterMaison(Maison t) {

     String req = "INSERT INTO Maison (Reference,Adresse,Tarif_m,Surface,En_location,Date_debut_location,NbEtage,Jardin,SurfaceParEtage) VALUES (?,?,?,?,?,?,?,?,?)";
     PreparedStatement pst;
     try {
         pst = cnx.prepareStatement(req);
         pst.setInt(1, t.getReference());
         pst.setString(2, t.getAdresse());
         pst.setFloat(3, t.getTarif_m());
         pst.setFloat(4, t.getSurface());
         pst.setInt(5, t.getEn_location());
         pst.setDate(6,(java.sql.Date)t.getDate_debut_location());
         pst.setInt(7, t.getNbEtage());
         pst.setInt(8, t.getJardin());
         pst.setFloat(9, t.getSurfaceParEtage());

         pst.executeUpdate();
     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }

 }
	
	 public List<Maison> afficherMaison() {

	        List<Maison> myList = new ArrayList<Maison>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Maison";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Maison per = new Maison();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                per.setNbEtage(rs.getInt("NbEtage"));
	                per.setJardin(rs.getInt("Jardin"));
	                per.setSurfaceParEtage(rs.getFloat("SurfaceParEtage"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }

	  public void supprimerMaison(int Ref) {
	        String req = "DELETE FROM Maison WHERE Reference='" + Ref + "' ";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Maison supprimé avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }

	    public void modifierBien(Maison ts, int Reference) {
	        String req = "UPDATE Maison SET Adresse ='" + ts.getAdresse() + "',Tarif_m ='" + ts.getTarif_m()+ "',Surface ='" + ts.getSurface() + "',En_location ='" + ts.getEn_location() + "',Date_debut_location ='" + ts.getDate_debut_location()+"',NbEtage ='" + ts.getNbEtage() +"',Jardin ='" + ts.getJardin() +"',SurfaceParEtage ='" + ts.getSurfaceParEtage() +"' WHERE Reference = '" + Reference + "'";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Maison modifié avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }
	    public int getMaisont(String adresse) {
	    	int reference=0;
			try {
				Statement st = cnx.createStatement();
				String req = "SELECT * FROM maison WHERE Adresse ='" + adresse + "' ";
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
