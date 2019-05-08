package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Clients  {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int Clientid;
//hj
    private String Nom ;
    private String Prenom ;
    private String Email ;
    private  String PhoneNumber;
    
    
    
	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getClientid() {
		return Clientid;
	}
	public void setClientid(int clientid) {
		Clientid = clientid;
	}
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Clients(int clientid, String nom, String prenom, String email, String phoneNumber) {
		super();
		Clientid = clientid;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		PhoneNumber = phoneNumber;
	}
	
	public Clients( String nom, String prenom, String email, String phoneNumber) {
		super();
		Nom = nom;
		Prenom = prenom;
		Email = email;
		PhoneNumber = phoneNumber;
	}
	
	
}
