package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.User;

public interface InterfazDeServer extends Remote{
	
	ArrayList<User> getPeople() throws RemoteException;
	ArrayList<Airplane> getAirplanes() throws RemoteException;
	Object[] getUF() throws RemoteException;
	
	// INSERT, SELECT, UPDATE, DELETE
	void insertUser(User userNew) throws RemoteException;
    User selectUser(int idUser) throws RemoteException;
    void updateUser(User updatedUser) throws RemoteException;
    void deleteUser(int idUser) throws RemoteException;
    
    // Mutex
    boolean requestMutex() throws RemoteException;
    void releaseMutex() throws RemoteException;
	
}