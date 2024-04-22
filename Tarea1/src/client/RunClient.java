package client;
// Aqui se imprime el menu

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Client cliente = new Client();
		
		cliente.startClient();
		
		System.out.println("Clientes Arriba !!"+ cliente.getPersonas());
	}
}
