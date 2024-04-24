package common;

import java.io.Serializable;

import common.InterfazDeServer;

public class User implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getNombre() {
		return this.name;
	}
	public void setNombre(String nombre) {
		this.name = nombre;
	}
	
	public int getEdad() {
		return this.age;
	}
	
	public void setEdad(int edad) {
		this.age = edad;
	}
}
