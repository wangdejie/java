package a;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static int conNum = 0;
	
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(20000)) {

			while (true) {
				Socket socket = serverSocket.accept();
				Thread thread = new Thread(new ServerThread(socket,++conNum));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
