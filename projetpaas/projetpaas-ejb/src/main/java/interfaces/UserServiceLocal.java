package interfaces;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServiceLocal {

	public User login(String mail , String password);
	public void getUserById();
	
}
