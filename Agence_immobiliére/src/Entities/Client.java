package Entities;

public class Client {

	
	private String Nom;
	private String Prenom;
	private int CIN;
	private long Numero_Telephone;
	private String Email;
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	
	public long getNumero_Telephone() {
		return Numero_Telephone;
	}
	public void setNumero_Telephone(long numero_Telephone) {
		Numero_Telephone = numero_Telephone;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public Client(String nom, String prenom, int cin, long numero_Telephone, String email) {
		Nom = nom;
		Prenom = prenom;
		CIN = cin;
		Numero_Telephone = numero_Telephone;
		Email = email;
	}
	public Client(String nom, String prenom, long numero_Telephone, String email) {
		Nom = nom;
		Prenom = prenom;
		Numero_Telephone = numero_Telephone;
		Email = email;
	}
	public Client() {
		Nom = "";
		Prenom = "";
		CIN = 0;
		Numero_Telephone =0;
		Email = "";
	}
	
	
	
}
