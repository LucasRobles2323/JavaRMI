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
			
			System.out.println("1. Mostrar Personas Registradas");
			System.out.println("2. Registrar Nueva Persona");
			System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
            case 1:
            	// 1. Mostrar Personas Registradas
            	aux.displayClients( cliente.getPeopleServer() );
                break;
            case 2:
            	// 2. Registrar Nueva Persona
            	cliente.setPersonServer( aux.addPerson() );
                break;
            case 3:
            	// 3. Salir
                salir = true;
                aux.clearConsole();
                break;
            default:
                System.out.println("Opción no válida");
			}
		
		}
		
	}
}
