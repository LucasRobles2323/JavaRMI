package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.User;

public interface InterfazDeServer extends Remote{
	
	ArrayList<User> getPeople() throws RemoteException;
	
	void setUser(User userNew) throws RemoteException;
	
	ArrayList<Airplane> getAirplanes() throws RemoteException;
	
	public void setAirplanes(Airplane newAirplane) throws RemoteException;

	Object[] getUF() throws RemoteException;
}