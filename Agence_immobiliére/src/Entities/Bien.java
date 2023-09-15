package Entities;

import java.util.Date;

public class Bien {
	private int Reference ; 
	private String Adresse;
	private float Tarif_m;
	private float Surface;
	// 0 pour dire False(n'est pas en_location), 1 pour dire True (est en location)
	private int En_location;
	private Date Date_debut_location;
	
	
	public Bien(){
		
	}
	public Bien(int reference, String adresse, float tarif_m, float surface, int en_location,
			Date date_debut_location) {
		Reference = reference;
		Adresse = adresse;
		Tarif_m = tarif_m;
		Surface = surface;
		En_location = en_location;
		Date_debut_location = date_debut_location;
	}
	public int getReference() {
		return Reference;
	}
	public void setReference(int reference) {
		Reference = reference;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public float getTarif_m() {
		return Tarif_m;
	}
	public void setTarif_m(float tarif_m) {
		Tarif_m = tarif_m;
	}
	public float getSurface() {
		return Surface;
	}
	public void setSurface(float surface) {
		Surface = surface;
	}
	public int getEn_location() {
		return En_location;
	}
	public void setEn_location(int en_location) {
		En_location = en_location;
	}
	public Date getDate_debut_location() {
		return Date_debut_location;
	}
	public void setDate_debut_location(Date date_debut_location) {
		Date_debut_location = date_debut_location;
	}
	
	@Override
	public String toString() {
		return "Bien [Reference=" + Reference + ", Adresse=" + Adresse + ", Tarif_m=" + Tarif_m + ", Surface=" + Surface
				+ ", En_location=" + En_location + ", Date_debut_location=" + Date_debut_location + "]";
	}
	
	

}
