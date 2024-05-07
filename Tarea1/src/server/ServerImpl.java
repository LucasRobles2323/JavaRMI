package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
				int idPlane = results.getInt("ID_Airplane");
				// string
				String nombre = results.getString("Name");
				String email = results.getString("Email");
				
				User newUser = new User(id, nombre, edad, email, idPlane);
				peopleBD_copia.add(newUser);
			}
			
			// Guardar Usuarios
			results = query.executeQuery(sqlAirplane);
			while (results.next()) {
				// int
				int id = results.getInt("ID_Airplane");
				int allSeats = results.getInt("Seats");
				int passengers = results.getInt("Passengers");
				
				// string
				String nombre = results.getString("Name_Pilot");
				String phone = results.getString("Phone_Pilot");
				String destination = results.getString("Destination");
				String origin = results.getString("Origin");
				
				// Timestamp
				Timestamp takeoff = results.getTimestamp("Takeoff_hr");
				Timestamp arrive = results.getTimestamp("Arrive_hr");
				
				Airplane newAirplane = new Airplane(id, nombre,phone, allSeats, passengers,
						 takeoff, arrive, destination, origin);
				
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
	public Object[] getUF() throws RemoteException{
		String output = null;
		 
		try {
            // URL de la API REST, el listado de APIs públicas está en: 
			// https://github.com/juanbrujo/listado-apis-publicas-en-chile
            URL apiUrl = new URL("https://mindicador.cl/api");

            // Abre la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configura la solicitud (método GET en este ejemplo)
            connection.setRequestMethod("GET");

            // Obtiene el código de respuesta
            int responseCode = connection.getResponseCode();

            // Procesa la respuesta si es exitosa
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lee la respuesta del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Cierra la conexión y muestra la respuesta
                in.close();
                output = response.toString();
            } else {
                System.out.println("Error al conectar a la API. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Como resultado tenemos un String output que contiene el JSON de la respuesta de la API
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			JsonNode jsonNode = objectMapper.readTree(output);
			String codigo = jsonNode.get("uf").get("codigo").asText(); 
			String nombre = jsonNode.get("uf").get("nombre").asText();
			String fecha = jsonNode.get("uf").get("fecha").asText();
			String unidad_medida = jsonNode.get("uf").get("unidad_medida").asText();
			double valor = jsonNode.get("uf").get("valor").asDouble();
			
			return new Object[] {codigo, nombre, fecha, unidad_medida, valor};
			
		}catch (JsonMappingException e) {
			e.printStackTrace();
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String getDataFromApi() throws RemoteException{
		String output = null;
		 
		try {
            // URL de la API REST, el listado de APIs públicas está en: 
			// https://github.com/juanbrujo/listado-apis-publicas-en-chile
            URL apiUrl = new URL("https://mindicador.cl/api");

            // Abre la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configura la solicitud (método GET en este ejemplo)
            connection.setRequestMethod("GET");

            // Obtiene el código de respuesta
            int responseCode = connection.getResponseCode();

            // Procesa la respuesta si es exitosa
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lee la respuesta del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Cierra la conexión y muestra la respuesta
                in.close();
                output = response.toString();
            } else {
                System.out.println("Error al conectar a la API. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		//Como resultado tenemos un String output que contiene el JSON de la respuesta de la API
		return output;
	}
}