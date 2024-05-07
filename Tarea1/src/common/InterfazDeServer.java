package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.User;

public interface InterfazDeServer extends Remote{
	ArrayList<User> getPeople() throws RemoteException;
	
	void setPeople(ArrayList<User> updateUsers) throws RemoteException;
	
	ArrayList<Airplane> getAirplanes() throws RemoteException;
	
	public void setAirplanes(ArrayList<Airplane> updateAirplanes) throws RemoteException;

	Object[] getUF() throws RemoteException;

	String getDataFromApi() throws RemoteException;
}
