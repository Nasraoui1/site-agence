package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Appartement;
import Entities.Client;
import Utils.MyConnection;

public class AppartementCRUD {
	 Connection cnx;

	 
	    public AppartementCRUD() {
	        cnx = MyConnection.getInstance().getCnx();
	    }
	    
	public void ajouterAppartement(Appartement t) {

     String req = "INSERT INTO Appartement (Reference,Adresse,Tarif_m,Surface,En_location,Date_debut_location,Meuble,Balcon,NbChambre,NumEtage,SurfaceTotalAppart) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pst;
     try {
         pst = cnx.prepareStatement(req);
         pst.setInt(1, t.getReference());
         pst.setString(2, t.getAdresse());
         pst.setFloat(3, t.getTarif_m());
         pst.setFloat(4, t.getSurface());
         pst.setInt(5, t.getEn_location());
         pst.setDate(6,(java.sql.Date)t.getDate_debut_location());
         pst.setInt(7, t.getMeuble());
         pst.setInt(8, t.getBalcon());
         pst.setInt(9, t.getNbChambre());
         pst.setInt(10, t.getNumEtage());
         pst.setFloat(11, t.getSurfaceTotalAppart());
         
         pst.executeUpdate();
     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }

 }
	
	 public List<Appartement> afficherAppartement() {

	        List<Appartement> myList = new ArrayList<Appartement>();

	        try {
	            Statement st = cnx.createStatement();
	            String req = "SELECT * FROM Appartement";
	            ResultSet rs;
	            rs = st.executeQuery(req);
	            while (rs.next()) {

	            	Appartement per = new Appartement();
	                per.setReference(rs.getInt("Reference"));
	                per.setAdresse(rs.getString("Adresse"));
	                per.setTarif_m(rs.getFloat("Tarif_m"));
	                per.setSurface(rs.getFloat("Surface"));
	                per.setEn_location(rs.getInt("En_location"));
	                per.setDate_debut_location(rs.getDate("Date_debut_location"));
	                per.setMeuble(rs.getInt("Meuble"));
	                per.setBalcon(rs.getInt("Balcon"));
	                per.setNbChambre(rs.getInt("NbChambre"));
	                per.setNumEtage(rs.getInt("NumEtage"));
	                per.setSurfaceTotalAppart(rs.getFloat("SurfaceTotalAppart"));
	                myList.add(per);
	            }
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            //   return null;
	        }
	        return myList;
	    }

	  public void supprimerAppartement(int Ref) {
	        String req = "DELETE FROM Appartement WHERE Reference='" + Ref + "' ";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Appartement supprimé avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }

	    public void modifierBien(Appartement ts, int Reference) {
	        String req = "UPDATE Appartement SET Adresse ='" + ts.getAdresse() + "',Tarif_m ='" + ts.getTarif_m()+ "',Surface ='" + ts.getSurface() + "',En_location ='" + ts.getEn_location() + "',Date_debut_location ='" + ts.getDate_debut_location()+"',Meuble ='" + ts.getMeuble()+"',Balcon ='" + ts.getBalcon()+"',NbChambre ='" + ts.getNbChambre()+"',NumEtage ='" + ts.getNumEtage()+"',SurfaceTotalAppart ='" + ts.getSurfaceTotalAppart()+"' WHERE Reference = '" + Reference + "'";
	        PreparedStatement pst;

	        try {
	            pst = cnx.prepareStatement(req);
	            pst.executeUpdate();
	            System.out.println("Appartement modifié avec succés");

	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	        }

	    }
	    public int getApparatement(String adresse) {
	    	int reference=0;
			try {
				Statement st = cnx.createStatement();
				String req = "SELECT * FROM appartement WHERE Adresse ='" + adresse + "' ";
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
