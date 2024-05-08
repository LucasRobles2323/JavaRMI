package client;
// Aqui se imprime el menu

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import common.Airplane;
import common.InterfazDeServer;
import common.User;

public class RunClient {
	
	public static void main(String[] args) throws  NotBoundException, IOException, InterruptedException {
		Client cliente = new Client();
		
		cliente.startClient();
		
		auxiliarClient aux = new auxiliarClient();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean salir = false;
		int opcion = -1;
		
		
		while(!salir) {
			if (opcion != -1) {
				System.out.println("\n\nEspere 2 segundos ...");
				Thread.sleep(2000); //2 segundos
				aux.clearConsole();
			}

			System.out.println("BIENVENIDO A AEROLINEA LATAM! :)");
			System.out.println("¿Qué quiere hacer hoy?");
			System.out.println("1. Para obtener los valores de la UF.");
			System.out.println("2. Para obtener datos de la API.");
			System.out.println("3. Para ver todos los aviones.");
			System.out.println("4. Para ver todos los usuarios.");
			System.out.println("5. Para ver todos los aviones con sus pasajeros.");
			System.out.println("6. Para agregar usuarios.");
			System.out.println("7. Para eliminar usuarios.");
			System.out.println("8. Para agregar aviones.");
			System.out.println("9. Para eliminar aviones.");
			System.out.println("10. Para salir.");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
            
            System.out.print("\n");
			
			switch (opcion) {
            case 1:
            	// 1. UF
            	aux.displayUF(cliente.getUF());
                break;
            case 2:
            	// 2. API
            	System.out.println(cliente.getDataFromApi());
                break;
            case 3:
            	// 3. Mostrar aviones
            	aux.displayAirplanes( cliente.getAirplaneServer());
                break;
            case 4:
            	// 4. Mostrar usuarios
            	aux.displayUsers( cliente.getPeopleServer());
                break;
            case 5:
            	// 5. Mostrar aviones con pasajeros
                aux.displayAll(cliente.getAirplaneServer(), cliente.getPeopleServer());
                break;
            case 6:
            	// 6. Agregar Usuarios
            	ArrayList<Airplane> updatePlane = aux.addAirplane(cliente.getAirplaneServer(), cliente.getPeopleServer());
            	cliente.getAirplaneServer(updatePlane);
                break;
            case 7:
            	// 7 Eliminar Usuarios
                break;
            case 8:
            	// 6. Agregar Avion
            	ArrayList<User> updateUsers = aux.addUsers(cliente.getPeopleServer(), cliente.getAirplaneServer());
            	cliente.setPeopleServer(updateUsers);
                break;
            case 9:
            	// Eliminar Usuarios
                break;
            case 10:
            	// 8. Salir
            	salir = true;
                aux.clearConsole();
                break;
            default:
                System.out.println("Opción no válida");
			}
			
		}
	}
}
