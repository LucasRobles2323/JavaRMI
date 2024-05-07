package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.Airplane;
import common.User;

public class auxiliarClient {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public auxiliarClient() {}
	
	public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void displayUsers(ArrayList<User> BD) {
		System.out.println("\nUSUARIOS DE AEROLINEA\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < BD.size(); i++) {
			User passenger = BD.get(i);
			String nombre, email;
			int userID, airplaneID, edad;
			
			// int
			userID = passenger.getIdUser();
			airplaneID = passenger.getIdPlane();
			edad = passenger.getAge();
			
			// string
			nombre = passenger.getName();
			email = passenger.getEmail();
			
			System.out.println("ID Usuario: "+ userID);
			System.out.println("Nombre: " + nombre);
			System.out.println("Correo: " + email + "\t Edad: " + edad);
			if(airplaneID == -1) {
				System.out.println("Su vuelo fue eliminado.");
			}
			else {
				System.out.println("Vuelo: "+ airplaneID);
			}
			
			
			System.out.println("*******************************************\n");
		}
	}
	
	public void displayAirplanes(ArrayList<Airplane> BD) {
		
		System.out.println("\nAVIONES\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < BD.size(); i++) {
			Airplane plane = BD.get(i);
			String nombre, phone, destino, origen;
			int id, seats, passengers;
			Timestamp takeoff, arrive;
			
			// int
			id = plane.getId_usuario();
			seats = plane.getSeats();
			passengers = plane.getPassengers();
			
			// string
			nombre = plane.getName_pilot();
			phone = plane.getPhone_Pilot();
			destino = plane.getDestination();
			origen = plane.getOrigin();
			
			// Timestamp
			takeoff = plane.getTakeoff_hr();
			arrive = plane.getArrive_hr();
			
			System.out.println("ID Avion: "+ id);
			System.out.println("Piloto:\tNombre: " + nombre + "\t Telefono: " + phone);
			System.out.println("Asientos: "+ seats + "\t Disponibes: " + (seats - passengers));
			System.out.println("Origen: "+ origen + "\t Salida: " + takeoff);
			System.out.println("Destino: "+ destino + "\t Llegada: " + arrive);
			
			System.out.println("*******************************************\n");
		}
	}
	
	public void displayAll(ArrayList<Airplane> planesBD, ArrayList<User> usersBD) {
		System.out.println("\nAVIONES\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < planesBD.size(); i++) {
			Airplane plane = planesBD.get(i);
			String nombre, phone, destino, origen;
			int idAirplane, seats, passengers;
			Timestamp takeoff, arrive;
			
			// int
			idAirplane = plane.getId_usuario();
			seats = plane.getSeats();
			passengers = plane.getPassengers();
			
			// string
			nombre = plane.getName_pilot();
			phone = plane.getPhone_Pilot();
			destino = plane.getDestination();
			origen = plane.getOrigin();
			
			// Timestamp
			takeoff = plane.getTakeoff_hr();
			arrive = plane.getArrive_hr();
			
			System.out.println("ID Avion: "+ idAirplane);
			System.out.println("Piloto:\tNombre: " + nombre + "\t Telefono: " + phone);
			System.out.println("Asientos: "+ seats);
			
			System.out.println("Pasajeros: "+ seats);
			if (passengers == 0) {
				System.out.println("Ninguno");
			}
			else {
				for (int j = 0; j < usersBD.size(); j++) {
					User passenger = usersBD.get(j);
					
					System.out.printf(" | %-12s | %-50s |\n", "ID Usuario", "Nombre");
					if(idAirplane == passenger.getIdPlane()) {
						String name;
						int userID;
						// int
						userID = passenger.getIdUser();
						// string
						name = passenger.getName();
						
						
						System.out.printf(" | %-12d | %-50s |\n", userID, name);
					}
				}
			}
			System.out.println("Origen: "+ origen + "\t Salida: " + takeoff);
			System.out.println("Destino: "+ destino + "\t Llegada: " + arrive);
			
			System.out.println("*******************************************\n");
		}
	}
	
	public void displayUF(Object[] ufValues) {
		if(ufValues == null) 
		{
			System.out.println("Hubo un error, no llego nada de la API");
		} 
		else 
		{
			String codigo = (String) ufValues[0];
			String nombre = (String) ufValues[1];
			String fecha = (String) ufValues[2];
			String unidad_medida = (String) ufValues[3];
			double valor = (double) ufValues[4];
			
			System.out.println("Los valores obtenidos para la UF son:");
			System.out.println("	Codigo: "+ codigo + "  Nombre: " + nombre);
			System.out.println("	Fecha: " + fecha + " ");
			System.out.println("	Unidad de Medida: " + unidad_medida + "  Valor: " + valor);
		}
	}
	
	public void manageUsers(ArrayList<User> usersBD, ArrayList<Airplane> planesBD) throws InterruptedException, NumberFormatException, IOException {
		clearConsole();
		
		boolean salir = false;
		int opcion = -1;
		
		
		while(!salir) {
			if (opcion != -1) {
				System.out.println("\n\nEspere 2 segundos ...");
				Thread.sleep(2000); //2 segundos
				clearConsole();
			}

			System.out.println("Gestionar Usuarios");
			System.out.println("¿Qué quiere hacer hoy?");
			System.out.println("Para agregar un nuevo usuario, presione 1");
			System.out.println("Para editar un usuario existente, presione 2");
			System.out.println("Para eliminar un usuario, presione 3");
			System.out.println("Para salir, presione 4");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
            case 1:
            	// 1. Agregar Usuario
            	
                break;
            case 2:
            	// 2. Editar Usuario
            	
                break;
            case 3:
            	// 3. Eliminar usuario
                
                break;
            case 4:
            	// 4. Salir
            	salir = true;
                clearConsole();
                break;
            default:
                System.out.println("Opción no válida");
			}
		}
	}
	
	public void manageAirplanes(ArrayList<Airplane> planesBD, ArrayList<User> usersBD) throws InterruptedException, NumberFormatException, IOException {
		clearConsole();
		
		boolean salir = false;
		int opcion = -1;
		
		
		while(!salir) {
			if (opcion != -1) {
				System.out.println("\n\nEspere 2 segundos ...");
				Thread.sleep(2000); //2 segundos
				clearConsole();
			}

			System.out.println("Gestionar Usuarios");
			System.out.println("¿Qué quiere hacer hoy?");
			System.out.println("Para agregar un nuevo avion, presione 1");
			System.out.println("Para editar un avion existente, presione 2");
			System.out.println("Para eliminar un avion, presione 3");
			System.out.println("Para salir, presione 4");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
            case 1:
            	// 1. Agregar Avion
            	
                break;
            case 2:
            	// 2. Editar Avion
            	
                break;
            case 3:
            	// 3. Eliminar Avion
                
                break;
            case 4:
            	// 4. Salir
            	salir = true;
                clearConsole();
                break;
            default:
                System.out.println("Opción no válida");
			}
		}
	}

	
}
