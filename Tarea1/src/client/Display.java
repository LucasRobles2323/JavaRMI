package client;

import java.sql.Timestamp;
import java.util.ArrayList;

import common.Airplane;
import common.PriceFlight;
import common.User;

public class Display {	
	
	public Display() {}
	
	public static void stopSeconds(int seconds) throws InterruptedException {
		Thread.sleep(seconds); //seconds segundos
	}
	
	public static void clearConsole() throws InterruptedException {
		stopSeconds(3000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void noImplement() throws InterruptedException {
		stopSeconds(4000);
        System.out.println("Esta función se implementara en una version futura del software");
	}
	
	public static void oneUser(User passenger) {
		String nombre, email;
		int userID, airplaneID, edad;
			
		// int
		userID = passenger.getIdUser();
		airplaneID = passenger.getIdPlane();
		edad = passenger.getAge();
		
		// string
		nombre = passenger.getName();
		email = passenger.getEmail();
		
		System.out.println("\n-------------------------------------------");
		System.out.println("ID Usuario: "+ userID);
		System.out.println("Nombre: " + nombre);
		System.out.println("Correo: " + email + "\t Edad: " + edad);
		if(airplaneID < 1) {
			System.out.println("No tiene ningun vuelo asignado.");
		}
		else {
			System.out.println("Vuelo: "+ airplaneID);
		}
		System.out.println("\n-------------------------------------------");
	}
	
	public static void users(ArrayList<User> BD) {
		System.out.println("\nUSUARIOS DE AEROLINEA\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < BD.size(); i++) {
			oneUser(BD.get(i));
		}
				
		System.out.println("*******************************************");
	}
	
	public static void airplanesUF(ArrayList<Airplane> planesBD, ArrayList<User> usersBD) {
		System.out.println("\nAVIONES\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < planesBD.size(); i++) {
			Airplane plane = planesBD.get(i);
			String nombre, phone, destino, origen;
			int idAirplane, seats;
			Timestamp takeoff, arrive;
			
			// int
			idAirplane = plane.getAirplaneID();
			seats = plane.getSeats();
			
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
			
			System.out.print("Pasajeros: ");
			
			boolean havePassenger = false;
			for (int k = 0; k < usersBD.size(); k++) {
				User passenger = usersBD.get(k);
				
				if(idAirplane == passenger.getIdPlane()) {
					havePassenger = true;
					break;
				}
			}
			
			if (!havePassenger) {
				System.out.println("No tiene ningun pasajero asignado.");
			}
			else {
				System.out.printf("\n | %-12s | %-50s |\n", "ID Usuario", "Nombre");
				for (int j = 0; j < usersBD.size(); j++) {
					User passenger = usersBD.get(j);
					
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
			
			System.out.println("*******************************************");
		}
	}
	
	public static void airplanesCLP(ArrayList<Airplane> planesBD, ArrayList<User> usersBD, 
									PriceFlight prices) {
		// Falta implementar
	}
	
}
