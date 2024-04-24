package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.Persona;

public class ServerImpl implements InterfazDeServer {
	
	public ServerImpl() throws RemoteException {
		crearBD();
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	private Persona persona1 = new Persona("Fernanda", 38);
	private Persona persona2 = new Persona("Fernando", 30);
	
	private ArrayList<Persona> BD_personas = new ArrayList<>();
	
	public void crearBD() {
		BD_personas.add(persona1);
		BD_personas.add(persona2);
	}
	
	@Override
	public ArrayList<Persona> getPersona() throws RemoteException {
		return BD_personas;
	}
	
	@Override
	public void Persona(String nombre, int edad) throws RemoteException{
		
	} 
}