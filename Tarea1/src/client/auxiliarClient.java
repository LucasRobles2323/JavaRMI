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
		
	}
	
	public void displayAirplanes(ArrayList<Airplane> BD) {
		
		System.out.println("\nAVIONES\n");
		System.out.println("\n*******************************************");
		
		for (int i = 0; i < BD.size(); i++) {
			Airplane plane = BD.get(i);
			String nombre, phone, destino, origen;
			int id, allseats, freeseats;
			Timestamp takeoff, arrive;
			
			// int
			id = plane.getId_usuario();
			allseats = plane.getAirplane_Seats();
			freeseats = plane.getFree_Seats();
			
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
			System.out.println("Sillas: "+ allseats + "\t Desocupadas: " + freeseats);
			System.out.println("Origen: "+ origen + "\t Salida: " + takeoff);
			System.out.println("Destino: "+ destino + "\t Llegada: " + arrive);
			
			System.out.println("*******************************************\n");
		}
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
