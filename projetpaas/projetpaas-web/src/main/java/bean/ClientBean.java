package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;


import services.ClientService;

@SessionScoped
@ManagedBean(name="clientbean")
public class ClientBean {

	 private int Clientid;
//bean
	    private String Nom ;
	    private String Prenom ;
	    private String Email ;
	    private  String PhoneNumber;
		private List<entities.Clients> Clients;

	    
		private static final long serialVersionUID = 1L;

		@EJB
		private ClientService E;
		
		
		
		public List<entities.Clients>getClientss() {
			Clients = E.GetAll();
			return Clients;
			}
		
		
		public String supprimer(entities.Clients e){
			E.Delete(e);
			return "/Event?faces-redirect=true";
			
			
		}
		
		public String addEvent()  {
			E.Create(new entities.Clients(Nom, Prenom,
			 PhoneNumber,
			 Email
			 ));
			
			return "Event.jsf";

		}
		
	public String Modifier(entities.Clients e) throws IOException{
			
			this.setClientid(e.getClientid());
			this.setNom(e.getNom());
			this.setPrenom(e.getPrenom());
			this.setPhoneNumber(e.getPhoneNumber());
			this.setEmail(e.getEmail());
			
			
			return "Edit.jsf";
			
			
		}
		
		
	public String MAJEvent(int id){
		 entities.Clients p = E.findById(id);
		 
		 	p.setClientid(Clientid);
			p.setNom(Nom);
			p.setPrenom(Prenom);
			p.setEmail(Email);
			p.setPhoneNumber(PhoneNumber);

		E.Update(p,id);
		 
		 return "Event.jsf";
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

		public List<entities.Clients> getClients() {
			return Clients;
		}

		public void setClients(List<entities.Clients> clients) {
			Clients = clients;
		}

		public ClientService getE() {
			return E;
		}

		public void setE(ClientService e) {
			E = e;
		}
		
		
		
}
