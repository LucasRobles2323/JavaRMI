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
	
	public Client() throws RemoteException, NotBoundException {
		startClient();
	}
	
	public void startClient() throws RemoteException, NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4344);
            server = (InterfazDeServer) registry.lookup("serverAerolinea");
            System.out.println("Conectado al servidor principal.");
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Error al conectar con el servidor principal: " + e.getMessage());
            System.out.println("Intentando conectar con el servidor de respaldo...");
            cambiarAServerRespaldo();
        }
    }

    public void cambiarAServerRespaldo() throws RemoteException, NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4345);
            server = (InterfazDeServer) registry.lookup("serverAerolineaRespaldo");
            System.out.println("Conectado al servidor de respaldo.");
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Error al conectar con el servidor de respaldo: " + e.getMessage());
            throw e;
        }
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
	
	public void insertUser(User user) {
        try {
            server.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User selectUser(int id) {
        try {
            return server.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user) {
        try {
            server.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            server.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}