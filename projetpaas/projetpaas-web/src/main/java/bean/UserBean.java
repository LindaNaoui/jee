package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.User;
import services.UserService;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String email; 
	private String password ;
	private User u ; 
	@EJB
	UserService us ;
	public UserBean(){
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	} 
	

	public User GetCurrentUser() {
		return UserService.CurrentUser;
	}

	
	public String doLogin() {
		
		String navigateTo = "null";
		u = us.login(email, password);

		if (u != null ) {
			System.out.println(u.toString());
			
			
		navigateTo = "bloglist?faces-redirect=true";  }
		else {
			System.out.println("niggaa noooooo");
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	
	public String doLogout() {
		UserService.CurrentUser=null;

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }
		}

