package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import common.Persona;

public class auxiliarClient {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<Persona> BD_personas;
	
	public auxiliarClient(ArrayList<Persona> BD) {
		this.BD_personas = BD;
	}
	
	public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void displayClients() {
		for (int i = 0; i < this.BD_personas.size(); i++) {
            Persona persona = this.BD_personas.get(i);
            System.out.println("- " + persona.getNombre() + " tiene " + persona.getEdad() + " años");
        }
	}
	
	public void addPerson() throws IOException {
		this.BD_personas.add( new Persona(getName(), getAge()) );
	}
	
	public String getName() throws IOException {
        System.out.print("Escriba el nombre: ");
        return br.readLine();
	}
	
	public int getAge() throws IOException {
        System.out.print("Escriba la edad: ");
        return Integer.parseInt(br.readLine());
	}
}
