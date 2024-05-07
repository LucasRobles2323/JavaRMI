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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
			System.out.println("Vuelo: "+ airplaneID);
			
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
					
					System.out.printf(" | %-12s | %-100s |\n", "ID Usuario", "Nombre");
					if(idAirplane == passenger.getIdPlane()) {
						String name;
						int userID;
						// int
						userID = passenger.getIdUser();
						// string
						name = passenger.getName();
						
						
						System.out.printf(" | %-12d | %-100s |\n", userID, name);
					}
				}
			}
			System.out.println("Origen: "+ origen + "\t Salida: " + takeoff);
			System.out.println("Destino: "+ destino + "\t Llegada: " + arrive);
			
			System.out.println("*******************************************\n");
		}
	}
	
	public ArrayList<User> manageUsers() {
		return null;
	}
	
	public ArrayList<Airplane> manageAirplanes() {
		return null;
	}
	
	public String getName() throws IOException {
        System.out.print(" - Escriba el nombre: ");
        return br.readLine();
	}
	
	public int getAge() throws IOException {
        System.out.print(" - Escriba la edad: ");
        return Integer.parseInt(br.readLine());
	}
}
