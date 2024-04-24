package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.User;

public class ServerImpl implements InterfazDeServer {
	
	public ServerImpl() throws RemoteException {
		instanceBD();
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	private User user1 = new User("Julio", 24);
	private User user2 = new User("Jazmin", 8);
	
	private ArrayList<User> people = new ArrayList<>();
	
	public void instanceBD() {
		people.add(user1);
		people.add(user2);
	}
	
	@Override
	public ArrayList<User> getPeople() throws RemoteException {
		return people;
	}
	
	@Override
	public void setPerson(User person) throws RemoteException{
		people.add( person );
	} 
}