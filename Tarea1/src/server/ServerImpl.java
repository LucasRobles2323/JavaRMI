package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;


import common.Airplane;
import common.InterfazDeServer;
import common.User;

public class ServerImpl implements InterfazDeServer {
	
	public ServerImpl() throws RemoteException {
		startBD();
		UnicastRemoteObject.exportObject(this, 0);
	}

	
	private ArrayList<User> peopleBD_copia = new ArrayList<>();
	private ArrayList<Airplane> airplanesBD_copia = new ArrayList<>();
	
	public void startBD() {
	    Connection connection = null;
	    Statement query = null;
	    ResultSet results = null;
	    
	    try {
	    	String url = "jdbc:mysql://localhost:3306/aeroline";
			String username = "root";
			String password_BD = "";
			//PreparedStatement test = null;
			
			
			connection = DriverManager.getConnection(url, username, password_BD);
	    	
	    	//TODO Metodos con la BD
			query = connection.createStatement();
			String sqlUser = "SELECT * FROM user";
			String sqlAirplane = "SELECT * FROM airplane";
			//INSERT para agregar datos a la BD, PreparedStatement
			
			// Guardar Usuarios
			results = query.executeQuery(sqlUser);
			while (results.next()) {
				// int
				int id = results.getInt("ID_User");
				int edad = results.getInt("Age");
				// string
				String nombre = results.getString("Name");
				String email = results.getString("Email");
				
				User newUser = new User(id, nombre, edad, email);
				peopleBD_copia.add(newUser);
			}
			
			// Guardar Usuarios
			results = query.executeQuery(sqlAirplane);
			while (results.next()) {
				// int
				int id = results.getInt("ID_Airplane");
				int allSeats = results.getInt("Airplane_Seats");
				int freeSeats = results.getInt("Free_Seats");
				
				// string
				String nombre = results.getString("Name_Pilot");
				String phone = results.getString("Phone_Pilot");
				String destination = results.getString("Destination");
				String origin = results.getString("Origin");
				
				// Timestamp
				Timestamp takeoff = results.getTimestamp("Takeoff_hr");
				Timestamp arrive = results.getTimestamp("Arrive_hr");
				
				Airplane newAirplane = new Airplane(id, nombre,phone, allSeats, 
						 freeSeats, takeoff, arrive, destination, origin);
				
				airplanesBD_copia.add(newAirplane);
			}
			
			System.out.println("Conexion exitosa");
			connection.close();
	    }catch(SQLException e){
	    	e.printStackTrace();
	    	System.out.println("No se pudo conectar a la Base de Datos");
	    }
	}
	
	@Override
	public ArrayList<User> getPeople() throws RemoteException {
		return peopleBD_copia;
	}
	
	@Override
	public ArrayList<Airplane> getAirplanes() throws RemoteException {
		return airplanesBD_copia;
	}

	@Override
	public Object getUF() throws RemoteException{
		return null;
	}

	@Override
	public String getBD_SQL() throws RemoteException{
		return null;
	}
}