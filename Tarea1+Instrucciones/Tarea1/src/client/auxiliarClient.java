package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.Persona;

public class auxiliarClient {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public auxiliarClient() {}
	
	public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void displayClients(ArrayList<Persona> BD) {
		System.out.println("\n\n");
		System.out.println("Personas Registradas:");
		for (int i = 0; i < BD.size(); i++) {
            Persona persona = BD.get(i);
            System.out.println("	- " + persona.getNombre() + " tiene " + persona.getEdad() + " años");
        }
	}
	
	public Persona addPerson() throws IOException {
		System.out.println("\n\n");
		System.out.println("Nueva Persona:");
		Persona person = new Persona(getName(), getAge());
		return person;
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
