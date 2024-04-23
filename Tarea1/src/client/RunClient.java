package client;
// Aqui se imprime el menu

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.Persona;

public class RunClient {
	public static void main(String[] args) throws  NotBoundException, IOException {
		Client cliente = new Client();
		auxiliarClient aux = new auxiliarClient();
		
		cliente.startClient();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nombre = br.readLine();
		
		boolean salir = false;
		int opcion = 3;
		
		
		while(!salir) {
			System.out.println("1. Mostrar Personas Registradas");
			System.out.println("2. Registrar Nueva Persona");
			System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = Integer.parseInt(br.readLine());
			
			switch (opcion) {
            case 1:
            	// 1. Mostrar Personas Registradas
                System.out.println("Aun no implementada");
                break;
            case 2:
            	// 2. Mostrar Personas Registradas
            	System.out.println("Aun no implementada");
                break;
            case 3:
            	// 3. Salir
                salir = true;
                break;
            default:
                System.out.println("Opción no válida");
			}
			
			aux.clearConsole();
		}
		
	}
}
