package common;

import java.io.Serializable;
import java.sql.Timestamp;

import common.InterfazDeServer;

public class Airplane implements Serializable {
	
	public static final long serialVersionUID = 1L;
	private int id_usuario;
    private String name_pilot;
    private String phone_Pilot;
    private int airplane_Seats;
    private int free_Seats;
    private Timestamp takeoff_hr;
    private Timestamp arrive_hr;
    private String destination;
    private String origin;

	public Airplane(int id_usuario, String name_pilot, String phone_Pilot, int airplane_Seats, 
    				int free_Seats, Timestamp takeoff_hr, Timestamp arrive_hr, 
    				String destination, String origin) {
        this.id_usuario = id_usuario;
        this.name_pilot = name_pilot;
        this.phone_Pilot = phone_Pilot;
        this.airplane_Seats = airplane_Seats;
        this.free_Seats = free_Seats;
        this.takeoff_hr = takeoff_hr;
        this.arrive_hr = arrive_hr;
        this.destination = destination;
        this.origin = origin;
    }

    // Getters
    public int getId_usuario() {
        return id_usuario;
    }

    public String getName_pilot() {
        return name_pilot;
    }

    public String getPhone_Pilot() {
        return phone_Pilot;
    }

    public int getAirplane_Seats() {
        return airplane_Seats;
    }

    public int getFree_Seats() {
        return free_Seats;
    }

    public Timestamp getTakeoff_hr() {
        return takeoff_hr;
    }

    public Timestamp getArrive_hr() {
        return arrive_hr;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
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

    public void setAirplane_Seats(int airplane_Seats) {
        this.airplane_Seats = airplane_Seats;
    }

    public void setFree_Seats(int free_Seats) {
        this.free_Seats = free_Seats;
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
