package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void Menu() {}
	
	public int displayMenu() throws NumberFormatException, IOException {
		int opcion = -1;
		System.out.println("BIENVENIDO A AEROLINEA LATAM! :)");
		System.out.println("¿Cuál es su rol?");
		System.out.println("1. Mi rol es Usuario.");
		System.out.println("2. Mi rol es Administrador.");
		System.out.println("3. Para salir.");
        System.out.print("Seleccione una opción: ");
            
        // Leer la opción del usuario
        opcion = Integer.parseInt(br.readLine());
        return opcion;
	}
	
	public int displaySelectUser() throws NumberFormatException, IOException
	{
		System.out.print("Proporcione su id de usuario: ");
		int userID = Integer.parseInt(br.readLine());
        return userID;
	}
	
	public int displayMenuUser() throws NumberFormatException, IOException {
		int opcion = -1;
		System.out.println("BIENVENIDO USUARIO ");
		System.out.println("¿Qué desea hacer hoy?");
		System.out.println("1. Para ver todos los aviones.");
		System.out.println("2. Para agregar usuarios.");
		System.out.println("3. Para inscribirse en un vuelo.");
		System.out.println("4. Para seleccioanr otro rol.");
        System.out.print("Seleccione una opción: ");
            
        // Leer la opción del usuario
        opcion = Integer.parseInt(br.readLine());
        return opcion;
	}
	
	public int displayMenuAdmin() throws NumberFormatException, IOException {
		int opcion = -1;
		System.out.println("BIENVENIDO ADMINISTRADOR");
		System.out.println("¿Qué desea hacer hoy?");
		System.out.println("1. Para ver todos los usuarios.");
		System.out.println("2. Para ver todos los aviones con sus precios en UF.");
		System.out.println("3. Para ver todos los aviones con sus precios en Pesos Chilenos.");
		System.out.println("4. Para agregar Usuario.");
		System.out.println("5. Para mostrar Usuario.");
		System.out.println("6. Para modificar Usuario.");
		System.out.println("7. Para inscribir en vuelo a Usuario.");
		System.out.println("8. Para eliminar Usuario.");
		System.out.println("9. Para seleccioanr otro rol.");
        System.out.print("Seleccione una opción: ");
        
        // Leer la opción del usuario
        opcion = Integer.parseInt(br.readLine());
        return opcion;
	}
}
