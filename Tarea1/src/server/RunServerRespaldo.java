package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import common.InterfazDeServer;

public class RunServerRespaldo {
    public static void main(String[] args) throws SQLException {
        try {
            InterfazDeServer server = new ServerImpl();
            
            Registry registry = LocateRegistry.createRegistry(4345); // puerto alternativo para el respaldo
            registry.bind("serverAerolineaRespaldo", server);
            
            System.out.println("Conexion exitosa");
            System.out.println("Servidor de respaldo arriba!");
        } catch (RemoteException | AlreadyBoundException | SQLException e) {
            System.err.println("Error al iniciar el servidor de respaldo: " + e.getMessage());
        }
    }
}