package client;
// Aqui se imprime el menu

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import common.Airplane;
import common.InterfazDeServer;
import common.PriceFlight;
import common.User;

public class RunClient {
	
	public static void main(String[] args) throws  NotBoundException, IOException, InterruptedException {
		Client cliente = new Client();
		Display.clearConsole();
		
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
	            Display.clearConsole();
			}
			
			if(salir==true) { break;}
			
			if(rol == 1) // Usuario
			{
				// Leer opcion seleccionada por usuario
	            opcion = menu.displayMenuUser();
	            switch (opcion) {
		            case 1:
		            	// 1. Ver aviones
		            	Display.noImplement();
		                break;
		            case 2:
		            	// 2. Agregar Usuario
		            	Display.noImplement();
		                break;
		            case 3:
		            	// 3. Inscribirse en un vuelo.
		            	Display.noImplement();
		                break;
		            case 4:
		            	// 4. Para seleccioanr otro rol.
		            	cambiarRol = true;
		                break;
		            default:
		                System.out.println("Opción no válida");
	            }
	            System.out.print("\n");
	            Display.clearConsole();
			}
			
			if(rol == 2) // Administrador
			{
				// Leer opcion seleccionada por administrador
	            opcion = menu.displayMenuAdmin();
	            switch (opcion) {
		            case 1:
		            	// 1. Ver usuarios.
		            	Display.noImplement();
		                break;
		            case 2:
		            	// 2. Ver aviones con precio UF.
		            	Display.noImplement();
		                break;
		            case 3:
		            	// 3. Ver aviones con precio en Pesos Chilenos.
		            	Display.noImplement();
		                break;
		            case 4:
		            	// 4. Agregar Usuario.
		            	Display.noImplement();
		                break;
		            case 5:
		            	// 5. Mostrar Usuario.
		            	Display.noImplement();
		                break;
		            case 6:
		            	// 6. Modificar Usuario.
		            	Display.noImplement();
		                break;
		            case 7:
		            	// 5. Inscribir en Vuelo a Usuario.
		            	Display.noImplement();
		                break;
		            case 8:
		            	// 5. Eliminar Usuario.
		            	Display.noImplement();
		                break;
		            case 9:
		            	// 9. Para seleccioanr otro rol.
		            	cambiarRol = true;
		                break;
		            default:
		                System.out.println("Opción no válida");
	            }
	            System.out.print("\n");
	            Display.clearConsole();
			}
		}
	}
}
