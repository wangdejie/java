package a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread implements Runnable {
	private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	private Socket socket;
	private int conNum = 0;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public int getConNum() {
		return conNum;
	}

	public void setConNum(int conNum) {
		this.conNum = conNum;
	}

	public ServerThread(Socket socket, int conNum) {
		super();
		this.socket = socket;
		this.conNum = conNum;
	}

	@Override
	public void run() {

		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);

			System.out.println("IP地址为：" + socket.getInetAddress() + "的用户已连接！当前时间为：" + sdf.format(new Date()));
			dos.writeInt(++conNum);
			Thread.sleep(10000);
			System.out.println("IP地址为：" + socket.getInetAddress() + "的用户连接结束！当前时间为：" + sdf.format(new Date()));

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
