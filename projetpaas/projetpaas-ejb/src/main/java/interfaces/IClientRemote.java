package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Clients;

@Remote
public interface IClientRemote {
	List<Clients> GetAll();
	public void Delete(int idClient);
	public void Create(Clients p);
	public void Update(Clients p,int id);
	public Clients findById(int id);
	//okk
}
