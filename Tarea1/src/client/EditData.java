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
	
	public static int selectUser() {
		// Por hacer, debe pedir un id de usuario por terminal.
		
		return 0;
	}
	
	public static User updateUser(User user) {
		// Por hacer, debe pedir un id de usuario por terminal.
		
		return null;
	}
	
	public static User updateFlightUser(User user) {
		// Por hacer, debe pedir un id de usuario por terminal.
		
		return null;
	}
	
}
