package a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Clinet {

	public static void main(String[] args) {
		try (Socket socket = new Socket()) {

			socket.connect(new InetSocketAddress("127.0.0.1", 20000));

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);

			System.out.println("Sever�����ӳɹ������ǵ�" + dis.readInt() + "�����ӵ��û�");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
