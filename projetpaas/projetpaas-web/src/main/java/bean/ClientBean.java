package bean;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xhtmlrenderer.pdf.ITextRenderer;

import services.ClientService;

@SessionScoped
@ManagedBean(name="clientbean")
public class ClientBean {

	 private int Clientid;
//bea
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
		
		
		
		public String supprimer(int id){
			E.Delete(id);
			return "/essai?faces-redirect=true";
			
			
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
	
	public void createPDF(){
		
		
		 //report.setEventId(clientid);
		   
			FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext externalContext = facesContext.getExternalContext();
		    HttpSession session = (HttpSession) externalContext.getSession(true);
		    String url = "http://localhost:18080/projetpaas-web/reports.jsf;JSESSIONID="+session.getId()+"pdf=true";
		    //String url = "http://localhost:18080/projetpaas-web/reports.xhtml";
		    try {
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocument(new URL(url).toString());
		    renderer.layout();
		    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		    response.reset();
		    response.setContentType("application/pdf");
		    response.setHeader("Content-Disposition","C://user/first.pdf");
		    OutputStream browserStream = response.getOutputStream();
		    renderer.createPDF(browserStream);
		    browserStream.close();
		    session.invalidate();
		    } catch (Exception ex) {
		       ex.printStackTrace();
		    }
		    facesContext.responseComplete();
		    
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
