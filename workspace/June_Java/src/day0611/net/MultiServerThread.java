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
			socket = ms.getSocket(); //1��Ŭ���̾�Ʈ�Ϳ���� ��Ƽ�������� ���ϰ�ü ������
			ois = new ObjectInputStream(socket.getInputStream());//1��Ŭ���̾�Ʈ�Ϳ���� ��ǲ��Ʈ��
			oos = new ObjectOutputStream(socket.getOutputStream()); //1��Ŭ���̾�Ʈ�Ϳ���� �ƿ�ǲ��Ʈ�� ��������
			String message = null;
			
			while(!isStop) {
				message = (String) ois.readObject(); //1��Ŭ���̾�Ʈ�κ��� �������о�ͼ� message�� ����
				String[] str = message.split("#");
				if(str[1].equals("exit")) {
					broadCasting(message);
					isStop=true;
				}else {
					broadCasting(message);
				}
			}
			ms.getList().remove(this); //�����ϸ� ���罺���尴ü�� list���� ������
			System.out.println(socket.getInetAddress() + "���������� �����ϼ̽��ϴ�.");
			System.out.println("list size: " + ms.getList().size()); //������ ����Ҵ��� ���
		}catch(Exception e) {
			ms.getList().remove(this);
			System.out.println(socket.getInetAddress() + "������������ �����ϼ̽��ϴ�.");
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
