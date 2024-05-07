package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import common.Airplane;
import common.InterfazDeServer;
import common.User;

public class Client {
	private InterfazDeServer server;
	
	public Client() {}
	
	public void startClient() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 4344);
		server = (InterfazDeServer) registry.lookup("serverDePersonas");
	}
	
	public String getDataFromApi() throws RemoteException{
		return server.getDataFromApi();
	}
	
	Object[] getUF() throws RemoteException {
		return server.getUF();
	}
	
	public ArrayList<User> getPeopleServer() throws RemoteException {
		return server.getPeople();
	}
	
	public ArrayList<Airplane> getAirplaneServer() throws RemoteException {
		return server.getAirplanes();
	}

}
