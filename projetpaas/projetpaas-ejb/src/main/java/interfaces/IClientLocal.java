package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Clients;

@Local
public interface IClientLocal {

	List<Clients> GetAll();
	public void Delete(int ClientId);
	public void Create(Clients p);
	public void Update(Clients p,int id);
	public Clients findById(int id);
	//kk
}
