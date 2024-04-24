package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.Persona;

public class Client {
	private InterfazDeServer server;
	
	public Client() {}
	
	public void startClient() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 4344);
		server = (InterfazDeServer) registry.lookup("serverDePersonas");
	}
	
	public ArrayList<Persona> getPersonas() throws RemoteException {
		return server.getPersona();
	}
	
	public void setPersona(Persona person) throws RemoteException, NotBoundException {
		server.setPersona(person);
	}

}
