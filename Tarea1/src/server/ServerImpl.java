package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.User;

public class ServerImpl implements InterfazDeServer {
	
	public ServerImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
	}

	
	private ArrayList<User> peopleBD = new ArrayList<>();
	private ArrayList<User> airplanesBD = new ArrayList<>();
	
	public void startBD() {
	    Connection connection = null;
	    Statement query = null;
	    ResultSet results = null;
	    
	    try {
	    	//TODO Metodos con la BD
			query = connection.createStatement();
			String sql = "SELECT * FROM bd_acme";
	    }catch(SQLException e){
	    	e.printStackTrace();
	    	System.out.println("No se pudo conectar a la Base de Datos");
	    }
	}
	
	@Override
	public ArrayList<User> getPeople() throws RemoteException {
		return null;
	}

	@Override
	public Object getUF() throws RemoteException{
		return null;
	}

	@Override
	public String getBD_SQL() throws RemoteException{
		return null;
	}
	
	@Override
	public void setPerson(User person) throws RemoteException{
	} 
}