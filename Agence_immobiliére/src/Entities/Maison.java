package Entities;

import java.util.Date;

public class Maison extends Bien {
	private int NbEtage;
	//0 si Flase(la maison ne contient pas jardin) 1 si True(la maison contient jardin) 
	private int Jardin;
	private float SurfaceParEtage;
	public int getNbEtage() {
		return NbEtage;
	}
	public void setNbEtage(int nbEtage) {
		NbEtage = nbEtage;
	}
	public int getJardin() {
		return Jardin;
	}
	public void setJardin(int jardin) {
		Jardin = jardin;
	}
	public float getSurfaceParEtage() {
		return SurfaceParEtage;
	}
	public void setSurfaceParEtage(float surfaceParEtage) {
		SurfaceParEtage = surfaceParEtage;
	}
	public Maison(int reference, String adresse, float tarif_m, float surface, int en_location,
			Date date_debut_location,int nbEtage, int jardin, float surfaceParEtage) {
		super(reference, adresse, tarif_m, surface, en_location, date_debut_location);
		NbEtage = nbEtage;
		Jardin = jardin;
		SurfaceParEtage = surfaceParEtage;
	}
	public Maison(){
		
	}
	@Override
	public String toString() {
		return "Maison [NbEtage=" + NbEtage + ", Jardin=" + Jardin + ", SurfaceParEtage=" + SurfaceParEtage + "]";
	}
	
	

}
