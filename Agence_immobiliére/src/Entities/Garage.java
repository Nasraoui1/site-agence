package Entities;

import java.util.Date;

public class Garage extends Bien {
	private float SurfaceGarage;
	private int NumEmplacement;
	public float getSurfaceGarage() {
		return SurfaceGarage;
	}
	public void setSurfaceGarage(float surfaceGarage) {
		SurfaceGarage = surfaceGarage;
	}
	public int getNumEmplacement() {
		return NumEmplacement;
	}
	public void setNumEmplacement(int numEmplacement) {
		NumEmplacement = numEmplacement;
	}
	public Garage(int reference, String adresse, float tarif_m, float surface, int en_location,
			Date date_debut_location,float surfaceGarage, int numEmplacement) {
		super(reference, adresse, tarif_m, surface, en_location, date_debut_location);
		SurfaceGarage = surfaceGarage;
		NumEmplacement = numEmplacement;
	}
	@Override
	public String toString() {
		return "Garage [SurfaceGarage=" + SurfaceGarage + ", NumEmplacement=" + NumEmplacement + "]";
	}
	public Garage(){}
	

}
