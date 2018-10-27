package day0611.net;
import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	private ArrayList<MultiServerThread> list; //thread만 담을수있는 list
	private Socket socket;
	public MultiServer() throws IOException{
		list = new ArrayList<MultiServerThread>();
		ServerSocket serverSocket = new ServerSocket(3333);
		MultiServerThread mst = null;
		boolean isStop = false;
		
		while(!isStop) {
			System.out.println("Server ready");
			socket = serverSocket.accept();
			mst = new MultiServerThread(this);
			list.add(mst); //리스트에 thread를 추가시킨다
			Thread t = new Thread(mst);
			t.start();
		}
		
	}
	
	public ArrayList<MultiServerThread> getList(){
		return list;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public static void main(String[] args)throws IOException{
		new MultiServer();
	}
}
