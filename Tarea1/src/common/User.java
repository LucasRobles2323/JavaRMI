package common;

import java.io.Serializable;

import common.InterfazDeServer;

public class User implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private int idUser;
    private String name;
    private int age;
    private String email;
    private int idAirplane;
	
    // Constructor
    public User(int Id_User, String Name, int Age, String Email, int idPlane) {
        this.idUser = Id_User;
        this.name = Name;
        this.age = Age;
        this.email = Email;
        this.idAirplane = idPlane;
    }

    // Getters
    public int getIdUser() {
        return this.idUser;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }
    
    public int getIdPlane() {
        return this.idAirplane;
    }

    // Setters
    public void setidUser(int Id_User) {
        this.idUser = Id_User;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setAge(int Age) {
        this.age = Age;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
    
    public void setIdPlane(int idPlane) {
        this.idAirplane = idPlane;
    }
}
