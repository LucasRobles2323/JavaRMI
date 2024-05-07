package client;
// Aqui se imprime el menu

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.util.ArrayList;

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
			System.out.println("Para ver todos los aviones, presione 1");
			System.out.println("Para ver todos los usuarios, presione 2");
			System.out.println("Para ver todos los aviones con sus pasajeros, presione 3");
			System.out.println("Para gestionar usuarios, presione 4");
			System.out.println("Para gestionar aviones, presione 5");
			System.out.println("Para obtener los valores de la UF, aprete 6. ");
			System.out.println("Para obtener datos de la API, aprete 7. ");
			System.out.println("Para salir, presione 8");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
            
            System.out.print("\n");
			
			switch (opcion) {
            case 1:
            	// 1. Mostrar aviones
            	aux.displayAirplanes( cliente.getAirplaneServer());
                break;
            case 2:
            	// 2. Mostrar usuarios
            	aux.displayUsers( cliente.getPeopleServer());
                break;
            case 3:
            	// 3. Mostrar aviones con pasajeros
                aux.displayAll(cliente.getAirplaneServer(), cliente.getPeopleServer());
                break;
            case 4:
            	// 4. Gestionar Usuarios
            	aux.manageUsers(cliente.getPeopleServer(), cliente.getAirplaneServer());
                break;
            case 5:
            	// 5. Gestionar Pasajeros
            	aux.manageAirplanes(cliente.getAirplaneServer(), cliente.getPeopleServer());
                break;
            case 6:
            	// 6. UF
            	aux.displayUF(cliente.getUF());
                break;
            case 7:
            	// 7. API
            	System.out.println(cliente.getDataFromApi());
                break;
            case 8:
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
