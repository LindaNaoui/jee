package services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Clients;
import interfaces.IClientLocal;
import interfaces.IClientRemote;

@Stateful
@LocalBean
public class ClientService implements IClientRemote,IClientLocal {
		//ser
		
		EntityManager em ;
		

		
		@Override
		public List<Clients> GetAll() {
			List<Clients>  lasp = new ArrayList<Clients>();
	    	Client client = ClientBuilder.newClient();
	    	
	    	WebTarget web = client.target("http://localhost:3857/api/WebApiClient"); 
	    	
	    	Response response = web.request().get();
	    	
	    	String result = response.readEntity(String.class); 
	    	
	    	//System.out.println(result);
	    	JsonReader jsonReader = Json.createReader(new StringReader(result));
	    	JsonArray object =  jsonReader.readArray();
	    	
	    	 
	    	for (int i=0;i<object.size();i++)
	    	{
	    	 
	    		Clients m = new Clients();
	    	 //String dateString;
	    	 m.setNom(object.getJsonObject(i).get("Nom").toString()); 
	    	 m.setPrenom(object.getJsonObject(i).getString("Prenom")); 

	       	// m.setPrenom(object.getJsonObject(i).get("Prenom").toString()); 
	       	 m.setEmail(object.getJsonObject(i).get("Email").toString());
	       	 m.setPhoneNumber(object.getJsonObject(i).get("PhoneNumber").toString());
	       	// m.setProjectId(Integer.parseInt(object.getJsonObject(i).get("ProjectId").toString()));
	       	 m.setClientid(Integer.parseInt(object.getJsonObject(i).get("Clientid").toString()));
	    	
	    	
	    	 lasp.add(m);
	    	}
	    	

	return lasp;    	
		}

		
		@Override
		public void Create(Clients p) {
			
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:3857/api/Create");
			WebTarget hello =target.path("");
			
			Response response =hello.request().post(Entity.entity(p, MediaType.APPLICATION_JSON) );
			
			
			String result=response.readEntity(String.class);
			System.out.println(result);
			
			

			response.close();
			
		}
		
		
		

		    @Override
			public void Update(Clients p , int id) {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:3857/api/WebApiClient/Update?id="+id);
			WebTarget hello =target.path("");
			
			Response response =hello.request().put(Entity.entity(p, MediaType.APPLICATION_JSON) );
			
			String result=response.readEntity(String.class);
			System.out.println(result);

			response.close();
			
		}
		
		@Override
		public void Delete(Clients eve)
		{
			Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://localhost:4640/api/EventWebApi?id="+eve.getClientid()); 
			WebTarget hello = target.path("");     	
	    	Response res=(Response) hello.request().delete();
		}




		@Override
		public Clients findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void Delete(int ClientId) {
			// TODO Auto-generated method stub
			
		}







		

	}
