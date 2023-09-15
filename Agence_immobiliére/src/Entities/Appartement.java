package Entities;

import java.util.Date;

public class Appartement extends Bien {
	//0 pour dire False (n'est pas meublé ) , 1 pour dire True (est meublé)
	private int Meuble;
	//0 pour dire False (n'y a pas de balcon ) , 1 pour dire True (y a  balcon)
	private int Balcon;
	private int NbChambre;
	private int NumEtage;
	private float SurfaceTotalAppart;
	public int getMeuble() {
		return Meuble;
	}
	public void setMeuble(int meuble) {
		Meuble = meuble;
	}
	public int getBalcon() {
		return Balcon;
	}
	public void setBalcon(int balcon) {
		Balcon = balcon;
	}
	public int getNbChambre() {
		return NbChambre;
	}
	public void setNbChambre(int nbChambre) {
		NbChambre = nbChambre;
	}
	public int getNumEtage() {
		return NumEtage;
	}
	public void setNumEtage(int numEtage) {
		NumEtage = numEtage;
	}
	public float getSurfaceTotalAppart() {
		return SurfaceTotalAppart;
	}
	public void setSurfaceTotalAppart(float surfaceTotalAppart) {
		SurfaceTotalAppart = surfaceTotalAppart;
	}
	public Appartement(int reference, String adresse, float tarif_m, float surface, int en_location,
			Date date_debut_location,int meuble, int balcon, int nbChambre, int numEtage, float surfaceTotalAppart) {
		super(reference, adresse, tarif_m, surface, en_location, date_debut_location);
		Meuble = meuble;
		Balcon = balcon;
		NbChambre = nbChambre;
		NumEtage = numEtage;
		SurfaceTotalAppart = surfaceTotalAppart;
	}
	public Appartement(){
		
	}
	@Override
	public String toString() {
		
		return "Appartement [Meuble=" + Meuble + ", Balcon=" + Balcon + ", NbChambre=" + NbChambre + ", NumEtage="
				+ NumEtage + ", SurfaceTotalAppart=" + SurfaceTotalAppart + "]";
	}
	
	
	

}
