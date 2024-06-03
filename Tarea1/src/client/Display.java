package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Display {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Display() {}
	
	public static void stopSeconds(int seconds) throws InterruptedException {
		Thread.sleep(seconds); //seconds segundos
	}
	
	public static void clearConsole() throws InterruptedException {
		stopSeconds(3000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void noImplement() throws InterruptedException {
		stopSeconds(4000);
        System.out.println("Esta función se implementara en una version futura del software");
	}
	
}
