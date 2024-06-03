package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import common.InterfazDeServer;
import common.User;

public class RunServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
		try {
            InterfazDeServer server = new ServerImpl();
            
            Registry registry = LocateRegistry.createRegistry(4344); // puerto
            registry.bind("serverAerolinea", server);
            
            System.out.println("Conexion exitosa");
            System.out.println("Servidor principal arriba!");
        } catch (RemoteException | AlreadyBoundException | SQLException e) {
            System.err.println("Error al iniciar el servidor principal: " + e.getMessage());
            System.out.println("Intentando iniciar el servidor de respaldo...");
            RunServerRespaldo.main(args);
        }
	}
}