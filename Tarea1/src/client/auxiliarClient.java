package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class auxiliarClient {
	
	public auxiliarClient() {}
	
	public static void clearConsole() {
        try {
        	final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Si estamos en Windows, utiliza "cls"
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Si estamos en Unix/Linux/Mac, utiliza "clear"
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Si no se puede limpiar la consola, simplemente imprime una línea vacía
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
	}
}
