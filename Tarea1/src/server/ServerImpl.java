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
	private boolean inUse;
	private int durationSleep = 10000; // milisegundos
	
	public ServerImpl() throws RemoteException, SQLException {
		startBD();
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	private ArrayList<User> peopleBD_copia = new ArrayList<>();
	private ArrayList<Airplane> airplanesBD_copia = new ArrayList<>();
	
	public void startBD() throws SQLException {
	    Connection connection = null;
	    Statement query = null;
	    ResultSet results = null;
	    
	    String url = "jdbc:mysql://localhost:3306/aeroline";
		String username = "root";
		String password_BD = "";
		
		connection = DriverManager.getConnection(url, username, password_BD);
	    
	    try {
			query = connection.createStatement();
			String sqlUser = "SELECT * FROM users";
			String sqlAirplane = "SELECT * FROM airplanes";
			
			/* GUARDAR USUARIOS LOCALMENTE */
			results = query.executeQuery(sqlUser);
			while (results.next()) {
				// int
				int id = results.getInt("ID_User");
				int edad = results.getInt("Age");
				Integer idPlane = results.getInt("ID_Airplane");
	            if (results.wasNull()) {
	                idPlane = 0;  // Set to 0 if the value is NULL
	            }
				// string
				String nombre = results.getString("Name");
				String email = results.getString("Email");
				
				User newUser = new User(id, nombre, edad, email, idPlane);
				peopleBD_copia.add(newUser);
			}
			
			/* GUARDAR AVIONES LOCALMENTE */
			results = query.executeQuery(sqlAirplane);
			while (results.next()) {
				// int
				int id = results.getInt("ID_Airplane");
				int allSeats = results.getInt("Seats");
				
				// string
				String nombre = results.getString("Name_Pilot");
				String phone = results.getString("Phone_Pilot");
				String destination = results.getString("Destination");
				String origin = results.getString("Origin");
				
				// Timestamp
				Timestamp takeoff = results.getTimestamp("Takeoff_hr");
				Timestamp arrive = results.getTimestamp("Arrive_hr");
				
				// double
	            double price = results.getDouble("Cost");
				
				Airplane newAirplane = new Airplane(id, nombre,phone, allSeats,
						 							takeoff, arrive, destination, origin, price);
				
				airplanesBD_copia.add(newAirplane);
			}
	    } finally {
	        if (results != null) {
	            results.close();
	        }
	        if (query != null) {
	            query.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
	}
	
	@Override
	public synchronized boolean requestMutex()  throws RemoteException {
		if(inUse) {
			return false;
		}
		else {
			inUse = true;
			return true;
		}
    }

	@Override
    public synchronized void releaseMutex()  throws RemoteException {
        inUse = false;
    }
	
	@Override
	public void insertUser(User userNew) throws RemoteException {
		// Solicitando Mutex para actuar.
		while(true) {
			if(requestMutex()) {
				System.out.println("¡Permiso Obtenido!");
				break;
			}
			try {
		    	Thread.sleep(2000);
		    }catch(InterruptedException e){
		    	e.printStackTrace();
		    }
			System.out.println("Esperando permiso para iniciar la sección critica..");
		}
		
	    Connection connection = null;
	    boolean userNoExists = false;
	    try {
	        String url = "jdbc:mysql://localhost:3306/aeroline";
	        String username = "root";
	        String password_BD = "";

	        connection = DriverManager.getConnection(url, username, password_BD);

	        /* INSERTAR USUARIOS EN SQL */
	        String sqlInsertUser = "INSERT INTO users (ID_User, Name, Age, Email, ID_Airplane) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement insertUserStatement = connection.prepareStatement(sqlInsertUser);

	        // Verificar si el usuario ya existe en la base de datos
	        String checkIfExistsQuery = "SELECT * FROM users WHERE ID_User = ?";
	        PreparedStatement checkIfExistsStatement = connection.prepareStatement(checkIfExistsQuery);
	        checkIfExistsStatement.setInt(1, userNew.getIdUser());
	        ResultSet resultSet = checkIfExistsStatement.executeQuery();

	        if (!resultSet.next()) {
	            // El usuario no existe en la base de datos
	            userNoExists = true;
	        }

	        if (userNoExists) {
	            // Establecer los valores de los parámetros de la consulta
	            insertUserStatement.setInt(1, userNew.getIdUser());
	            insertUserStatement.setString(2, userNew.getName());
	            insertUserStatement.setInt(3, userNew.getAge());
	            insertUserStatement.setString(4, userNew.getEmail());
	            if (userNew.getIdPlane() < 1) {
	                insertUserStatement.setNull(5, java.sql.Types.INTEGER);
	            } else {
	                insertUserStatement.setInt(5, userNew.getIdPlane());
	            }

	            // Ejecutar la consulta para insertar el usuario
	            insertUserStatement.executeUpdate();
	            peopleBD_copia.add(userNew);
	        }
	    } catch (SQLException e) {
	        if (userNoExists) {
	        	System.out.println("No se pudo insertar el usuario " + userNew.getName());
	        }
	        else {
	        	System.out.println("Ya existe en la BD el id Usuario: " + userNew.getIdUser());
	        }
	        e.printStackTrace();
	    }
	    
	    System.out.println("Iniciando inserción. Tiempo estimado, "+ durationSleep);
	    
	    try {
	    	Thread.sleep(durationSleep);
	    }catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    // Terminando seccion critica, liberando mutex.
	    releaseMutex();
	    if (userNoExists) {
	    	System.out.println("Insertado correctamente el usuario " + userNew.getName());
        }
        else {
        	System.out.println("Ya existe en la BD el id Usuario: " + userNew.getIdUser());
        }
	    
	    try {
	    	connection.close();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
	@Override
	public void updateUser(User updatedUser) throws RemoteException {
		// Solicitando Mutex para actuar.
		while(true) {
			if(requestMutex()) {
				System.out.println("¡Permiso Obtenido!");
				break;
			}
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Esperando permiso para iniciar la sección critica..");
		}

	    Connection connection = null;
	    int userCount = 1;
	    try {
	    	String url = "jdbc:mysql://localhost:3306/aeroline";
	        String username = "root";
	        String password_BD = "";

	        connection = DriverManager.getConnection(url, username, password_BD);
	            
	        // Verificar si el usuario existe
	        String checkUserExistsQuery = "SELECT COUNT(*) FROM users WHERE ID_User = ?";
	        PreparedStatement checkUserExistsStatement = connection.prepareStatement(checkUserExistsQuery);
	        checkUserExistsStatement.setInt(1, updatedUser.getIdUser());
	        ResultSet resultSet = checkUserExistsStatement.executeQuery();
	        resultSet.next();
	        userCount = resultSet.getInt(1);

	        if (userCount != 0) { // Existe
	        	String sqlUpdateUser = "UPDATE users SET Name = ?, Age = ?, Email = ?, ID_Airplane = ? WHERE ID_User = ?";
		        PreparedStatement updateUserStatement = connection.prepareStatement(sqlUpdateUser);
		        updateUserStatement.setString(1, updatedUser.getName());
		        updateUserStatement.setInt(2, updatedUser.getAge());
		        updateUserStatement.setString(3, updatedUser.getEmail());
		        if (updatedUser.getIdPlane() < 1) {
		            updateUserStatement.setNull(4, java.sql.Types.INTEGER);
		        } else {
		            updateUserStatement.setInt(4, updatedUser.getIdPlane());
		        }
		        updateUserStatement.setInt(5, updatedUser.getIdUser());

		        updateUserStatement.executeUpdate();

		        for (User user : peopleBD_copia) {
		            if (user.getIdUser() == updatedUser.getIdUser()) {
		                user.setName(updatedUser.getName());
		                user.setAge(updatedUser.getAge());
		                user.setEmail(updatedUser.getEmail());
		                user.setIdPlane(updatedUser.getIdPlane());
		                break;
		            }
		        }
	        }
	    }  catch (SQLException e) {
	    	if (userCount == 0) {
	    		System.out.println("No existe usuario " + updatedUser.getName());
	    	}
	    	else {
	    		System.out.println("No se pudo actualizar el usuario " + updatedUser.getName());
	    	}
	        e.printStackTrace();
	    }
	    
	    System.out.println("Iniciando actualización de usuario. Tiempo estimado, "+ durationSleep);
	    
	    try {
	    	Thread.sleep(durationSleep);
	    }catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    // Terminando seccion critica, liberando mutex.
	    releaseMutex();
	    if (userCount == 0) {
	    	System.out.println("No existe usuario " + updatedUser.getName());
    	}
	    else {
	    	System.out.println("Actualizado correctamente usuario " + updatedUser.getName());
	    }
	    
	    try {
	    	connection.close();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
	@Override
	public User selectUser(int idUser) throws RemoteException {
		// Solicitando Mutex para actuar.
		while(true) {
			if(requestMutex()) {
				System.out.println("¡Permiso Obtenido!");
				break;
			}
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Esperando permiso para iniciar la sección critica..");
		}
		
		Connection connection = null;
		User selectedUser = null;
		try {
			String url = "jdbc:mysql://localhost:3306/aeroline";
			String username = "root";
			String password_BD = "";

			connection = DriverManager.getConnection(url, username, password_BD);

			String sqlSelectUser = "SELECT * FROM users WHERE ID_User = ?";
			PreparedStatement selectUserStatement = connection.prepareStatement(sqlSelectUser);
			selectUserStatement.setInt(1, idUser);
			ResultSet resultSet = selectUserStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("ID_User");
				String name = resultSet.getString("Name");
				int age = resultSet.getInt("Age");
				String email = resultSet.getString("Email");
				Integer idPlane = resultSet.getInt("ID_Airplane");
				if (resultSet.wasNull()) {
					idPlane = 0;  // Set to 0 if the value is NULL
				}
				selectedUser = new User(id, name, age, email, idPlane);
			}
	        
		}  catch (SQLException e) {
	    	System.out.println("No se pudo encontrar el usuario con id " + idUser);
	        e.printStackTrace();
	    }
	    
	    System.out.println("Iniciando select. Tiempo estimado, "+ durationSleep);
	    
	    try {
	    	Thread.sleep(durationSleep);
	    }catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    // Terminando seccion critica, liberando mutex.
	    releaseMutex();
	    System.out.println("Seleccionado correctamente usuario " + selectedUser.getName());
	    
	    try {
	    	connection.close();
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return selectedUser;
	}
	
	@Override
	public void deleteUser(int idUser) throws RemoteException {
		// Solicitando Mutex para actuar.
		while(true) {
			if(requestMutex()) {
				System.out.println("¡Permiso Obtenido!");
				break;
			}
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Esperando permiso para iniciar la sección critica..");
		}
		
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/aeroline";
			String username = "root";
			String password_BD = "";
			
			connection = DriverManager.getConnection(url, username, password_BD);
			
			String sqlDeleteUser = "DELETE FROM users WHERE ID_User = ?";
			PreparedStatement deleteUserStatement = connection.prepareStatement(sqlDeleteUser);
			deleteUserStatement.setInt(1, idUser);
			
			deleteUserStatement.executeUpdate();
			peopleBD_copia.removeIf(user -> user.getIdUser() == idUser);
			
		}  catch (SQLException e) {
	    	System.out.println("No se pudo eliminar el usuario con id " + idUser);
	        e.printStackTrace();
	    }
	    
	    System.out.println("Iniciando delete. Tiempo estimado, "+ durationSleep);
	    
	    try {
	    	Thread.sleep(durationSleep);
	    }catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    // Terminando seccion critica, liberando mutex.
	    releaseMutex();
	    System.out.println("Eliminado correctamente usuario " + idUser);
	    
	    try {
	    	connection.close();
	    }catch(SQLException e) {
	    	e.printStackTrace();
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
}