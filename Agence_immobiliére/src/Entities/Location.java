package Entities;

public class Location {

	private int Id_Location;
	private int Reference_Bien;
	private long CIN_Client;
	public int getId_Location() {
		return Id_Location;
	}
	public void setId_Location(int id_Location) {
		Id_Location = id_Location;
	}
	public int getReference_Bien() {
		return Reference_Bien;
	}
	public void setReference_Bien(int reference_Bien) {
		Reference_Bien = reference_Bien;
	}
	public long getCIN_Client() {
		return CIN_Client;
	}
	public void setCIN_Client(long cin) {
		CIN_Client = cin;
	}
	public Location(int id_Location, int reference_Bien, long cin) {
		Id_Location = id_Location;
		Reference_Bien = reference_Bien;
		CIN_Client = cin;
	}
	public Location( int reference_Bien, long cin) {
		
		Reference_Bien = reference_Bien;
		CIN_Client = cin;
	}
	public Location() {
		Id_Location = 0;
		Reference_Bien = 0;
		CIN_Client = 0;
	}
	
	
}
