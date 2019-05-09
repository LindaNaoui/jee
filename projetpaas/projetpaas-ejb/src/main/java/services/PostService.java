package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entities.Post;

@Stateful
@LocalBean
public class PostService implements PostServiceRemote,PostServiceLocal {

	
	@Override
	public List<Post> getAllPosts() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/PostApi/");
		Response reponse = target.request().get();
		String result = reponse.readEntity(String.class);
		Gson j = new Gson();
		List<Post>  posts=j.fromJson(result, new TypeToken<List<Post>>(){}.getType());
	
	
       return posts;
		
	}

	@Override
	public void DeletePost(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/PostApi/"+id);
		WebTarget hello = target.path("");
		Response r =(Response)hello.request().delete();
		
		
		
		
	}

	@Override
	public Post GetPostById(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:21514/api/PostApi/"+id);
		Response reponse = target.request().get();
		String result = reponse.readEntity(String.class);
		Gson j = new Gson();
		Post  posts=j.fromJson(result, new TypeToken<Post>(){}.getType());
	
	
		 reponse.close();      
       return posts;
		
	}

	@Override
	public Post getPostByTitle(String title) {
		// TODO Auto-generated method stub
		Post p = new Post();
		p.setTitle(title);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/searchpost");
		WebTarget hello =target.path("");
		Response response=target.request().post(Entity.json(p));
		System.out.println("LoginVM="+p.toString());

			Gson g = new Gson();
		
		String result=response.readEntity(String.class);
		Post pos = g.fromJson(result, new TypeToken<Post>(){}.getType());
		return pos ;
		
	}

	@Override
	public void Addpost(Post p1)  {
		// TODO Auto-generated method stub

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:3857/api/PostAdd");
		Response response=target.request().post(Entity.json(p1));
		
		String result=response.readEntity(String.class);
		System.out.println(result+"hhhhhhhh");

		




	}
	
	

	
	
	
}
