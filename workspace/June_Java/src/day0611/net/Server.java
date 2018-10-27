package day0611.net;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(10000);
		while (true) {
			Socket sock = server.accept();
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			String cmd = dis.readUTF();
			if (cmd.equals("time")) {
				dos.writeUTF(new Date(System.currentTimeMillis()).toString()); //date객체에 현재시간을 저장하고 toString으로 문자열로바꾼다.
				dos.flush(); 
			}
			dis.close();
			dos.close();
			sock.close();
		}
	}
}
