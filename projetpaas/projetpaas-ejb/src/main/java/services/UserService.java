package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.User;


@Stateful
@LocalBean
public class UserService implements UserServiceLocal,UserServiceRemote {
	
	
	public static User CurrentUser= new User();

	@Override
	public User login(String mail,String password){
		entity.User ut = new User();
		ut.setEmail(mail);
		ut.setPass(password);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/Login");
		WebTarget hello =target.path("");
		Response response=target.request().post(Entity.json(ut));
		System.out.println("LoginVM="+ut.toString());

			Gson g = new Gson();
		
		String result=response.readEntity(String.class);
		User u = g.fromJson(result, new TypeToken<User>(){}.getType());
		CurrentUser=u ;
		return u ;
	}
	@Override
	public void getUserById(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/AccountApi/15");
		WebTarget hello =target.path("");
		Response response =hello.request().get();
		Gson g = new Gson();
		
		String result=response.readEntity(String.class);
		User u = g.fromJson(result,  new TypeToken<User>(){}.getType());
		System.out.println(u.toString());

		response.close();
	}
	
	

}
