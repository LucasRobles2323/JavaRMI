package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.User;

public class EditData {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public EditData() {}
	
	public static User insertUsers() throws NumberFormatException, IOException{
		System.out.println("Agregar nuevo usuario:");

        System.out.print("Escriba la ID del usuario: ");
        int userId = Integer.parseInt(br.readLine());

        System.out.print("Escriba el nombre: ");
        String name = br.readLine();

        System.out.print("Escriba la edad: ");
        int age = Integer.parseInt(br.readLine());

        System.out.print("Escriba el correo electrónico: ");
        String email = br.readLine();
        
        return new User(userId, name, age, email, 0);
	}
	
	
	public static int selectUser() throws NumberFormatException, IOException { 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("Seleccione un usuario por ID:");
	    int userId = Integer.parseInt(br.readLine());
	    
	   
	    return userId;
	}
	
	public static User updateUser(User user) throws NumberFormatException, IOException {
		// Por hacer, debe pedir un id de usuario por terminal.
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        System.out.print("Escriba el nombre: ");
	        String name = br.readLine();

	        System.out.print("Escriba la edad: ");
	        int age = Integer.parseInt(br.readLine());

	        System.out.print("Escriba el correo electrónico: ");
	        String email = br.readLine();
	        
	        return new User(user.getIdUser(), name, age, email, 0);
		    
		    
	}
	
	public static User updateFlightUser(User user) throws NumberFormatException, IOException {
		  System.out.print("Escriba el id del Avion: ");
	        int vuelo = Integer.parseInt(br.readLine());
	        
	        user.setIdPlane(vuelo);
		
		return user;
	}
	
}
