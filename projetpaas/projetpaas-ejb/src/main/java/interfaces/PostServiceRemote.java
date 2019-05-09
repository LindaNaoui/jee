package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entity.Post;

@Remote
public interface PostServiceRemote {
	public List<Post>getAllPosts();
	public void DeletePost(int id);
	public Post GetPostById(int id);
	public Post getPostByTitle(String title);
	public void Addpost(Post p );

}
