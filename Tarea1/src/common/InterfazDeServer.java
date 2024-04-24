package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.User;

public interface InterfazDeServer extends Remote{
	ArrayList<User> getPeople() throws RemoteException;
	
	void setPerson(User person) throws RemoteException;
}
