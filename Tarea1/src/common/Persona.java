package common;

import java.io.Serializable;

import common.InterfazDeServer;

public class Persona implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	
	public Persona(String name, int age) {
		this.nombre = name;
		this.edad = age;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
