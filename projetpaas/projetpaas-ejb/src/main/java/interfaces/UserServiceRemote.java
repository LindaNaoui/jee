package interfaces;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface UserServiceRemote {

	
	public User login(String mail , String password);
	public void getUserById();
}
