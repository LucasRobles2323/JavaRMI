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
		
		Display display = new Display();
		
		PriceFlight prices = new PriceFlight (cliente.getUF());
		
		Menu menu = new Menu();
		
		boolean salir = false;
		boolean cambiarRol = true;
		int rol = -1;
		int opcion = -1;
		
		while(!salir) {
            
			if(cambiarRol == true) 
			{
				// Leer el rol del operador
	            rol = menu.displayMenu();
	            switch (rol) {
		            case 1:
		            	// 1. Es Usuario
		            	cambiarRol = false;
		                break;
		            case 2:
		            	// 2. Es Administrador
		            	cambiarRol = false;
		                break;
		            case 3:
		            	// 3. Salir
		            	salir = true;
		                break;
		            default:
		                System.out.println("Opción no válida");
	            }
	            
	            System.out.print("\n");
	            display.clearConsole();
			}
			
			if(salir==true) { break;}
			
			if(rol == 1) // Usuario
			{
				menu.displayMenuUser();
				// Leer opcion seleccionada por usuario
	            opcion = menu.displayMenuUser();
	            switch (opcion) {
		            case 1:
		            	// 1. Ver aviones
		            	
		                break;
		            case 2:
		            	// 2. Agregar Usuario
		            	
		                break;
		            case 3:
		            	// 3. Inscribirse en un vuelo.
		            	
		                break;
		            case 4:
		            	// 4. Para seleccioanr otro rol.
		            	cambiarRol = true;
		                break;
		            default:
		                System.out.println("Opción no válida");
	            }
	            System.out.print("\n");
	            display.clearConsole();
			}
			
			if(rol == 2) // Administrador
			{
				menu.displayMenuAdmin();
				// Leer opcion seleccionada por administrador
	            opcion = menu.displayMenuAdmin();
	            switch (opcion) {
		            case 1:
		            	// 1. Ver usuarios.
		            	
		                break;
		            case 2:
		            	// 2. Ver aviones con pasajeros.
		            	
		                break;
		            case 3:
		            	// 3. Agregar usuarios.
		            	
		                break;
		            case 4:
		            	// 4. Eliminar usuarios.
		            	
		                break;
		            case 5:
		            	// 5. Agregar aviones.
		            	
		                break;
		            case 6:
		            	// 6. Eliminar aviones.
		            	
		                break;
		            case 7:
		            	// 7. Para seleccioanr otro rol.
		            	cambiarRol = true;
		                break;
		            default:
		                System.out.println("Opción no válida");
	            }
	            System.out.print("\n");
	            display.clearConsole();
			}
		}
	}
}
