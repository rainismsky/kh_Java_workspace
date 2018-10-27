package day0611.net;

import java.io.*;
import java.net.*;

public class MultiServerThread implements Runnable {
	private Socket socket;
	private MultiServer ms;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public MultiServerThread(MultiServer ms) {
		this.ms = ms;
	}
	
	public synchronized void run() {
		boolean isStop = false;
		try {
			socket = ms.getSocket(); //1번클라이언트와연결된 멀티서버에서 소켓객체 꺼내옴
			ois = new ObjectInputStream(socket.getInputStream());//1번클라이언트와연결된 인풋스트림
			oos = new ObjectOutputStream(socket.getOutputStream()); //1번클라이언트와연결된 아웃풋스트림 각각연결
			String message = null;
			
			while(!isStop) {
				message = (String) ois.readObject(); //1번클라이언트로부터 데이터읽어와서 message에 저장
				String[] str = message.split("#");
				if(str[1].equals("exit")) {
					broadCasting(message);
					isStop=true;
				}else {
					broadCasting(message);
				}
			}
			ms.getList().remove(this); //종료하면 현재스레드객체는 list에서 제거함
			System.out.println(socket.getInetAddress() + "정상적으로 종료하셨습니다.");
			System.out.println("list size: " + ms.getList().size()); //서버에 몇명남았는지 출력
		}catch(Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "비정상적으로 종료하셨습니다.");
			System.out.println("list size : " + ms.getList().size());
		}
	}
	
	public void broadCasting(String message) throws IOException {
		for(MultiServerThread ct : ms.getList()) {
			ct.send(message);
	}
	}
	
	public void send(String message)throws IOException {
		oos.writeObject(message);
	}

}
