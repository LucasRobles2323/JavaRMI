package common;

import java.io.Serializable;
import java.sql.Timestamp;

import common.InterfazDeServer;

public class Airplane implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private int id_usuario;
    private String name_pilot;
    private String phone_Pilot;
    private int seats;
    private int passengers;
    private Timestamp takeoff_hr;
    private Timestamp arrive_hr;
    private String destination;
    private String origin;
    
    // Constructor
	public Airplane(int id_usuario, String name_pilot, String phone_Pilot, int seats, int passengers,
    				Timestamp takeoff_hr, Timestamp arrive_hr, 
    				String destination, String origin) {
        this.id_usuario = id_usuario;
        this.name_pilot = name_pilot;
        this.phone_Pilot = phone_Pilot;
        this.seats = seats;
        this.passengers = passengers;
        this.takeoff_hr = takeoff_hr;
        this.arrive_hr = arrive_hr;
        this.destination = destination;
        this.origin = origin;
    }

    // Getters
    public int getId_usuario() {
        return this.id_usuario;
    }

    public String getName_pilot() {
        return this.name_pilot;
    }

    public String getPhone_Pilot() {
        return this.phone_Pilot;
    }

    public int getSeats() {
        return this.seats;
    }
    
    public int getPassengers() {
        return this.passengers;
    }

    public Timestamp getTakeoff_hr() {
        return this.takeoff_hr;
    }

    public Timestamp getArrive_hr() {
        return this.arrive_hr;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getOrigin() {
        return this.origin;
    }

    // Setters
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setName_pilot(String name_pilot) {
        this.name_pilot = name_pilot;
    }

    public void setPhone_Pilot(String phone_Pilot) {
        this.phone_Pilot = phone_Pilot;
    }

    public void setseats(int seats) {
        this.seats = seats;
    }
    
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setTakeoff_hr(Timestamp takeoff_hr) {
        this.takeoff_hr = takeoff_hr;
    }

    public void setArrive_hr(Timestamp arrive_hr) {
        this.arrive_hr = arrive_hr;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
