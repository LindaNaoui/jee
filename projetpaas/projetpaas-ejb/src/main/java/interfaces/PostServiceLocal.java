package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Post;

@Local
public interface PostServiceLocal {

	public List<Post> getAllPosts();
	public void DeletePost(int id);
	public Post GetPostById(int id);
	public Post getPostByTitle(String title);
	public void Addpost(Post p);
	
}
