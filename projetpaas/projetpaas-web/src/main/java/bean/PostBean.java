package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


import entity.Post;
import services.PostService;
import services.UserService;

@ManagedBean(name="postBean")
@SessionScoped
public class PostBean implements Serializable {

	public PostBean(){
		
	}
		
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private String adDATE;

	public String getAdDATE() {
		return adDATE;
	}

	public void setAdDATE(String adDATE) {
		this.adDATE = adDATE;
	}
	

	
	private int i=0 ; 
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	private Date date ; 
	private String title;
	private String description ; 
	private String photo ; 
	private Post p ; 
	private List<Post> listPos;
	private List<Post> l=new ArrayList<>() ;
	private String windows ; 


	
	@EJB
	PostService ps;
	@ManagedProperty(value="#{userBean}")
	private UserBean ub;
	


	public UserBean getUb() {
		return ub;
	}

	public void setUb(UserBean ub) {
		this.ub = ub;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Post getP() {
		
		return p;
	}

	public void setP(Post p) {
		this.p = p;
	}
	
	public void reset(){
		String navto="null";
		l.clear();
		
	}
 	
	
	public String postdetail (int id){
		ps.GetPostById(id);
		return "searchresult?faces-redirect=true";
	}
	public String delete(int id){
		ps.DeletePost(id);
		return "bloglist?faces-redirect=true";
	}
	
	public void searchStringValueChanged(ValueChangeEvent vce)
	{
	    search((String) vce.getNewValue());
	}

	
	public String search(String title){
		String navigateTo = "null";

		p=ps.getPostByTitle(title);
		if(p!=null){
			return "searchresult?faces-redirect=true";


		}else {
			 FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Non trouvé"));
			 return navigateTo;
		}
		
		
		
	
	}
	
	
	public int hear(){
		return l.size();
	}
	
	public List<Post> notifi(){
		return l;
	}
	
	


	public String add(){
		String navto="null";
		Post p = new Post();
		
		p.setTitle(title);
		p.setDescription(description);
		p.setUser(ub.GetCurrentUser());
		p.setUserFK(ub.GetCurrentUser().getId());
		
		ps.Addpost(p);
		l.add(p);
		navto="bloglist?faces-redirect=true";
		return navto ; 
	}
	
		

public List<Post> posts(){
	listPos=ps.getAllPosts();
	return listPos;
	
}

}
